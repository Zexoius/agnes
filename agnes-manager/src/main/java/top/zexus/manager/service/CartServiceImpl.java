package top.zexus.manager.service;

import org.springframework.stereotype.Service;
import top.zexus.common.utils.Result;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:21 2018/8/26
 */
@Service
public class CartServiceImpl implements CartService{
    @Override
    public Result addCart(long userId, long goodsId, int num) {
        return null;
    }

    @Override
    public Result delCartListItem(long userId, long goodsId) {
        return null;
    }

    @Override
    public Result getCartList(long userId, long goodsId) {
        return null;
    }

    @Override
    public Result checkAll(long userId, String checked) {
        return null;
    }

    @Override
    public Result delChecked(long userId) {
        return null;
    }

    @Override
    public Result updateCartNum(long userId, long goodsId, int num, String checked) {
        return null;
    }
}
