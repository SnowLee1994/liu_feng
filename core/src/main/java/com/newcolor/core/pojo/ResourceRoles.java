package com.newcolor.core.pojo;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2021/4/221:41
 * @Description: 资源关联角色
 */
public class ResourceRoles extends Resource {
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
