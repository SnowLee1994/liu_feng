package com.newcolor.core.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author xuewen.li
 * @date 2020/8/2317:45
 * @Description: 角色
 */
@Data
public class Role {

    private Long id;
    private String name;
    private Date createdDate;
}
