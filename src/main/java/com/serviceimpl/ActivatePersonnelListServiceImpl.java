package com.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ActivatePersonnelListMapper;
import com.entity.ActivatePersonnelList;
import com.service.ActivatePersonnelListService;

@Service("activatePersonnelListService")
public class ActivatePersonnelListServiceImpl implements ActivatePersonnelListService {
	@Resource
	private ActivatePersonnelListMapper activatePersonnelListMapper;

	@Override
	public int addActivatePersonnelList(ActivatePersonnelList activatePersonnelList) {
		return activatePersonnelListMapper.insert(activatePersonnelList);
	}

	@Override
	public void updateActivatePersonnelList(ActivatePersonnelList activatePersonnelList) {
		activatePersonnelListMapper.updateByPrimaryKey(activatePersonnelList);
	}

	@Override
	public List<ActivatePersonnelList> findByActivateId(Integer activateId) {
		return activatePersonnelListMapper.findByActivateId(activateId);
	}

}
