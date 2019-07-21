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
 * 用户信息表
 * 
 * @author lyz
 *
 */
@Entity
@Table(name = "user_info")
@org.hibernate.annotations.Table(appliesTo = "user_info", comment = "用户信息")
public class UserInfo {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, name = "real_name", columnDefinition = "varchar(50) COMMENT '真实姓名'")
	private String realName;
	@Column(nullable = false, columnDefinition = "tinyint(1) COMMENT '性别'")
	private Integer sex;
	@Column(nullable = false, name = "phone_num", columnDefinition = "int(11) COMMENT '手机号'")
	private Long phoneNum;
	@Column(nullable = false, name = "entrance_time", columnDefinition = "DATETIME COMMENT '入学时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date entranceTime;
	@Column(nullable = false, name = "graduation_time", columnDefinition = "DATETIME COMMENT '毕业时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date graduationTime;
	@Column(nullable = false, columnDefinition = "varchar(50) COMMENT '学院名称'")
	private String college;
	@Column(nullable = false, columnDefinition = "varchar(50) COMMENT '专业名称'")
	private String major;
	@Column(nullable = false, name = "curr_location", columnDefinition = "varchar(100) COMMENT '当前所在地'")
	private String currLocation;
	@Column(nullable = true, name = "industry_skill", columnDefinition = "varchar(200) COMMENT '行业技能'")
	private String industrySkill;
	@Column(nullable = true, columnDefinition = "varchar(200) COMMENT '兴趣爱好'")
	private String hobby;
	@Lob
	@Column(nullable = true, name = "personal_profile", columnDefinition = "TEXT COMMENT '个人说明'")
	private String personalProfile;
	@Column(nullable = false, name = "user_status", columnDefinition = "tinyint(1) COMMENT '用户状态'")
	private Boolean userStatus = Boolean.FALSE;
	@Column(nullable = false, name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date createTime;
	@Column(nullable = false, name = "update_time", columnDefinition = "DATETIME COMMENT '更新时间'")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date updateTime;
	@Column(nullable = false, name = "wechat_image", columnDefinition = "varchar(200) COMMENT '微信头像'")
	private String wechatImage;
	@Column(nullable = false, name = "open_id", columnDefinition = "varchar(100) COMMENT 'open id'")
	private String openId = new String(" ");
	@Column(nullable = false, columnDefinition = "double COMMENT '用户积分'")
	private Double score = Double.valueOf(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(Date entranceTime) {
		this.entranceTime = entranceTime;
	}

	public Date getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCurrLocation() {
		return currLocation;
	}

	public void setCurrLocation(String currLocation) {
		this.currLocation = currLocation;
	}

	public String getIndustrySkill() {
		return industrySkill;
	}

	public void setIndustrySkill(String industrySkill) {
		this.industrySkill = industrySkill;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getPersonalProfile() {
		return personalProfile;
	}

	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}

	public Boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
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

	public String getWechatImage() {
		return wechatImage;
	}

	public void setWechatImage(String wechatImage) {
		this.wechatImage = wechatImage;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
