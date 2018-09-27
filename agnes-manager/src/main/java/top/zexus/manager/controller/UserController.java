package top.zexus.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.zexus.common.pojo.dto.LoginDto;
import top.zexus.common.utils.Result;
import top.zexus.manager.Redis.RedisClient;
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
@Api(description = "用户模块")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RedisClient redisClient;

    @ApiOperation(value = "用户登录", notes = "用户登录服务")
//    @ApiImplicitParam(name = "LoginDto",value = "用户登录实体",required = true,dataType = "LoginDto")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        Result result = userService.userLogin(loginDto.getUsername().trim(), loginDto.getPassword().trim());
//       System.out.println(loginDto.getUsername());
//       System.out.println(loginDto.getPassword());
        return result;
    }

    @ApiOperation(value = "检测登录状态")
    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    public Result checkLogin(@RequestParam(defaultValue = "") String token) {
//        System.out.println("--------执行checkLogin---------");
        Result result = userService.getUserByToken(token);
        return result;
    }

    @ApiOperation(value = "注册账号")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody LoginDto loginDto) {
        Result result = userService.register(loginDto.getUsername(), loginDto.getPassword());
        return result;
    }

    @ApiOperation(value = "redis测试")
    @RequestMapping(value = "/testJedis", method = RequestMethod.GET)
    public void doJedisTest() {
        String result = userService.tesRedis();
        System.out.println(result);
    }

    @ApiOperation(value = "登出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result loginout(@RequestParam(defaultValue = "") String token) {
        int result = userService.logout(token);
        System.out.println("result:" + result);
        return Result.ok()
                .put("result", result);
    }

}
