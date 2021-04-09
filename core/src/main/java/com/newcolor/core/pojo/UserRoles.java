package com.newcolor.core.pojo;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2021/4/221:53
 * @Description: 用户角色关联
 */
public class UserRoles extends User {
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
