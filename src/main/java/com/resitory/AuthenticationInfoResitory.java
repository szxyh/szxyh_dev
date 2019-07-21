package com.resitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AuthenticationInfo;

public interface AuthenticationInfoResitory extends JpaRepository<AuthenticationInfo, Integer> {
	public List<AuthenticationInfo> findByAuthenticatorId(Integer authenticatorId);
}
