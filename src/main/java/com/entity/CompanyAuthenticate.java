package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 企业认证表
 * 
 * @author lyz
 *
 */
@Entity
@Table(name = "company_authenticate")
@org.hibernate.annotations.Table(appliesTo = "company_authenticate", comment = "企业认证")
public class CompanyAuthenticate {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, name = "user_id", columnDefinition = "int(11) COMMENT '用户id'")
	private Integer userId;
	@Column(nullable = false, name = "company_name", columnDefinition = "varchar(200) COMMENT '企业名称'")
	private String companyName;
	@Column(nullable = false, columnDefinition = "varchar(200) COMMENT '所属行业'")
	private String industry;
	@Column(nullable = false, columnDefinition = "varchar(200) COMMENT '企业logo'")
	private String logo;
	@Lob
	@Column(nullable = true, name = "brief_introduction", columnDefinition = "TEXT COMMENT '企业简介'")
	private String briefIntroduction;
	@Lob
	@Column(nullable = true, name = "other_info", columnDefinition = "TEXT COMMENT '其他自由发挥字段'")
	private String otherInfo;
	@Column(nullable = false, name = "auth_status", columnDefinition = "tinyint(1) COMMENT '认证状态'")
	private Boolean authStatus = Boolean.FALSE;
	@Column(nullable = false, name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date createTime;
	@Column(nullable = false, name = "update_time", columnDefinition = "DATETIME COMMENT '更新时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBriefIntroduction() {
		return briefIntroduction;
	}

	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Boolean getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Boolean authStatus) {
		this.authStatus = authStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
