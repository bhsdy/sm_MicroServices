package com.sm.service;


import com.sm.domain.Permission;

public interface PermissionService {

    int insert(Permission record)throws Exception;

    Permission selectByPrimaryKey(Integer perId)throws Exception;

}
