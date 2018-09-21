package top.zexus.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbPanelContentMapper;
import top.zexus.common.mapper.TbPanelMapper;
import top.zexus.common.mapper.TbProductDetailMapper;
import top.zexus.common.mapper.TbProductMapper;
import top.zexus.common.pojo.*;
import top.zexus.common.pojo.dto.AllGoodsResult;
import top.zexus.common.pojo.dto.Goods;
import top.zexus.common.pojo.dto.GoodsDetail;
import top.zexus.common.utils.DtoUtils;
import top.zexus.common.utils.Result;
import top.zexus.manager.Redis.RedisClient;
import top.zexus.manager.service.GoodsService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:04 2018/8/14
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    private final String HOME = "HOME";
    private final String PRODUCT_DET = "PRODUCT_DET";
    @Resource
    TbProductMapper tbProductMapper;
    @Resource
    TbProductDetailMapper tbProductDetailMapper;
    @Resource
    TbPanelMapper tbPanelMapper;
    @Resource
    TbPanelContentMapper tbPanelContentMapper;
    @Resource
    private RedisClient redisClient;

    @Override
    public Result goodsDetail(Long goodsId) {
        try {
            String json = redisClient.get(PRODUCT_DET + ":" + goodsId);
            if (json != null) {
                GoodsDetail goodsDetail = new Gson().fromJson(json, GoodsDetail.class);
                System.out.println("读取商品详情缓存");
//                redisClient.expire(PRODUCT_DET + ":" + goodsId,EXPIRE_TIME);
                return Result.ok()
                        .put("goodsDetail", goodsDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbProduct tbProduct = tbProductMapper.selectByPrimaryKey(goodsId);
        GoodsDetail detail = new GoodsDetail();
        detail.setGoodsId(goodsId);
        detail.setTitle(tbProduct.getTitle());
        detail.setDescription(tbProduct.getSellPoint());
        detail.setSaleprice(tbProduct.getPrice());
        TbProductDetail tbProductDetail = tbProductDetailMapper.selectByPrimaryKey(goodsId);
        detail.setDetail(tbProductDetail.getItemDesc());
        if (tbProduct.getImage() != null && !tbProduct.getImage().isEmpty()) {
            String images[] = tbProduct.getImage().split(",");
            detail.setProductImageBig(images[0]);
            List list = new ArrayList();
            for (int i = 0; i < images.length; i++) {
                list.add(images[i]);
            }
            detail.setProductImageSmall(list);
        }
        try {
            redisClient.set(PRODUCT_DET + ":" + goodsId, new Gson().toJson(detail));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.ok()
                .put("goodsDetail", detail);
    }

    @Override
    public Result getAllGoods(int page, int size, String sort, Long cid, int priceGt, int priceLt) {
        String orderCol = "created";
        String orderDir = "desc";
        AllGoodsResult allGoodsResult = new AllGoodsResult();
        List<Goods> list = new ArrayList<Goods>();
//        分页执行查询返回结果
        if (page <= 0) {
            page = 1;
        }
        PageHelper.startPage(page, size);

        if (sort.equals("1")) {
            orderCol = "price";
            orderDir = "asc";
        } else if (sort.equals("-1")) {
            orderCol = "price";
            orderDir = "desc";
        } else {
            orderCol = "created";
            orderDir = "desc";
        }

        List<TbProduct> tbProductList = tbProductMapper.selectGoodsFront(cid, orderCol, orderDir, priceGt, priceLt);
        PageInfo<TbProduct> pageInfo = new PageInfo<TbProduct>(tbProductList);

        for (TbProduct tbProduct : tbProductList) {
            Goods goods = DtoUtils.TbGoods2Goods(tbProduct);
            list.add(goods);
        }

        allGoodsResult.setData(list);
        allGoodsResult.setTotal((int) pageInfo.getTotal());

        return Result.ok()
                .put("result", allGoodsResult);
    }

    @Override
    public Result getHome() {
        List<TbPanel> list = new ArrayList<>();
//       读取缓存
        try {
            String json = redisClient.get(HOME);
            if (json != null) {
                list = new Gson().fromJson(json, new TypeToken<List<TbPanel>>() {
                }.getType());
                System.out.println("读取首页缓存");
                return Result.ok()
                        .put("home", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TbPanelExample example = new TbPanelExample();
        TbPanelExample.Criteria criteria = example.createCriteria();
//        查询条件
//        0：首页  1：商品推荐
        criteria.andPositionEqualTo(0);
//        就绪状态：1
        criteria.andStatusEqualTo(1);
//        按字段名排序
//        order:顺序  clause:字段
        example.setOrderByClause("sort_order");
        list = tbPanelMapper.selectByExample(example);
        for (TbPanel tbPanel : list) {
            TbPanelContentExample contentExample = new TbPanelContentExample();
            contentExample.setOrderByClause("sort_order");
            TbPanelContentExample.Criteria contentCriteria = contentExample.createCriteria();
//            查询条件
            contentCriteria.andPanelIdEqualTo(tbPanel.getId());
            List<TbPanelContent> contentList = tbPanelContentMapper.selectByExample(contentExample);
            for (TbPanelContent content : contentList) {
                if (content.getProductId() != null) {
                    TbProduct tbProduct = tbProductMapper.selectByPrimaryKey(content.getProductId());
                    content.setProductName(tbProduct.getTitle());
                    content.setSalePrice(tbProduct.getPrice());
                    content.setSubTitle(tbProduct.getSellPoint());
                }
            }
            tbPanel.setPanelContents(contentList);
        }
//        添加缓存
        try {
            redisClient.set(HOME, new Gson().toJson(list));
            System.out.println("添加首页缓存");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.ok()
                .put("home", list);
    }
}
