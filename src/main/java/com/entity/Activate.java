package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Activate {
	// 活动id
	private Integer activateId;
	// 活动标题
	private String activateTitle;
	// 用户id
	private Integer userId;
	// 用户名称
	private String userName;
	// 活动参与人列表
	private List<ActivatePersonnelList> activatePersonnelLists = new ArrayList<ActivatePersonnelList>();
	// 活动评论
	private List<ActivateReviewDetail> activateReviewDetails = new ArrayList<ActivateReviewDetail>();
	// 活动信息
	private List<ActivateInfo> activateInfos = new ArrayList<ActivateInfo>();

	public Integer getActivateId() {
		return activateId;
	}

	public void setActivateId(Integer activateId) {
		this.activateId = activateId;
	}

	public String getActivateTitle() {
		return activateTitle;
	}

	public void setActivateTitle(String activateTitle) {
		this.activateTitle = activateTitle;
	}

	public List<ActivatePersonnelList> getActivatePersonnelLists() {
		return activatePersonnelLists;
	}

	public void setActivatePersonnelLists(List<ActivatePersonnelList> activatePersonnelLists) {
		this.activatePersonnelLists = activatePersonnelLists;
	}

	public List<ActivateReviewDetail> getActivateReviewDetails() {
		return activateReviewDetails;
	}

	public void setActivateReviewDetails(List<ActivateReviewDetail> activateReviewDetails) {
		this.activateReviewDetails = activateReviewDetails;
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

	public List<ActivateInfo> getActivateInfos() {
		return activateInfos;
	}

	public void setActivateInfos(List<ActivateInfo> activateInfos) {
		this.activateInfos = activateInfos;
	}

}
