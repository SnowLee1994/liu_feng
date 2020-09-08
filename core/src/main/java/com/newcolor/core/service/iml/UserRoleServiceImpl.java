package com.newcolor.core.service.iml;

import com.newcolor.core.dao.UserRoleDao;
import com.newcolor.core.pojo.UserRole;
import com.newcolor.core.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/9/90:09
 * @Description: 用户角色绑定
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public int insert(UserRole userRole) {
        return userRoleDao.insert(userRole);
    }

    @Override
    public int deleteById(Long id) {
        return userRoleDao.deleteById(id);
    }

    @Override
    public int deleteByUserAndRole(Long userId, Long roleId) {
        return userRoleDao.deleteByUserAndRole(userId, roleId);
    }

    @Override
    public List<Long> findRoleIds(Long userId) {
        return userRoleDao.findRoleIds(userId);
    }
}
