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

    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    public Result addCart(@RequestBody Cart cart){
        int result = cartService.addCart(cart.getUserId(),cart.getGoodsId(),cart.getGoodsNum());
        return Result.ok()
                .put("resultState",result);
    }

    @RequestMapping(value = "cartList",method = RequestMethod.POST)
    public Result getCartList(@RequestBody Cart cart){
        Result result = cartService.getCartList(cart.getUserId());
        return result;
    }



}
