package com.newcolor.core.service;

import com.newcolor.core.pojo.User;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/8/2023:17
 * @Description: 用户
 */
public interface UserService {

    User findById(Long id);

    int insert(User user);

    int update(User user);

    int deleteById(Long id);

    User findByName(String name);

    User login(String userName,String password);

    List<User> findUsers();
}
