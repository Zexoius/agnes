package top.zexus.manager.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import top.zexus.common.constants.CommonConstants;
import top.zexus.common.mapper.TbUserMapper;
import top.zexus.common.pojo.TbUser;
import top.zexus.common.pojo.TbUserExample;
import top.zexus.common.pojo.dto.User;
import top.zexus.common.pojo.dto.UserToken;
import top.zexus.common.utils.DtoUtils;
import top.zexus.common.utils.JwtUtils;
import top.zexus.common.utils.Result;
import top.zexus.manager.Redis.RedisClient;
import top.zexus.manager.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:10 2018/7/30
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private TbUserMapper tbUserMapper;
    @Resource
    private RedisClient redisClient;
//    private int SESSION_EXPIRE = 2 * 60 * 60 * 1000;

    @Override
    public Result userLogin(String username, String password) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
//        按条件查询
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if (list.size() < 1) {
//            User user = new User();
//            user.setState(0);
//            user.setMsg("用户名或密码错误");
            return Result.error("用户名或密码错误")
                    .put("state", 0);
        }
        TbUser tbUser = list.get(0);
        if (null == tbUser || !password.equals(tbUser.getPassword())) {
//            User user = new User();
//            user.setState(0);
//            user.setMsg("用户名或密码错误");
            return Result.error("用户名或密码错误")
                    .put("state", 0);
        }
        User user = DtoUtils.TbUser2User(tbUser);
        UserToken userToken = new UserToken(user.getId().toString(), user.getUsername());
        String token = "";
        try {
            token = JwtUtils.generateToken(userToken, CommonConstants.SESSION_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setToken(token);
        user.setState(1);
        // 用户信息写入 redis：key："SESSION:token" value："user"
        redisClient.set(CommonConstants.SESSION + token, new Gson().toJson(user));
        redisClient.expire(CommonConstants.SESSION + token, CommonConstants.SESSION_EXPIRE);
        return Result.ok("登录成功")
                .put("user", user);
//                .put("token",token);
    }

    @Override
    public Result getUserByToken(String token) {
//        String json = "";
//        try {
//            json = JwtUtils.getInfoFromToken(token);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(json);
        String json = redisClient.get(CommonConstants.SESSION + token);
        if (json == null) {
            User user = new User();
            user.setState(0);
            user.setMsg("用户信息不存在");
            return Result.error("未登录")
                    .put("user", user);
        }
//        User user = new Gson().fromJson(json,User.class);
//        if (user == null){
//            return Result.error("用户信息不存在");
//        }
        redisClient.expire(CommonConstants.SESSION + token, CommonConstants.SESSION_EXPIRE);
        User user = new Gson().fromJson(json, User.class);
        return Result.ok("已登陆")
                .put("user", user)
                .put("token", token);
    }

    @Override
    public Result register(String username, String password) {
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        if (username.isEmpty() || password.isEmpty()) {
            return Result.error("账户名或密码不为空");
        }
        boolean flag = checkData(username, 1);
        if (!flag) {
            return Result.error("已被注册");
        }
//        String md5Psw = DigestUtils.md5DigestAsHex(password.getBytes());
        tbUser.setUsername(username);
//        tbUser.setPassword(md5Psw);
        tbUser.setPassword(password);
        if (tbUserMapper.insert(tbUser) != 1) {
            return Result.error("注册失败");
        }
        return Result.ok("注册成功");
    }

    @Override
    public boolean checkData(String params, int type) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(1);
//        1:用户名；2:手机号；3：邮箱
        if (type == 1) {
            criteria.andUsernameEqualTo(params);
        } else if (type == 2) {
            criteria.andPhoneEqualTo(params);
        } else {
            return false;
        }
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public String tesRedis() {
        String key = "user";
        String value = "zexus";
        redisClient.set(key, value);
        String result = redisClient.get(key);
        String json = new Gson().toJson(result);
        return json;
    }

    @Override
    public int logout(String token) {
        redisClient.del(CommonConstants.SESSION + token);
        return 1;
    }
}
