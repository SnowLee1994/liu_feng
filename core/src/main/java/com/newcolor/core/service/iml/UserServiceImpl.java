package com.newcolor.core.service.iml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newcolor.core.dao.UserMapper;
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
    private UserMapper userMapper;

    public User findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User login(String userName, String password) {
        return userMapper.findByNameAndPwd(userName, password);
    }

    @Override
    public List<User> findUsers() {
        return userMapper.findUsers();
    }

    @Override
    public PageInfo<User> findUsersByPages(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.findUsers();
        return new PageInfo<User>(lists);
    }


}
