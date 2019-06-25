package com.service;

import java.util.List;

import com.entity.ActivateInfo;

public interface ActivateInfoService {
	public int addActivateInfo(ActivateInfo activateInfo);

	public ActivateInfo getActivateInfoById(Integer id);

	public void updateActivate(ActivateInfo activateInfo);

	public void deleteActivateInfo(Integer id);

	public List<ActivateInfo> findAll();

}
