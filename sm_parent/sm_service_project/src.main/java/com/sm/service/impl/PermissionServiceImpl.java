package com.sm.service.impl;

import com.sm.dao.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sm.domain.Permission;
import com.sm.service.PermissionService;


@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 新增数据
     * @param record
     * @return
     */
    @Override
        public int insert(Permission record) throws Exception{
        System.out.println("222222222222");
        if (record == null){
            return 0;
        }else {
            int insert = permissionMapper.insert(record);
            return insert;
        }
    }

    /**
     *
     * @param perId
     * @return
     */
    @Override
    public Permission selectByPrimaryKey(Integer perId) throws Exception{
        Permission permission = permissionMapper.selectByPrimaryKey(perId);
        return permission;
    }

}
