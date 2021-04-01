package com.newcolor.core.dao;

import com.newcolor.core.pojo.Resource;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}
