package top.zexus.manager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbProductMapper;
import top.zexus.common.pojo.AllGoodsResult;
import top.zexus.common.pojo.TbProduct;
import top.zexus.common.utils.Result;
import top.zexus.manager.domain.DtoUtils;
import top.zexus.manager.domain.Goods;

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

    public Result getAllGoods(int page, int size, String sort, Long cid, int priceGt, int priceLt) {
        String orderCol="created";
        String orderDir="desc";
        AllGoodsResult allGoodsResult = new AllGoodsResult();
        List<Goods> list = new ArrayList<Goods>();
//        分页执行查询返回结果
        if (page <= 0){
            page = 1;
        }
        PageHelper.startPage(page,size);

        if (sort.equals("1")){
            orderCol = "price";
            orderDir = "asc";
        }else if (sort.equals("-1")){
            orderCol = "price";
            orderDir = "desc";
        }else {
            orderCol = "created";
            orderDir = "desc";
        }

        List<TbProduct> tbProductList = tbProductMapper.selectGoodsFront(cid,orderCol,orderDir,priceGt,priceLt);
        PageInfo<TbProduct> pageInfo = new PageInfo<TbProduct>(tbProductList);

        for (TbProduct tbProduct: tbProductList){
            Goods goods = DtoUtils.TbGoods2Goods(tbProduct);
            list.add(goods);
        }

        allGoodsResult.setData(list);
        allGoodsResult.setTotal((int)pageInfo.getTotal());

        return Result.ok()
                .put("allGoodsResult",allGoodsResult);
    }
}
