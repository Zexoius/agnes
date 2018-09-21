package top.zexus.manager.service.impl;

import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbAddressMapper;
import top.zexus.common.utils.Result;
import top.zexus.manager.service.AddressService;

import javax.annotation.Resource;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:37 2018/9/20
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private TbAddressMapper tbAddressMapper;

    @Override
    public Result getAddress() {
        return null;
    }

    @Override
    public Result updateAddress(String address) {
        return null;
    }
}
