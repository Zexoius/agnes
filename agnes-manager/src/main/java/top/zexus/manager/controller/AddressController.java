package top.zexus.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.zexus.common.pojo.TbAddress;
import top.zexus.common.utils.Result;
import top.zexus.manager.service.AddressService;

import javax.annotation.Resource;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:40 2018/9/20
 */

@RequestMapping("/address")
@RestController
@Api(description = "管理收货地址")
public class AddressController {
    @Resource
    private AddressService addressService;

    @ApiOperation(value = "添加收货地址")
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public Result addAddress(@RequestBody TbAddress tbAddress) {
        Result result = addressService.addAddress(tbAddress);
        return result;
    }

    @ApiOperation(value = "删除收货地址")
    @RequestMapping(value = "/delAddress", method = RequestMethod.POST)
    public Result delAddress(@RequestBody TbAddress tbAddress) {
        Result result = addressService.delAddress(tbAddress);
        return result;
    }

    @ApiOperation(value = "获取所有收货地址")
    @RequestMapping(value = "/addressList", method = RequestMethod.POST)
    public Result getAddressList(@RequestBody TbAddress tbAddress) {
        Result result = addressService.getAddressList(tbAddress.getUserId());
        System.out.println("----getAddressList----");
        return result;
    }

    //    TODO: getAddress
    @ApiOperation(value = "获取单条收货地址")
    @RequestMapping(value = "/getAddress", method = RequestMethod.POST)
    public Result getAddress(@RequestBody TbAddress tbAddress) {
        Result result = addressService.getAddress(tbAddress.getAddressId());
        return result;
    }

    @ApiOperation(value = "更新地址信息")
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public Result updateAddress(@RequestBody TbAddress tbAddress) {
        Result result = addressService.updateAddress(tbAddress);
        return result;
    }
}
