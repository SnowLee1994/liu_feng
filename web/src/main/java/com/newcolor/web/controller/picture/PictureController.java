package com.newcolor.web.controller.picture;

import com.github.pagehelper.PageInfo;
import com.newcolor.core.pojo.Picture;
import com.newcolor.core.service.PictureService;
import com.newcolor.web.controller.utils.PageDto;
import com.newcolor.web.controller.utils.ResultData;
import com.newcolor.web.controller.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuewen.li
 * @date 2021/12/1923:43
 * @Description: 图片控制器
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @ApiOperation(value="图片列表")
    @RequestMapping(value = "/listByPage",method= RequestMethod.POST)
    public ResultData findUsers(PageDto pageDto){
        PageInfo<Picture> list = pictureService.findPicturesByPage(pageDto.getPageNum(), pageDto.getPageSize());
        return ResultUtil.success(list);
    }
}
