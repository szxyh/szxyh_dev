package com.resitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ActivatePersonnelList;

public interface ActivatePersonnelListResitory extends JpaRepository<ActivatePersonnelList, Integer> {
	public List<ActivatePersonnelList> findByActivateId(Integer activateId);

	public List<ActivatePersonnelList> findByUserId(Integer userId);
}

