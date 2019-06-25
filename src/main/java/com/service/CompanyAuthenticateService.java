package com.service;

import java.util.List;

import com.entity.CompanyAuthenticate;


public interface CompanyAuthenticateService {
	public int addCompanyAuthenticate(CompanyAuthenticate companyAuthenticate);

	public void updateCompanyAuthenticate(CompanyAuthenticate companyAuthenticate);

	public CompanyAuthenticate getById(Integer id);

	public void deleteCompanyAuthenticate(Integer id);

	public List<CompanyAuthenticate> findAll();

}
