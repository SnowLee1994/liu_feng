package com.newcolor.web.controller.utils;

/**
 * @author xuewen.li
 * @date 2020/8/2315:29
 * @Description: 统一响应工具类
 */
public class ResultUtil {

    private static final int SUCCESS_CODE = 200;
    private static final int FAIL_CODE = 500;

    public static ResultData success(Object object){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(SUCCESS_CODE);
        resultData.setMsg("成功");
        resultData.setData(object);
        return resultData;
    }

    public static ResultData  success() {
        return success("成功！");
    }

    public static ResultData error(String msg) {
        ResultData result = new ResultData();
        result.setCode(FAIL_CODE);
        result.setMsg(msg);
        return result;
    }
}
