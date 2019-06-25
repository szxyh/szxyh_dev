package com.dao;

import java.util.Date;
import java.util.List;

import com.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKeyWithBLOBs(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	List<UserInfo> findAll();

	UserInfo findByRealNameAndMajorAndGraduationTime(String userName, String major, Date graduationTime);
}