package top.zexus.manager.service;

import top.zexus.common.utils.Result;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:37 2018/9/20
 */
public interface AddressService {
    /**
     * 获取地址
     *
     * @return
     */
    Result getAddress();

    /**
     * 修改地址
     *
     * @param address
     * @return
     */
    Result updateAddress(String address);

}
