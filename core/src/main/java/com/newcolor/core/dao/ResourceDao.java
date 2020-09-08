package com.newcolor.core.dao;

import com.newcolor.core.pojo.Resource;

/**
 * @author xuewen.li
 * @date 2020/8/2317:55
 * @Description: 资源Dao
 */
public interface ResourceDao {

    int insert(Resource resource);

    int update(Resource resource);

    int deleteById(Long id);

    Resource findById(Long id);

    Resource findByName(String name);

}
