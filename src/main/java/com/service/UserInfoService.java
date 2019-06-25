package com.service;


import java.util.Date;
import java.util.List;

import com.entity.UserInfo;


public interface UserInfoService {

	public UserInfo getUserInfoById(Integer id);

	public int addUserInfo(UserInfo userInfo);

	public void deleteUserInfo(Integer id);

	public void updateUserInfo(UserInfo userInfo);

	public List<UserInfo> findAll();

	public UserInfo findByRealNameAndMajorAndGraduationTime(String userName, String major, Date graduationTime);
}
