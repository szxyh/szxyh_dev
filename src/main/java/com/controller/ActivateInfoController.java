package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.entity.Activate;
import com.entity.ActivateInfo;
import com.entity.ActivatePersonnelList;
import com.entity.ActivateReviewDetail;
import com.resitory.ActivateInfoResitory;
import com.resitory.ActivatePersonnelListResitory;
import com.resitory.ActivateReviewDetailResitory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动信息
 * 
 * @author lyz
 *
 */
@Api(value = "/api", tags = "Api接口")
@RestController
@RequestMapping("/szxyh/activateInfo")
public class ActivateInfoController {
	@Autowired
	private ActivateInfoResitory activateInfoResitory;
	@Autowired
	private ActivatePersonnelListResitory activatePersonnelListResitory;
	@Autowired
	private ActivateReviewDetailResitory activateReviewDetailResitory;

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ApiOperation(value = "取得所有活动信息", notes = "展示所有活动")
	@GetMapping(value = "/listAllActivateInfo")
	public List<ActivateInfo> getActivateInfoList() {
		return activateInfoResitory.findAll();
	}

	@ApiOperation(value = "取得某个用户参加的所有活动信息", notes = "取得某个用户参加的所有活动信息")
	@GetMapping(value = "/listUserAllActivateInfo")
	public Activate getActivateInfoByUserId(@PathVariable("userId") Integer userId) {
		List<ActivatePersonnelList> activatePersonnelLists = activatePersonnelListResitory.findByUserId(userId);
		Activate activate = new Activate();
		if (activatePersonnelLists == null || activatePersonnelLists.size() == 0) {
			return activate;
		}
		List<ActivateInfo> activateInfos = new ArrayList<ActivateInfo>();
		for (ActivatePersonnelList activatePersonnelList : activatePersonnelLists) {
			Integer activateId = activatePersonnelList.getActivateId();
			String userName = activatePersonnelList.getUserName();
			ActivateInfo activateInfo = activateInfoResitory.findOne(activateId);
			activate.setUserName(userName);
			activateInfos.add(activateInfo);
		}
		activate.setUserId(userId);
		activate.setActivateInfos(activateInfos);
		return activate;
	}

	@ApiOperation(value = "添加一个活动", notes = "添加一个活动")
	@PostMapping(value = "/addActivate")
	public ActivateInfo addActivate(@RequestParam("title") String title,
			@RequestParam("activateImage") String activateImage, @RequestParam("actTime") Date actTime,
			@RequestParam("endTime") Date endTime, @RequestParam("act_creator") String act_creator,
			@RequestParam("content") String content, @RequestParam("participateNum") Integer participateNum,
			@RequestParam("cost") Double cost) {
		ActivateInfo activateInfo = new ActivateInfo();
		activateInfo.setTitle(title);
		activateInfo.setActivateImage(activateImage);
		activateInfo.setActTime(actTime);
		activateInfo.setEndTime(endTime);
		activateInfo.setActCreator(act_creator);
		activateInfo.setContent(content);
		activateInfo.setParticipateNum(participateNum);
		activateInfo.setCost(cost);
		Date dateNow = new Date();
		activateInfo.setCreateTime(dateNow);
		activateInfo.setUpdateTime(dateNow);
		return activateInfoResitory.save(activateInfo);
	}

	@ApiOperation(value = "更新一个活动", notes = "更新一个活动")
	@PutMapping(value = "/updateActivate/{activateId}")
	public ActivateInfo updateActivate(@PathVariable("activateId") Integer activateId,
			@RequestParam("title") String title, @RequestParam("activateImage") String activateImage,
			@RequestParam("actTime") Date actTime, @RequestParam("endTime") Date endTime,
			@RequestParam("act_creator") String act_creator, @RequestParam("content") String content,
			@RequestParam("participateNum") Integer participateNum, @RequestParam("cost") Double cost) {
		ActivateInfo activateInfo = new ActivateInfo();
		activateInfo.setActivateId(activateId);
		activateInfo.setTitle(title);
		activateInfo.setActivateImage(activateImage);
		activateInfo.setActTime(actTime);
		activateInfo.setEndTime(endTime);
		activateInfo.setActCreator(act_creator);
		activateInfo.setContent(content);
		activateInfo.setParticipateNum(participateNum);
		activateInfo.setCost(cost);
		activateInfo.setUpdateTime(new Date());
		return activateInfoResitory.save(activateInfo);
	}

	@ApiOperation(value = "查找指定活动记录", notes = "查找指定活动记录")
	@GetMapping(value = "/find/{activateId}")
	public ActivateInfo getUserInfo(@PathVariable("activateId") Integer activateId) {
		return activateInfoResitory.findOne(activateId);
	}

