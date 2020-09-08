package com.newcolor.web.controller.user.dto;

import lombok.Data;

/**
 * @author xuewen.li
 * @date 2020/8/2314:23
 * @Description: 用户Dto
 */
@Data
public class UserDto {

    private Long id;
    private String name;
    private String password;
    private String phone;
    private Integer age;
    private String qq;
    private String email;

}
