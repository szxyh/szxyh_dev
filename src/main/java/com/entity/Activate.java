package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Activate {
	// 活动id
	private Integer activateId;
	// 活动标题
	private String activateTitle;
	// 活动参与人列表
	private List<ActivatePersonnelList> activatePersonnelLists = new ArrayList<ActivatePersonnelList>();
	// 活动评论
	private List<ActivateReviewDetail> activateReviewDetails = new ArrayList<ActivateReviewDetail>();

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

}
