package com.entity;

import java.util.Date;

public class ActivatePersonnelList {
    private Integer id;

    private Integer activateId;

    private Integer userId;

    private String userName;

	private Boolean isDrive;

	private Boolean isFamily;

	private Boolean isManned;

	private Boolean isParticipate;

    private Date createTime;

    private Date updateTime;

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
        this.userName = userName == null ? null : userName.trim();
    }

	public Boolean getIsDrive() {
        return isDrive;
    }

	public void setIsDrive(Boolean isDrive) {
        this.isDrive = isDrive;
    }

	public Boolean getIsFamily() {
        return isFamily;
    }

	public void setIsFamily(Boolean isFamily) {
        this.isFamily = isFamily;
    }

	public Boolean getIsManned() {
        return isManned;
    }

	public void setIsManned(Boolean isManned) {
        this.isManned = isManned;
    }

	public Boolean getIsParticipate() {
        return isParticipate;
    }

	public void setIsParticipate(Boolean isParticipate) {
        this.isParticipate = isParticipate;
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