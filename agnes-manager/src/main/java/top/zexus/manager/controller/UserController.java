package top.zexus.manager.controller;



import org.springframework.web.bind.annotation.*;
import top.zexus.common.pojo.dto.LoginDto;
import top.zexus.common.utils.Result;
import top.zexus.manager.Jedis.JedisClient;
import top.zexus.manager.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:10 2018/7/30
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private JedisClient jedisClient;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody LoginDto loginDto, HttpServletRequest request){
       Result result = userService.userLogin(loginDto.getUsername().trim(),loginDto.getPassword().trim());
//       System.out.println(loginDto.getUsername());
//       System.out.println(loginDto.getPassword());
       return result;
    }

    @RequestMapping(value = "/checkLogin",method = RequestMethod.GET)
    public Result checkLogin(@RequestParam(defaultValue = "") String token){
        Result result = userService.getUserByToken(token);
        return result;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody LoginDto loginDto){
        Result result = userService.register(loginDto.getUsername(),loginDto.getPassword());
        return result;
    }

}
