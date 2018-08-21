package top.zexus.manager.service;

import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbUserMapper;
import top.zexus.common.pojo.TbUser;
import top.zexus.common.pojo.TbUserExample;
import top.zexus.common.utils.Result;
import top.zexus.manager.Dto.DtoUtils;
import top.zexus.manager.Dto.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:10 2018/7/30
 */
@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    @Resource
    private TbUserMapper tbUserMapper;

    public Result userLogin(String username, String password) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if (list.size() < 1) {
            return Result.error("用户名或密码错误")
                    .put("state", 0);
        }
        TbUser tbUser = list.get(0);
        if (null == tbUser || tbUser.getPassword().equals(password)){
            return Result.error("用户名或密码错误")
                    .put("state",0);
        }
        User user = DtoUtils.TbUser2User(tbUser);
        user.setState(1);
        return Result.ok("登录成功")
                .put("user", user);
    }
}
