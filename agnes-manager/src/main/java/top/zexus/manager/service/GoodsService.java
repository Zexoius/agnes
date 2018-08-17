package top.zexus.manager.service;

import top.zexus.common.utils.Result;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:43 2018/8/14
 */
public interface GoodsService {

    /**
     * 分页多条件获取商品
     * @param page
     * @param size
     * @param sort
     * @param cid
     * @param priceGt
     * @param priceLt
     * @return
     */
    Result getAllGoods(int page,int size,String sort,Long cid,int priceGt,int priceLt);
}
