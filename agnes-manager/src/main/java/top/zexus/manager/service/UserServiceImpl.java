package top.zexus.manager.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.zexus.common.mapper.TbUserMapper;
import top.zexus.common.pojo.TbUser;
import top.zexus.common.pojo.TbUserExample;
import top.zexus.common.pojo.UserToken;
import top.zexus.common.utils.JSONUtils;
import top.zexus.common.utils.JwtUtils;
import top.zexus.common.utils.Result;
import top.zexus.manager.Dto.DtoUtils;
import top.zexus.manager.Dto.User;
import top.zexus.manager.Jedis.JedisClient;

import javax.annotation.Resource;
import javax.management.DescriptorAccess;
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
    private JedisClient jedisClient;

    @Override
    public Result userLogin(String username, String password) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if (list.size() < 1) {
//            User user = new User();
//            user.setState(0);
//            user.setMsg("用户名或密码错误");
            return Result.error("用户名或密码错误")
                    .put("state", 0);
        }
        TbUser tbUser = list.get(0);
        //        admin
        if (null == tbUser || !password.equals(tbUser.getPassword())){
//            User user = new User();
//            user.setState(0);
//            user.setMsg("用户名或密码错误");
            return Result.error("用户名或密码错误")
                    .put("state",0);
        }
        User user = DtoUtils.TbUser2User(tbUser);
        UserToken userToken = new UserToken(user.getId().toString(),user.getUsername());
        String token = "";
        try {
            token = JwtUtils.generateToken(userToken,2*60*60*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setToken(token);
        user.setState(1);
        // 用户信息写入redis：key："SESSION:token" value："user"
//        jedisClient.set("SESSION:" + token, new Gson().toJson(user));
//        jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
        return Result.ok("登录成功")
                .put("user", user);
//                .put("token",token);
    }

    @Override
    public Result getUserByToken(String token) {
        String json = "";
        try {
            json = JwtUtils.getInfoFromToken(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(json);
        if (json == null){
            User user = new User();
            user.setState(0);
            user.setMsg("用户信息不存在");
            return Result.error("未登录")
                    .put("user",user);
        }
        User user = new Gson().fromJson(json,User.class);
        if (user == null){
            return Result.error("用户信息不存在");
        }
        return Result.ok("已登陆")
//                .put("user",user)
                .put("token",token);
    }

    @Override
    public Result register(String username, String password) {
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        if (username.isEmpty() || password.isEmpty()){
            return  Result.error("账户名或密码不为空");
        }
        boolean flag = checkData(username,1);
        if (!flag){
            return Result.error("已被注册");
        }
//        String md5Psw = DigestUtils.md5DigestAsHex(password.getBytes());
        tbUser.setUsername(username);
//        tbUser.setPassword(md5Psw);
        tbUser.setPassword(password);
        if (tbUserMapper.insert(tbUser) != 1){
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
        if (type == 1){
            criteria.andUsernameEqualTo(params);
        }else if (type == 2){
            criteria.andPhoneEqualTo(params);
        }else {
            return false;
        }
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if (list != null && list.size() > 0){
            return false;
        }
        return true;
    }
}
