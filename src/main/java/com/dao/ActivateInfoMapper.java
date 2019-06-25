package com.dao;

import java.util.List;

import com.entity.ActivateInfo;

public interface ActivateInfoMapper {
    int deleteByPrimaryKey(Integer activateId);

    int insert(ActivateInfo record);

    int insertSelective(ActivateInfo record);

    ActivateInfo selectByPrimaryKey(Integer activateId);

    int updateByPrimaryKeySelective(ActivateInfo record);

    int updateByPrimaryKey(ActivateInfo record);

	List<ActivateInfo> findAll();
}