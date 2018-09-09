package com.sm.dao;


import com.sm.domain.UserAuth;

public interface UserAuthMapper {
    int deleteByPrimaryKey(Long authId);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(Long authId);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);
}