package top.zexus.manager.controller;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.zexus.common.pojo.dto.LoginDto;
import top.zexus.common.utils.Result;
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

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody LoginDto loginDto, HttpServletRequest request){
       Result result = userService.userLogin(loginDto.getUsername().trim(),loginDto.getPassword().trim());
//       System.out.println(loginDto.getUsername());
//       System.out.println(loginDto.getPassword());
       return result;
    }
}
