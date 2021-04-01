package com.newcolor.web.controller.utils;

/**
 * @author xuewen.li
 * @date 2021/4/121:09
 * @Description: 分頁
 */
public class PageDto {
    private int pageNum;
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
