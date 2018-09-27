package top.zexus.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "商品模块")
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @ApiOperation(value = "商品详情")
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
    public Result goodsDetail(Long goodsId) {
        Result result = goodsService.goodsDetail(goodsId);
        return result;
    }

    @ApiOperation(value = "按条件获取全部商品")
    @RequestMapping(value = "/getAllGoods", method = RequestMethod.GET)
    public Result getAllGoods(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "20") int size,
                              @RequestParam(defaultValue = "1") String sort,
                              @RequestParam(defaultValue = "560") Long cid,
                              @RequestParam(defaultValue = "-1") int priceGt,
                              @RequestParam(defaultValue = "-1") int priceLt) {
        Result result = goodsService.getAllGoods(page, size, sort, cid, priceGt, priceLt);
        return result;
    }

    @ApiOperation(value = "获取首页商品列表")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public Result getGoodsHome() {
        Result result = goodsService.getHome();
        return result;
    }
}
