package com.newcolor.core.service.iml;

import com.newcolor.core.dao.RoleMapper;
import com.newcolor.core.pojo.Role;
import com.newcolor.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/9/822:27
 * @Description: 角色
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int deleteById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> findRoles() {
        return roleMapper.selectAll();
    }
}
