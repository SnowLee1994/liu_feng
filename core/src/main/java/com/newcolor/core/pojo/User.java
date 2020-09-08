package com.newcolor.core.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author xuewen.li
 * @date 2020/8/216:14
 * @Description: 用户
 */
@Data
public class User {

    private Long id;
    private String name;
    private String password;
    private String phone;
    private Integer age;
    private String qq;
    private String email;
    private Date createDate;
}
