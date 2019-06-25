package com.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AuthenticationInfoMapper;
import com.entity.AuthenticationInfo;
import com.service.AuthenticationInfoService;

@Service("authenticationInfoService")
public class AuthenticationInfoServiceImpl implements AuthenticationInfoService {
	@Resource
	private AuthenticationInfoMapper authenticationInfoMapper;

	@Override
	public int addAuthenticationInfo(AuthenticationInfo authenticationInfo) {
		return authenticationInfoMapper.insert(authenticationInfo);
	}

	@Override
	public List<AuthenticationInfo> findByAuthenticatorId(Integer authenticatorId) {
		return authenticationInfoMapper.findByAuthenticatorId(authenticatorId);
	}
}
