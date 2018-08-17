package top.zexus.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zexus.common.utils.Result;
import top.zexus.manager.service.GoodsService;

import javax.annotation.Resource;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:20 2018/8/14
 */
@RequestMapping("/goods")
@RestController
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @RequestMapping(value = "/getAllGoods",method = RequestMethod.GET)
    public Result getAllGoods(@RequestParam int page,
                              @RequestParam int size,
                              @RequestParam String sort,
                              @RequestParam Long cid,
                              @RequestParam int priceGt,
                              @RequestParam int priceLt) {
        Result result = goodsService.getAllGoods(page, size, sort, cid, priceGt, priceLt);
        return result;
    }
}
