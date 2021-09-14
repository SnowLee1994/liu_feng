package com.newcolor.web.controller.user;

import com.github.pagehelper.PageInfo;
import com.newcolor.core.pojo.User;
import com.newcolor.core.service.UserService;
import com.newcolor.web.controller.user.dto.BindRolesDto;
import com.newcolor.web.controller.user.dto.UserDto;
import com.newcolor.web.controller.utils.PageDto;
import com.newcolor.web.controller.utils.ResultData;
import com.newcolor.web.controller.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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

    @ApiOperation(value="新增用户")
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public ResultData addUser(UserDto dto){
        //转换
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());

        int insert = userService.insert(user);
        if (insert>0){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.error("添加失败");
    }

    @ApiOperation(value="编辑用户")
    @RequestMapping(value = "/edit",method= RequestMethod.POST)
    public ResultData editUser(UserDto dto){
        //转换
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());

        int res = userService.update(user);
        if (res>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("编辑失败");
    }

    @ApiOperation(value="删除用户")
    @RequestMapping(value = "/delete",method= RequestMethod.POST)
    public ResultData deleteUser(Integer id){

        int res = userService.deleteById(id);
        if (res>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("删除失败");
    }

    @ApiOperation(value="根据ID查询用户")
    @RequestMapping(value = "/getUserById",method= RequestMethod.POST)
    public ResultData GetUser(Integer id){
        User user = userService.findById(id);
        return ResultUtil.success(user);
    }

    @ApiOperation(value="用户列表")
    @RequestMapping(value = "/userList",method= RequestMethod.POST)
    public ResultData findUsers(){
        List<User> users = userService.findUsers();
        return ResultUtil.success(users);
    }

    @ApiOperation(value="用户列表分頁")
    @RequestMapping(value = "/userListByPage",method= RequestMethod.POST)
    public ResultData findUsersByPage(PageDto pageDto){

        PageInfo<User> usersByPages = userService.findUsersByPages(pageDto.getPageNum(), pageDto.getPageSize());
        return ResultUtil.success(usersByPages);
    }

    @ApiOperation(value="用户绑定角色列表")
    @RequestMapping(value = "/bindRoles",method= RequestMethod.POST)
    public ResultData bindRoles(BindRolesDto dto){
        Integer userId = dto.getUserId();
        List<Integer> roleIds = dto.getRoleIds();
        User user = userService.findById(userId);
        if (user == null){
            return ResultUtil.error("用户不存在！");
        }
        if (CollectionUtils.isEmpty(roleIds)){
            return ResultUtil.error("未选定角色！");
        }
        return ResultUtil.success();
    }

}
