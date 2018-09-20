package top.zexus.common.utils;

import top.zexus.common.pojo.TbProduct;
import top.zexus.common.pojo.TbUser;
import top.zexus.common.pojo.dto.CartList;
import top.zexus.common.pojo.dto.Goods;
import top.zexus.common.pojo.dto.User;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:57 2018/7/30
 */
public class DtoUtils {
    public static User TbUser2User(TbUser tbUser) {

        User user = new User();
        user.setId(tbUser.getId());
        user.setUsername(tbUser.getUsername());
        user.setPhone(tbUser.getPhone());
        user.setSex(tbUser.getSex());
        user.setAvator(tbUser.getImg());
        return user;
    }

    public static Goods TbGoods2Goods(TbProduct tbProduct) {
        Goods goods = new Goods();

        goods.setProductId(tbProduct.getId());
        goods.setSubTitle(tbProduct.getSellPoint());
        goods.setProductName(tbProduct.getTitle());
        goods.setSalePrice(tbProduct.getPrice());
        goods.setProductImageBig(tbProduct.getImages()[0]);

        return goods;
    }

    public static CartList TbGoods2CartList(TbProduct tbProduct) {
        CartList cartList = new CartList();
        cartList.setGoodsId(tbProduct.getId());
        cartList.setGoodsName(tbProduct.getTitle());
        cartList.setSalePrice(tbProduct.getPrice());
        cartList.setProductImg(tbProduct.getImages()[0]);
        return cartList;
    }
}
