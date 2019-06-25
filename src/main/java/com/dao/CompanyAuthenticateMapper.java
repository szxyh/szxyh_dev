package com.dao;

import java.util.List;

import com.entity.CompanyAuthenticate;


public interface CompanyAuthenticateMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(CompanyAuthenticate record);

	int insertSelective(CompanyAuthenticate record);

	CompanyAuthenticate selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CompanyAuthenticate record);

	int updateByPrimaryKeyWithBLOBs(CompanyAuthenticate record);

    int updateByPrimaryKey(CompanyAuthenticate record);

	List<CompanyAuthenticate> findAll();
}