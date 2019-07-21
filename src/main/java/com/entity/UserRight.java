package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户权限
 * 
 * @author lyz
 *
 */
@Entity
@Table(name = "user_right")
@org.hibernate.annotations.Table(appliesTo = "user_right", comment = "用户权限")
public class UserRight {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, name = "jurisdiction_id", columnDefinition = "int(11) COMMENT '权限id'")
	private Integer jurisdictionId;
	@Column(nullable = false, name = "jurisdiction_name", columnDefinition = "varchar(50) COMMENT '权限名称'")
	private String jurisdictionName;
	@Column(nullable = false, name = "user_id", columnDefinition = "int(11) COMMENT '用户id'")
	private Integer userId;
	@Column(nullable = false, name = "auth_user_id", columnDefinition = "int(11) COMMENT '审核人id'")
	private Integer authUserId;
	@Column(nullable = false, name = "jur_status", columnDefinition = "tinyint(1) COMMENT '权限状态'")
	private Boolean jurStatus = Boolean.FALSE;
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

	public Integer getJurisdictionId() {
		return jurisdictionId;
	}

	public void setJurisdictionId(Integer jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}

	public String getJurisdictionName() {
		return jurisdictionName;
	}

	public void setJurisdictionName(String jurisdictionName) {
		this.jurisdictionName = jurisdictionName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAuthUserId() {
		return authUserId;
	}

	public void setAuthUserId(Integer authUserId) {
		this.authUserId = authUserId;
	}

	public Boolean getJurStatus() {
		return jurStatus;
	}

	public void setJurStatus(Boolean jurStatus) {
		this.jurStatus = jurStatus;
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
