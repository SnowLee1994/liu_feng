package com.newcolor.web.controller.login;

import com.newcolor.core.pojo.User;
import com.newcolor.core.service.UserService;
import com.newcolor.web.controller.login.dto.LoginDto;
import com.newcolor.web.controller.user.dto.UserDto;
import com.newcolor.web.controller.utils.ResultData;
import com.newcolor.web.controller.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuewen.li
 * @date 2020/6/2821:03
 * @Description: 用户登录
 */
@RequestMapping("/test")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="用户注册")
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public ResultData regist(UserDto dto){
        //查询用户名是否已存在
        User old = userService.findByName(dto.getName());
        if (old!=null){
            return ResultUtil.error("此用户名已存在！");
        }
        //注册
        //转换
        User user = new User();
        user.setAge(dto.getAge());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setQq(dto.getQq());
        user.setEmail(dto.getEmail());

        int insert = userService.insert(user);
        if (insert>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("注册失败!");
    }

    @ApiOperation(value="用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultData regist(LoginDto dto){
        User login = userService.login(dto.getUserName(), dto.getPassword());
        if (login != null){
            return ResultUtil.success(login);
        }else {
            return ResultUtil.error("用户名或密码错误!");
        }
    }

}
