package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AuthenticationInfo;
import com.entity.UserInfo;
import com.service.AuthenticationInfoService;
import com.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户信息
 * 
 * @author lyz
 *
 */
@Api(value = "/api", tags = "Api接口")
@RestController
@RequestMapping("/szxyh/userInfo")
public class UserInfoController {
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private AuthenticationInfoService authenticationInfoService;

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ApiOperation(value = "取得所有用户信息", notes = "展示所有信息")
	@GetMapping(value = "/listAll")
	public List<UserInfo> getUserInfoList() {
		return userInfoService.findAll();
	}

	@ApiOperation(value = "添加一个用户", notes = "添加一个用户")
	@PostMapping(value = "/add")
	public int addUser(@RequestParam("realName") String realName, @RequestParam("sex") Integer sex,
			@RequestParam("phoneNum") Long phoneNum, @RequestParam("entranceTime") Date entranceTime,
			@RequestParam("graduationTime") Date graduationTime, @RequestParam("college") String college,
			@RequestParam("major") String major, @RequestParam("currLocation") String currLocation,
			String industrySkill, String hobby, String personalProfile, @RequestParam("wechatImage") String wechatImage,
			String openId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setRealName(realName);
		userInfo.setSex(sex == 1 ? true : false);
		userInfo.setPhoneNum(phoneNum);
		userInfo.setEntranceTime(entranceTime);
		userInfo.setGraduationTime(graduationTime);
		userInfo.setCollege(college);
		userInfo.setMajor(major);
		userInfo.setCurrLocation(currLocation);
		userInfo.setIndustrySkill(industrySkill);
		userInfo.setHobby(hobby);
		userInfo.setPersonalProfile(personalProfile);
		userInfo.setWechatImage(wechatImage);
		if (openId == "" || openId == null) {
			openId = " ";
		}
		userInfo.setOpenId(openId);
		Date dateNow = new Date();
		userInfo.setCreateTime(dateNow);
		userInfo.setUpdateTime(dateNow);
		return userInfoService.addUserInfo(userInfo);
	}

	@ApiOperation(value = "更新一个用户", notes = "更新一个用户")
	@PutMapping(value = "/update/{id}")
	public void updateUser(@PathVariable("id") Integer id, @RequestParam("realName") String realName,
			@RequestParam("sex") Integer sex, @RequestParam("phoneNum") Long phoneNum,
			@RequestParam("entranceTime") Date entranceTime, @RequestParam("graduationTime") Date graduationTime,
			@RequestParam("college") String college, @RequestParam("major") String major,
			@RequestParam("currLocation") String currLocation, String industrySkill, String hobby,
			String personalProfile, @RequestParam("wechatImage") String wechatImage, String openId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setRealName(realName);
		userInfo.setSex(sex == 1 ? true : false);
		userInfo.setPhoneNum(phoneNum);
		userInfo.setEntranceTime(entranceTime);
		userInfo.setGraduationTime(graduationTime);
		userInfo.setCollege(college);
		userInfo.setMajor(major);
		userInfo.setCurrLocation(currLocation);
		userInfo.setHobby(hobby);
		userInfo.setPersonalProfile(personalProfile);
		userInfo.setWechatImage(wechatImage);
		userInfo.setOpenId(openId);
		userInfo.setUpdateTime(new Date());
		userInfoService.updateUserInfo(userInfo);
	}

	@ApiOperation(value = "查找指定用户", notes = "查找指定用户")
	@GetMapping(value = "/find/{id}")
	public UserInfo getUserInfo(@PathVariable("id") Integer id) {
		UserInfo userInfo = userInfoService.getUserInfoById(id);
		return userInfo;
	}

	@ApiOperation(value = "删除指定用户", notes = "删除指定用户")
	@DeleteMapping(value = "/delete/{id}")
	public void deleteUserInfo(@PathVariable("id") Integer id) {
		userInfoService.deleteUserInfo(id);
	}

	@ApiOperation(value = "用户激活", notes = "指定用户激活")
	@PutMapping(value = "/activateUser")
	public Boolean activateUser(@RequestParam("userName") String userName,
			@RequestParam("major") String major, @RequestParam("graduationTime") Date graduationTime,
			@RequestParam("openId") String openId) {
		// 判断待激活用户是否在表中，根据userName、major、graduationTime三个字段唯一识别
		UserInfo userInfo = userInfoService.findByRealNameAndMajorAndGraduationTime(userName, major, graduationTime);
		// 判断待激活用户是否已经激活，已经激活的不需要再激活
		if (userInfo.getUserStatus() == Boolean.TRUE) {
			return Boolean.TRUE;
		}

		// 激活用户并更新openId字段
		userInfo.setUserStatus(Boolean.TRUE);
		userInfo.setOpenId(openId);
		userInfoService.updateUserInfo(userInfo);

		return true;
	}

	@ApiOperation(value = "用户认证", notes = "指定用户认证")
	@PutMapping(value = "/certifie")
	public void userCertifie(@RequestParam("certifiedUserId") Integer certifiedUserId,
			@RequestParam("authenticatorId") Integer authenticatorId) {
		List<AuthenticationInfo> authenticationInfoList = authenticationInfoService
				.findByAuthenticatorId(authenticatorId);
		if (authenticationInfoList.size() >= 2) {
			return;
		}
		addAuthenticationInfo(certifiedUserId, authenticatorId);
		List<AuthenticationInfo> infoList = authenticationInfoService.findByAuthenticatorId(authenticatorId);
		if (infoList.size() < 2) {
			return;
		}
		UserInfo userInfo = userInfoService.getUserInfoById(authenticatorId);
		userInfo.setUserStatus(Boolean.TRUE);
		userInfo.setUpdateTime(new Date());
		userInfoService.updateUserInfo(userInfo);
	}

	@ApiOperation(value = "添加一条用户认证信息", notes = "添加一条用户认证信息")
	@PostMapping(value = "/addAuthenticationInfo")
	public int addAuthenticationInfo(@RequestParam("certifiedUserId") Integer certifiedUserId,
			@RequestParam("authenticatorId") Integer authenticatorId) {
		AuthenticationInfo authenticationInfo = new AuthenticationInfo();
		authenticationInfo.setCertifiedUserId(certifiedUserId);
		authenticationInfo.setAuthenticatorId(authenticatorId);
		authenticationInfo.setCertifieTime(new Date());
		return authenticationInfoService.addAuthenticationInfo(authenticationInfo);
	}

}
