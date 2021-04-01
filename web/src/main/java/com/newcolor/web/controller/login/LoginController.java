package com.newcolor.web.controller.login;

import com.newcolor.core.pojo.User;
import com.newcolor.core.service.UserService;
import com.newcolor.web.controller.login.dto.LoginDto;
import com.newcolor.web.controller.user.dto.UserDto;
import com.newcolor.web.controller.utils.JwtUtils;
import com.newcolor.web.controller.utils.ResultData;
import com.newcolor.web.controller.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private JwtUtils jwtUtils;

    @ApiOperation(value="用户注册")
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public ResultData regist(UserDto dto){
        //查询用户名是否已存在
        User users = userService.findByName(dto.getUsername());
        if (users!=null){
            return ResultUtil.error("此用户名已存在！");
        }
        //注册
        //转换
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());

        int insert = userService.insert(user);
        if (insert>0){
            return ResultUtil.success("注册成功！");
        }
        return ResultUtil.error("注册失败!");
    }

    @ApiOperation(value="用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultData regist(LoginDto dto){
        User login = userService.login(dto.getUsername(), dto.getPassword());
        if (login != null){
            Map<String, Object> map = new HashMap<>();
            String token = jwtUtils.createJwt(dto.getUsername(), dto.getPassword(),map);
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("user",login);
            returnMap.put("token",token);
            return ResultUtil.success(returnMap);
        }else {
            return ResultUtil.error("用户名或密码错误!");
        }
    }

}
