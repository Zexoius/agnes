package top.zexus.manager.service;

import top.zexus.common.pojo.TbAddress;
import top.zexus.common.utils.Result;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:37 2018/9/20
 */
public interface AddressService {

    /**
     * 新增地址
     * @param tbAddress
     * @return
     */
    Result addAddress(TbAddress tbAddress);

    /**
     * 删除地址
     * @param tbAddress
     * @return
     */
    Result delAddress(TbAddress tbAddress);

    /**
     * 获取单个地址
     * @param addressId
     * @return
     */
    Result getAddress(Long addressId);

    /**
     * 获取所有地址
     * @param userid
     * @return
     */
    Result getAddressList(Long userid);

    /**
     * 修改地址
     *
     * @param tbAddress
     * @return
     */
    Result updateAddress(TbAddress tbAddress);

}
