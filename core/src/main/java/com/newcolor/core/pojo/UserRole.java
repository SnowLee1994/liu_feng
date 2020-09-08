package com.newcolor.core.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author xuewen.li
 * @date 2020/9/823:05
 * @Description: 用户绑定角色
 */
@Data
public class UserRole {

    private Long id;
    private Long userId;
    private Long roleId;
    private Date createDate;
}
