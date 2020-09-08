package com.newcolor.core.service.iml;

import com.newcolor.core.dao.UserDao;
import com.newcolor.core.pojo.User;
import com.newcolor.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/8/2023:17
 * @Description: 用户方法
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(Long id){
        return userDao.findById(id);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User login(String userName, String password) {
        return userDao.findByNameAndPwd(userName, password);
    }

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }


}
