package com.newcolor.core.dao;

import com.newcolor.core.pojo.Resource;
import com.newcolor.core.pojo.ResourceRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<ResourceRoles> getAllResourceInfo();
}
