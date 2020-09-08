package com.newcolor.web.controller.utils;

import lombok.Data;

/**
 * @author xuewen.li
 * @date 2020/8/2315:23
 * @Description: 响应结果集
 */
@Data
public class ResultData<T> {
    private  Integer code;
    private String msg;
    private T data;
}
