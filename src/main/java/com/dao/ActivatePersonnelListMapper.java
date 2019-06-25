package com.dao;

import java.util.List;

import com.entity.ActivatePersonnelList;

public interface ActivatePersonnelListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivatePersonnelList record);

    int insertSelective(ActivatePersonnelList record);

    ActivatePersonnelList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivatePersonnelList record);

    int updateByPrimaryKey(ActivatePersonnelList record);

	List<ActivatePersonnelList> findByActivateId(Integer activateId);
}