package com.sm.dao;

import com.sm.domain.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer perId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}