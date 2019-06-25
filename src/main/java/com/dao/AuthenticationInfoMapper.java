package com.dao;

import java.util.List;

import com.entity.AuthenticationInfo;

public interface AuthenticationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthenticationInfo record);

    int insertSelective(AuthenticationInfo record);

    AuthenticationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthenticationInfo record);

    int updateByPrimaryKey(AuthenticationInfo record);

	List<AuthenticationInfo> findByAuthenticatorId(Integer authenticatorId);
}