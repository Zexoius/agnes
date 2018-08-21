package top.zexus.manager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbProductDetailMapper;
import top.zexus.common.mapper.TbProductMapper;
import top.zexus.common.pojo.AllGoodsResult;
import top.zexus.common.pojo.TbProduct;
import top.zexus.common.pojo.TbProductDetail;
import top.zexus.common.utils.Result;
import top.zexus.manager.Dto.DtoUtils;
import top.zexus.manager.Dto.Goods;
import top.zexus.manager.Dto.GoodsDetail;

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

    public Result goodsDetail(Long goodsId) {
        TbProduct tbProduct = tbProductMapper.selectByPrimaryKey(goodsId);
        GoodsDetail detail = new GoodsDetail();
        detail.setGoodsId(goodsId);
        detail.setTitle(tbProduct.getTitle());
        detail.setDescription(tbProduct.getDesciption());
        detail.setPrice(tbProduct.getPrice());
        TbProductDetail tbProductDetail = tbProductDetailMapper.selectByPrimaryKey(goodsId);
        detail.setDetail(tbProductDetail.getGoodsDetail());
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
}
