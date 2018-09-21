package top.zexus.manager.controller;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.geometry.Pos;
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
public class AddressController {
    @Resource
    private AddressService addressService;

    @RequestMapping(value = "/addAddress",method = RequestMethod.POST)
    public Result addAddress(@RequestBody TbAddress tbAddress){
        Result result = addressService.addAddress(tbAddress);
        return result;
    }

    @RequestMapping(value = "/delAddress",method = RequestMethod.POST)
    public Result delAddress(@RequestBody TbAddress tbAddress){
        Result result = addressService.delAddress(tbAddress);
        return result;
    }

    @RequestMapping(value = "/addressList",method = RequestMethod.POST)
    public Result getAddressList(@RequestBody TbAddress tbAddress){
        Result result = addressService.getAddressList(tbAddress.getUserId());
        System.out.println("----getAddressList----");
        return result;
    }

//    TODO: getAddress
    @RequestMapping(value = "/getAddress",method = RequestMethod.POST)
    public Result getAddress(@RequestBody TbAddress tbAddress){
        Result result = addressService.getAddress(tbAddress.getAddressId());
        return result;
    }

    @RequestMapping(value = "/updateAddress",method = RequestMethod.POST)
    public Result updateAddress(@RequestBody TbAddress tbAddress){
        Result result = addressService.updateAddress(tbAddress);
        return result;
    }
}
