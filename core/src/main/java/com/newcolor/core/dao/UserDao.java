package com.newcolor.core.dao;

import com.newcolor.core.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/8/2023:19
 * @Description:
 */
@Repository
public interface UserDao {
    User findById(Long id);

    int insert(User user);

    int update(User user);

    int deleteById(Long id);

    User findByName(String name);

    User findByNameAndPwd(@Param("name") String name,@Param("password") String password);

    List<User> findUsers();
}
