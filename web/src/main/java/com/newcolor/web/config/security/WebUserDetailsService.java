package com.newcolor.web.config.security;

import com.newcolor.core.dao.UserMapper;
import com.newcolor.core.pojo.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xuewen.li
 * @date 2021/4/220:40
 * @Description: 用户验证Service
 */
@Service
public class WebUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserRoles userRoles = userMapper.loadUserByUsername(s);
        WebUserDetails userDetails = new WebUserDetails();
        userDetails.setId(userRoles.getId());
        userDetails.setRoles(userRoles.getRoles());
        userDetails.setUserName(userRoles.getUsername());
        userDetails.setUserPwd(userRoles.getPassword());
        return userDetails;
    }
}
