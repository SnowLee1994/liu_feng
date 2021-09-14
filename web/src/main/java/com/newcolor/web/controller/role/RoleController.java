package com.newcolor.web.controller.role;

import com.github.pagehelper.PageInfo;
import com.newcolor.core.pojo.Role;
import com.newcolor.core.service.RoleService;
import com.newcolor.web.controller.role.dto.RoleDto;
import com.newcolor.web.controller.utils.PageDto;
import com.newcolor.web.controller.utils.ResultData;
import com.newcolor.web.controller.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/9/822:30
 * @Description: 角色
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value="新增角色")
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public ResultData addRole(RoleDto dto){
        //转换
        Role role = new Role();
        role.setName(dto.getName());
        int insert = roleService.insert(role);
        if (insert>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("添加失败");
    }

    @ApiOperation(value="编辑角色")
    @RequestMapping(value = "/edit",method= RequestMethod.POST)
    public ResultData editRole(RoleDto dto){
        //转换
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());

        int res = roleService.update(role);
        if (res>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("编辑失败");
    }

    @ApiOperation(value="删除角色")
    @RequestMapping(value = "/delete/{id}",method= RequestMethod.POST)
    public ResultData delRole(@PathVariable Integer id){

        int res = roleService.deleteById(id);
        if (res>0){
            return ResultUtil.success();
        }
        return ResultUtil.error("删除失败");
    }

    @ApiOperation(value="角色列表")
    @RequestMapping(value = "/roleList",method= RequestMethod.POST)
    public ResultData findRoles(){
        List<Role> roles = roleService.findRoles();
        return ResultUtil.success(roles);
    }

    @ApiOperation(value="角色列表分頁")
    @RequestMapping(value = "/roleListByPage",method= RequestMethod.POST)
    public ResultData findRolesByPage(PageDto pageDto){

        PageInfo<Role> rolesByPages = roleService.findRolesByPages(pageDto.getPageNum(), pageDto.getPageSize());
        return ResultUtil.success(rolesByPages);
    }
}