	@ApiOperation(value = "删除指定活动", notes = "删除指定活动")
	@DeleteMapping(value = "/delete/{activateId}")
	public void deleteUserInfo(@PathVariable("activateId") Integer activateId) {
		activateInfoResitory.delete(activateId);
	}

	@ApiOperation(value = "活动报名", notes = "活动报名")
	@PostMapping(value = "/activateSignUp")
	public ActivatePersonnelList activateSignUp(@RequestParam("activateId") Integer activateId,
			@RequestParam("userId") Integer userId, @RequestParam("userName") String userName,
			@RequestParam("isDrive") Boolean isDrive, @RequestParam("isFamily") Boolean isFamily,
			@RequestParam("isManned") Boolean isManned, @RequestParam("isParticipate") Boolean isParticipate) {
		ActivatePersonnelList activatePersonnelList = new ActivatePersonnelList();
		activatePersonnelList.setActivateId(activateId);
		activatePersonnelList.setUserId(userId);
		activatePersonnelList.setUserName(userName);
		activatePersonnelList.setIsDrive(isDrive);
		activatePersonnelList.setIsFamily(isFamily);
		activatePersonnelList.setIsManned(isManned);
		activatePersonnelList.setIsParticipate(isParticipate);
		Date dateNow = new Date();
		activatePersonnelList.setCreateTime(dateNow);
		activatePersonnelList.setUpdateTime(dateNow);
		return activatePersonnelListResitory.save(activatePersonnelList);
	}

	@ApiOperation(value = "活动取消", notes = "活动取消")
	@PutMapping(value = "/activateCancel")
	public Boolean activateCancel(@RequestParam("activateId") Integer activateId,
			@RequestParam("userId") Integer userId, @RequestParam("isParticipate") Boolean isParticipate) {
		ActivatePersonnelList activatePersonnelList = new ActivatePersonnelList();
		activatePersonnelList.setActivateId(activateId);
		activatePersonnelList.setUserId(userId);
		activatePersonnelList.setIsParticipate(isParticipate);
		activatePersonnelList.setUpdateTime(new Date());
		activatePersonnelListResitory.save(activatePersonnelList);
		return Boolean.TRUE;
	}

	@ApiOperation(value = "活动评论", notes = "活动评论")
	@PostMapping(value = "/addActivateReview")
	public ActivateReviewDetail addActivateReview(@RequestParam("activateId") Integer activateId,
			@RequestParam("userId") Integer userId, @RequestParam("userName") String userName,
			@RequestParam("comment") String comment) {
		ActivateReviewDetail activateReviewDetail = new ActivateReviewDetail();
		activateReviewDetail.setActivateId(activateId);
		activateReviewDetail.setUserId(userId);
		activateReviewDetail.setUserName(userName);
		activateReviewDetail.setComment(comment);
		Date dateNow = new Date();
		activateReviewDetail.setCreateTime(dateNow);
		return activateReviewDetailResitory.save(activateReviewDetail);
	}

	@ApiOperation(value = "活动参与人列表", notes = "活动参与人列表")
	@GetMapping(value = "/personnelLists/{activateId}")
	public Activate personnelLists(@RequestParam("activateId") Integer activateId) {
		ActivateInfo activateInfo = activateInfoResitory.findOne(activateId);
		if (activateInfo == null) {
			// 异常处理
		}
		String activateTitle = activateInfo.getTitle();
		List<ActivatePersonnelList> lists = activatePersonnelListResitory.findByActivateId(activateId);
		if (lists == null || lists.size() == 0) {
			// 异常处理
		}
		Activate activate = new Activate();
		activate.setActivateId(activateId);
		activate.setActivateTitle(activateTitle);
		activate.setActivatePersonnelLists(lists);
		return activate;
	}

	@ApiOperation(value = "活动回顾", notes = "活动回顾")
	@GetMapping(value = "/reviewList/{activateId}")
	public Activate reviewList(@RequestParam("activateId") Integer activateId) {
		ActivateInfo activateInfo = activateInfoResitory.findOne(activateId);
		if (activateInfo == null) {
			// 异常处理
		}
		String activateTitle = activateInfo.getTitle();
		List<ActivateReviewDetail> lists = activateReviewDetailResitory.findByActivateId(activateId);
		if (lists == null || lists.size() == 0) {
			// 异常处理
		}
		Activate activate = new Activate();
		activate.setActivateId(activateId);
		activate.setActivateTitle(activateTitle);
		activate.setActivateReviewDetails(lists);
		return activate;
	}

}
