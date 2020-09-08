package com.newcolor.core.service;

import com.newcolor.core.pojo.UserRole;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/9/90:07
 * @Description: 用户绑定角色
 */
public interface UserRoleService {

    int insert(UserRole userRole);

    int deleteById(Long id);

    int deleteByUserAndRole(Long userId,Long roleId);

    List<Long> findRoleIds(Long userId);
}
