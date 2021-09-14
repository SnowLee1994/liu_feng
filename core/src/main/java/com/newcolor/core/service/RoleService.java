package com.newcolor.core.service;

import com.github.pagehelper.PageInfo;
import com.newcolor.core.pojo.Role;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/9/822:25
 * @Description: 角色
 */
public interface RoleService {

    int insert(Role role);

    int update(Role role);

    int deleteById(Integer id);

    Role findById(Integer id);

    List<Role> findRoles();

    PageInfo<Role> findRolesByPages(Integer pageNum, Integer pageSize);
}
