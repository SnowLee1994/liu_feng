package com.newcolor.core.dao;

import com.newcolor.core.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/8/2317:44
 * @Description: 角色Dao
 */
@Repository
public interface RoleDao {

    int insert(Role role);

    int update(Role role);

    int deleteById(Long id);

    Role findById(Long id);

    Role findByName(String name);

    List<Role> findRoles();

}
