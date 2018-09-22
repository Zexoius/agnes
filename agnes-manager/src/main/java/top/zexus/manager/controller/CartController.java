package top.zexus.manager.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.zexus.common.pojo.dto.Cart;
import top.zexus.common.utils.Result;
import top.zexus.manager.service.CartService;

import javax.annotation.Resource;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:21 2018/8/26
 */
@RequestMapping(value = "/cart")
@RestController
public class CartController {
    @Resource
    private CartService cartService;

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public Result addCart(@RequestBody Cart cart) {
        int result = cartService.addCart(cart.getUserId(), cart.getGoodsId(), cart.getGoodsNum());
        System.out.println("添加购物车");
        return Result.ok()
                .put("cartList", result);
    }

    @RequestMapping(value = "/cartDel", method = RequestMethod.POST)
    public Result delCartItem(@RequestBody Cart cart) {
        int result = cartService.delCartListItem(cart.getUserId(), cart.getGoodsId());
        System.out.println("删除购物车");
        return Result.ok()
                .put("result", result);
    }

    @RequestMapping(value = "/delCartChecked",method = RequestMethod.POST)
    public Result delChecked(@RequestBody Cart cart){
        Result result = cartService.delChecked(cart.getUserId());
        System.out.println("----删除选中----");
        return result;
    }

    @RequestMapping(value = "/cartList", method = RequestMethod.POST)
    public Result getCartList(@RequestBody Cart cart) {
        Result result = cartService.getCartList(cart.getUserId());
        System.out.println("------获取购物车-----");
        return result;
    }

    @RequestMapping(value = "/isChecked",method = RequestMethod.POST)
    public Result isChecked(@RequestBody Cart cart){
        Result result = cartService.checkAll(cart.getUserId(),cart.getChecked());
        System.out.println("----isCheckAll----");
        return result;
    }

    @RequestMapping(value = "/editCart",method = RequestMethod.POST)
    public Result editCart(@RequestBody Cart cart){
        Result result = cartService.updateCartNum(cart.getUserId(),cart.getGoodsId(),cart.getGoodsNum(),cart.getChecked());
        return result;
    }



}
