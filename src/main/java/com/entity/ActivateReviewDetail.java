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
 * 活动回顾表
 * 
 * @author lyz
 *
 */
@Entity
@Table(name = "activate_review_detail")
@org.hibernate.annotations.Table(appliesTo = "activate_review_detail", comment = "活动回顾")
public class ActivateReviewDetail {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, name = "activate_id", columnDefinition = "int(11) COMMENT '活动id'")
	private Integer activateId;
	@Column(nullable = false, name = "user_id", columnDefinition = "int(11) COMMENT '用户id'")
	private Integer userId;
	@Column(nullable = false, name = "user_name", columnDefinition = "varchar(20) COMMENT '用户名称'")
	private String userName;
	@Lob
	@Column(nullable = true, columnDefinition = "TEXT COMMENT '用户评论'")
	private String comment;
	@Column(nullable = false, name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivateId() {
		return activateId;
	}

	public void setActivateId(Integer activateId) {
		this.activateId = activateId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
