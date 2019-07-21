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
 * 活动信息表
 * 
 * @author lyz
 *
 */
@Entity
@Table(name = "activate_info")
@org.hibernate.annotations.Table(appliesTo = "activate_info", comment = "活动信息")
public class ActivateInfo {
	@Id
	@GeneratedValue
	@Column(name = "activate_id", columnDefinition = "int(11) COMMENT '活动id'")
	private Integer activateId;
	@Column(nullable = false, columnDefinition = "varchar(100) COMMENT '活动标题'")
	private String title;
	@Column(nullable = false, name = "activate_image", columnDefinition = "varchar(200) COMMENT '活动图片'")
	private String activateImage;
	@Column(nullable = false, name = "act_time", columnDefinition = "DATETIME COMMENT '活动时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date actTime;
	@Column(nullable = false, name = "end_time", columnDefinition = "DATETIME COMMENT '报名截止时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date endTime;
	@Column(nullable = false, name = "act_creator", columnDefinition = "varchar(50) COMMENT '活动发起人'")
	private String actCreator;
	@Lob
	@Column(nullable = false, columnDefinition = "TEXT COMMENT '活动内容'")
	private String content;
	@Column(nullable = false, name = "participate_num", columnDefinition = "int(11) COMMENT '参加人数'")
	private Integer participateNum = Integer.valueOf(0);
	@Column(nullable = false)
	private Double cost = Double.valueOf(0);
	@Column(nullable = false, name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date createTime;
	@Column(nullable = false, name = "update_time", columnDefinition = "DATETIME COMMENT '更新时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date updateTime;

	public Integer getActivateId() {
		return activateId;
	}

	public void setActivateId(Integer activateId) {
		this.activateId = activateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActivateImage() {
		return activateImage;
	}

	public void setActivateImage(String activateImage) {
		this.activateImage = activateImage;
	}

	public Date getActTime() {
		return actTime;
	}

	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getActCreator() {
		return actCreator;
	}

	public void setActCreator(String actCreator) {
		this.actCreator = actCreator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getParticipateNum() {
		return participateNum;
	}

	public void setParticipateNum(Integer participateNum) {
		this.participateNum = participateNum;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
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
