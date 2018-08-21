package top.zexus.manager.service;

import top.zexus.common.utils.Result;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:10 2018/7/30
 */
public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Result userLogin(String username, String password);
}
