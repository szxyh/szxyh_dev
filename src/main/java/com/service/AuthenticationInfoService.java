package com.service;

import java.util.List;

import com.entity.AuthenticationInfo;

public interface AuthenticationInfoService {
	public int addAuthenticationInfo(AuthenticationInfo authenticationInfo);

	public List<AuthenticationInfo> findByAuthenticatorId(Integer authenticatorId);
}
