package com.newcolor.core.service.iml;

import com.newcolor.core.dao.RoleDao;
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
    private RoleDao roleDao;

    @Override
    public int insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public int deleteById(Long id) {
        return roleDao.deleteById(id);
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }

    @Override
    public List<Role> findRoles() {
        return roleDao.findRoles();
    }
}
