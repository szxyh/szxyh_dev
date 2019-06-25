package com.service;

import java.util.List;

import com.entity.ActivatePersonnelList;

public interface ActivatePersonnelListService {
	public int addActivatePersonnelList(ActivatePersonnelList activatePersonnelList);

	public void updateActivatePersonnelList(ActivatePersonnelList activatePersonnelList);

	public List<ActivatePersonnelList> findByActivateId(Integer activateId);
}
