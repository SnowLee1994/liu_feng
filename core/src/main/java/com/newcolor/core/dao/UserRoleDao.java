package com.newcolor.core.dao;

import com.newcolor.core.pojo.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/9/823:25
 * @Description: 用户角色绑定
 */
@Repository
public interface UserRoleDao {

    int insert(UserRole userRole);

    int deleteById(Long id);

    int deleteByUserAndRole(Long userId,Long roleId);

    List<Long> findRoleIds(Long userId);
}
