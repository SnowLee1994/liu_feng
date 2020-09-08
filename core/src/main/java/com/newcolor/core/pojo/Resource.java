package com.newcolor.core.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author xuewen.li
 * @date 2020/8/2317:53
 * @Description: 资源
 */
@Data
public class Resource {

    private Long id;
    private String name;
    private String url;
    private Date createdDate;
}
