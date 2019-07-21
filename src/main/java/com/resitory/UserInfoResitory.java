package com.resitory;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserInfo;

public interface UserInfoResitory extends JpaRepository<UserInfo, Integer> {
	public UserInfo findByRealNameAndMajorAndGraduationTime(String userName, String major, Date graduationTime);
}
