package com.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserInfoMapper;
import com.entity.UserInfo;
import com.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoMapper userInfoMapper;


	@Override
	public UserInfo getUserInfoById(Integer id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addUserInfo(UserInfo userInfo) {
		return userInfoMapper.insert(userInfo);
	}

	@Override
	public void deleteUserInfo(Integer id) {
		userInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userInfoMapper.updateByPrimaryKey(userInfo);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoMapper.findAll();
	}

	@Override
	public UserInfo findByRealNameAndMajorAndGraduationTime(String userName, String major, Date graduationTime) {
		return userInfoMapper.findByRealNameAndMajorAndGraduationTime(userName, major, graduationTime);
	}
}
