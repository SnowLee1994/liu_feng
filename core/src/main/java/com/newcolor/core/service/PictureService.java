package com.newcolor.core.service;

import com.github.pagehelper.PageInfo;
import com.newcolor.core.pojo.Picture;

/**
 * @author xuewen.li
 * @date 2021/12/1923:44
 * @Description: 图片
 */
public interface PictureService {

    public PageInfo<Picture> findPicturesByPage(Integer pageNum, Integer pageSize);
}
