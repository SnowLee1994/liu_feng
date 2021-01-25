package com.newcolor.web.controller.login.dto;

import lombok.Data;

/**
 * @author xuewen.li
 * @date 2020/8/2316:06
 * @Description: 登录Dto
 */
@Data
public class LoginDto {

    private String email;
    private String password;
    private String token;
}
