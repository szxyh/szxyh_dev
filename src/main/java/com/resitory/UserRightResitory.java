package com.resitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserRight;


public interface UserRightResitory extends JpaRepository<UserRight, Integer> {
	public List<UserRight> findByUserId(Integer userId);
}
