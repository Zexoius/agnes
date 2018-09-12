package top.zexus.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbPanelContentMapper;
import top.zexus.common.mapper.TbPanelMapper;
import top.zexus.common.mapper.TbProductDetailMapper;
import top.zexus.common.mapper.TbProductMapper;
import top.zexus.common.pojo.*;
import top.zexus.common.pojo.dto.AllGoodsResult;
import top.zexus.common.utils.Result;
import top.zexus.common.utils.DtoUtils;
import top.zexus.common.pojo.dto.Goods;
import top.zexus.common.pojo.dto.GoodsDetail;
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
    @Resource
    TbProductMapper tbProductMapper;
    @Resource
    TbProductDetailMapper tbProductDetailMapper;
    @Resource
    TbPanelMapper tbPanelMapper;
    @Resource
    TbPanelContentMapper tbPanelContentMapper;

    @Override
    public Result goodsDetail(Long goodsId) {
        TbProduct tbProduct = tbProductMapper.selectByPrimaryKey(goodsId);
        GoodsDetail detail = new GoodsDetail();
        detail.setGoodsId(goodsId);
        detail.setTitle(tbProduct.getTitle());
        detail.setDescription(tbProduct.getSellPoint());
        detail.setPrice(tbProduct.getPrice());
        TbProductDetail tbProductDetail = tbProductDetailMapper.selectByPrimaryKey(goodsId);
        detail.setDetail(tbProductDetail.getItemDesc());
        if (tbProduct.getImage()!=null && !tbProduct.getImage().isEmpty()){
            String images[] = tbProduct.getImage().split(",");
            detail.setProductImageBig(images[0]);
            List list = new ArrayList();
            for (int i=0;i<images.length;i++){
                list.add(images[i]);
            }
            detail.setProductImageSmall(list);
        }
        return Result.ok()
                .put("productDetail",detail);
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
                .put("allGoodsResult", allGoodsResult);
    }

    @Override
    public Result getHome() {
        List<TbPanel> list = new ArrayList<>();
        TbPanelExample example = new TbPanelExample();
        TbPanelExample.Criteria criteria = example.createCriteria();
//        查询条件
        criteria.andPositionEqualTo(0);
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("sort_order");
        list = tbPanelMapper.selectByExample(example);
        for (TbPanel tbPanel : list){
            TbPanelContentExample contentExample = new TbPanelContentExample();
            contentExample.setOrderByClause("sort_order");
            TbPanelContentExample.Criteria contentCriteria = contentExample.createCriteria();
//            查询条件
            contentCriteria.andPanelIdEqualTo(tbPanel.getId());
            List<TbPanelContent> contentList = tbPanelContentMapper.selectByExample(contentExample);
            for (TbPanelContent content : contentList){
                if (content.getProductId() != null){
                    TbProduct tbProduct = tbProductMapper.selectByPrimaryKey(content.getProductId());
                    content.setProductName(tbProduct.getTitle());
                    content.setSalePrice(tbProduct.getPrice());
                    content.setSubTitle(tbProduct.getSellPoint());
                }
            }
            tbPanel.setPanelContents(contentList);
        }
        return Result.ok()
                .put("panelList",list);
    }
}
