package com.newcolor.web.controller.user;

import com.newcolor.core.pojo.User;
import com.newcolor.core.pojo.UserRole;
import com.newcolor.core.service.UserRoleService;
import com.newcolor.core.service.UserService;
import com.newcolor.web.controller.user.dto.BindRolesDto;
import com.newcolor.web.controller.user.dto.UserDto;
import com.newcolor.web.controller.utils.ResultData;
import com.newcolor.web.controller.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/8/2314:14
 * @Description: 用户
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation(value="新增用户")
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public ResultData addUser(UserDto dto){
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
        return ResultUtil.error("添加失败");
    }

    @ApiOperation(value="编辑用户")
    @RequestMapping(value = "/edit",method= RequestMethod.POST)
    public ResultData editUser(UserDto dto){
        //转换
        User user = new User();
        user.setId(dto.getId());
        user.setAge(dto.getAge());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setQq(dto.getQq());
        user.setEmail(dto.getEmail());

        int res = userService.update(user);
        if (res>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("编辑失败");
    }

    @ApiOperation(value="删除用户")
    @RequestMapping(value = "/delete/{id}",method= RequestMethod.POST)
    public ResultData editUser(@PathVariable Long id){

        int res = userService.deleteById(id);
        if (res>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("删除失败");
    }

    @ApiOperation(value="根据ID查询用户")
    @RequestMapping(value = "/getUser/{id}",method= RequestMethod.POST)
    public ResultData GetUser(@PathVariable Long id){
        User user = userService.findById(id);
        return ResultUtil.success(user);
    }

    @ApiOperation(value="用户列表")
    @RequestMapping(value = "/userList",method= RequestMethod.POST)
    public ResultData findUsers(){
        List<User> users = userService.findUsers();
        return ResultUtil.success(users);
    }

    @ApiOperation(value="用户绑定角色列表")
    @RequestMapping(value = "/bindRoles",method= RequestMethod.POST)
    public ResultData bindRoles(BindRolesDto dto){
        Long userId = dto.getUserId();
        List<Long> roleIds = dto.getRoleIds();
        User user = userService.findById(userId);
        if (user == null){
            return ResultUtil.error("用户不存在！");
        }
        if (CollectionUtils.isEmpty(roleIds)){
            return ResultUtil.error("未选定角色！");
        }
        //查询已绑定角色
        List<Long> roles = userRoleService.findRoleIds(userId);
        for (Long old:roleIds) {
            if (!roleIds.contains(old)){
                //解绑
                userRoleService.deleteByUserAndRole(userId,old);
            }
        }
        for (Long roleId:roleIds) {
            if (!roles.contains(roleId)){
                //新增绑定
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                userRoleService.insert(userRole);
            }

        }
        return ResultUtil.success();
    }

}
