package top.zexus.manager.domain;

import top.zexus.common.pojo.TbProduct;
import top.zexus.common.pojo.TbUser;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:57 2018/7/30
 */
public class DtoUtils {
    public static User TbUser2User(TbUser tbUser){

        User user =new User();
        user.setId(tbUser.getId());
        user.setUsername(tbUser.getUsername());
        user.setPhone(tbUser.getPhone());
        user.setSex(tbUser.getSex());
        return user;
    }

    public static Goods TbGoods2Goods(TbProduct tbProduct){
        Goods goods = new Goods();

        goods.setProductId(tbProduct.getId());
        goods.setSubTitle(tbProduct.getDesciption());
        goods.setProductName(tbProduct.getTitle());
        goods.setSalePrice(tbProduct.getPrice());
        goods.setProductImageBig(tbProduct.getImage());

        return goods;
    }
}
