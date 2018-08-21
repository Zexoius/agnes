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

    @RequestMapping(value = "/goodsDetail",method = RequestMethod.GET)
    public Result goodsDetail(Long goodsId) {
        Result result = goodsService.goodsDetail(goodsId);
        return result;
    }

    @RequestMapping(value = "/getAllGoods",method = RequestMethod.GET)
    public Result getAllGoods(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "20") int size,
                              @RequestParam(defaultValue = "") String sort,
                              @RequestParam(defaultValue = "") Long cid,
                              @RequestParam(defaultValue = "-1") int priceGt,
                              @RequestParam(defaultValue = "-1") int priceLt) {
        Result result = goodsService.getAllGoods(page, size, sort, cid, priceGt, priceLt);
        return result;
    }
}
