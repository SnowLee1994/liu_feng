package com.newcolor.core.service.iml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newcolor.core.dao.PictureMapper;
import com.newcolor.core.pojo.Picture;
import com.newcolor.core.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuewen.li
 * @date 2021/12/1923:45
 * @Description: 图片
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public PageInfo<Picture> findPicturesByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Picture> lists = pictureMapper.findPictures();
        return new PageInfo<>(lists);
    }
}
