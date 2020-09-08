package com.newcolor.web.controller.user.dto;

import lombok.Data;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2020/9/823:00
 * @Description: 绑定角色Dto
 */
@Data
public class BindRolesDto {

    private Long userId;
    private List<Long> roleIds;
}
