package top.zexus.manager.service;

import top.zexus.common.utils.Result;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:20 2018/8/26
 */
public interface CartService {
    /**
     * 添加
     *
     * @param userId
     * @param goodsId
     * @param num
     * @return
     */
    int addCart(long userId, long goodsId, int num);

    /**
     * 删除单个
     *
     * @param userId
     * @param goodsId
     * @return
     */
    int delCartListItem(long userId, long goodsId);

    /**
     * 获取
     *
     * @param userId
     * @return
     */
    Result getCartList(long userId);

    /**
     * 全选
     *
     * @param userId
     * @param checked
     * @return
     */
    Result checkAll(long userId, String checked);

    /**
     * 删除已选
     *
     * @param userId
     * @return
     */
    Result delChecked(long userId);

    /**
     * 更新
     *
     * @param userId
     * @param goodsId
     * @param num
     * @param checked
     * @return
     */
    Result updateCartNum(long userId, long goodsId, int num, String checked);
}
