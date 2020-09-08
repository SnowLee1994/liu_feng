package com.newcolor.core.service;

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

    int deleteById(Long id);

    Role findById(Long id);

    Role findByName(String name);

    List<Role> findRoles();
}
