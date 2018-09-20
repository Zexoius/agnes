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
     *
     * @param username
     * @param password
     * @return
     */
    Result userLogin(String username, String password);

    /**
     * 检测token
     *
     * @param token
     * @return
     */
    Result getUserByToken(String token);

    /**
     * 注册
     *
     * @param username
     * @param password
     * @return
     */
    Result register(String username, String password);

    /**
     * 检测数据
     *
     * @param params
     * @param type
     * @return
     */
    boolean checkData(String params, int type);

    /**
     * Redis 测试
     *
     * @return
     */
    String tesRedis();

    int logout(String token);
}
