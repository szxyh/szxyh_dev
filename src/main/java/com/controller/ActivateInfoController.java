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

import com.entity.Activate;
import com.entity.ActivateInfo;
import com.entity.ActivatePersonnelList;
import com.entity.ActivateReviewDetail;
import com.service.ActivateInfoService;
import com.service.ActivatePersonnelListService;
import com.service.ActivateReviewDetailService;

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
	@Resource
	private ActivateInfoService activateInfoService;
	@Resource
	private ActivatePersonnelListService activatePersonnelListService;
	@Resource
	private ActivateReviewDetailService activateReviewDetailService;

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ApiOperation(value = "取得所有活动信息", notes = "展示所有活动")
	@GetMapping(value = "/listAllActivateInfo")
	public List<ActivateInfo> getActivateInfoList() {
		return activateInfoService.findAll();
	}

	@ApiOperation(value = "添加一个活动", notes = "添加一个活动")
	@PostMapping(value = "/addActivate")
	public int addActivate(@RequestParam("title") String title, @RequestParam("actTime") Date actTime,
			@RequestParam("endTime") Date endTime, @RequestParam("act_creator") String act_creator,
			@RequestParam("content") String content, @RequestParam("participateNum") Integer participateNum,
			@RequestParam("cost") Double cost) {
		ActivateInfo activateInfo = new ActivateInfo();
		activateInfo.setTitle(title);
		activateInfo.setActTime(actTime);
		activateInfo.setEndTime(endTime);
		activateInfo.setActCreator(act_creator);
		activateInfo.setContent(content);
		activateInfo.setParticipateNum(participateNum);
		activateInfo.setCost(cost);
		Date dateNow = new Date();
		activateInfo.setCreateTime(dateNow);
		activateInfo.setUpdateTime(dateNow);
		return activateInfoService.addActivateInfo(activateInfo);
	}

	@ApiOperation(value = "更新一个活动", notes = "更新一个活动")
	@PutMapping(value = "/updateActivate/{activateId}")
	public void updateActivate(@PathVariable("activateId") Integer activateId,
			@RequestParam("title") String title,
			@RequestParam("actTime") Date actTime, @RequestParam("endTime") Date endTime,
			@RequestParam("act_creator") String act_creator, @RequestParam("content") String content,
			@RequestParam("participateNum") Integer participateNum, @RequestParam("cost") Double cost) {
		ActivateInfo activateInfo = new ActivateInfo();
		activateInfo.setActivateId(activateId);
		activateInfo.setTitle(title);
		activateInfo.setActTime(actTime);
		activateInfo.setEndTime(endTime);
		activateInfo.setActCreator(act_creator);
		activateInfo.setContent(content);
		activateInfo.setParticipateNum(participateNum);
		activateInfo.setCost(cost);
		activateInfo.setUpdateTime(new Date());
		activateInfoService.updateActivate(activateInfo);
	}

	@ApiOperation(value = "查找指定活动记录", notes = "查找指定活动记录")
	@GetMapping(value = "/find/{activateId}")
	public ActivateInfo getActivateInfo(@PathVariable("activateId") Integer activateId) {
		return activateInfoService.getActivateInfoById(activateId);
	}

	@ApiOperation(value = "删除指定活动", notes = "删除指定活动")
	@DeleteMapping(value = "/delete/{activateId}")
	public void deleteActivateInfo(@PathVariable("activateId") Integer activateId) {
		activateInfoService.deleteActivateInfo(activateId);
	}

	@ApiOperation(value = "活动报名", notes = "活动报名")
	@PostMapping(value = "/activateSignUp")
	public int activateSignUp(@RequestParam("activateId") Integer activateId,
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
		return activatePersonnelListService.addActivatePersonnelList(activatePersonnelList);
	}

	@ApiOperation(value = "活动取消", notes = "活动取消")
	@PutMapping(value = "/activateCancel")
	public Boolean activateCancel(@RequestParam("activateId") Integer activateId,
			@RequestParam("userId") Integer userId, @RequestParam("isParticipate") Boolean isParticipate) {
		ActivatePersonnelList activatePersonnelList = new ActivatePersonnelList();
		activatePersonnelList.setActivateId(activateId);
		activatePersonnelList.setUserId(userId);
		// activatePersonnelList.setIsParticipate(isParticipate);
		activatePersonnelList.setUpdateTime(new Date());
		activatePersonnelListService.updateActivatePersonnelList(activatePersonnelList);
		return Boolean.TRUE;
	}

	@ApiOperation(value = "活动评论", notes = "活动评论")
	@PostMapping(value = "/addActivateReview")
	public int addActivateReview(@RequestParam("activateId") Integer activateId,
			@RequestParam("userId") Integer userId, @RequestParam("userName") String userName,
			@RequestParam("comment") String comment) {
		ActivateReviewDetail activateReviewDetail = new ActivateReviewDetail();
		activateReviewDetail.setActivateId(activateId);
		activateReviewDetail.setUserId(userId);
		activateReviewDetail.setUserName(userName);
		activateReviewDetail.setComment(comment);
		Date dateNow = new Date();
		activateReviewDetail.setCreateTime(dateNow);
		return activateReviewDetailService.addActivateReview(activateReviewDetail);
	}

	@ApiOperation(value = "活动参与人列表", notes = "活动参与人列表")
	@GetMapping(value = "/personnelLists/{activateId}")
	public Activate personnelLists(@RequestParam("activateId") Integer activateId) {
		ActivateInfo activateInfo = activateInfoService.getActivateInfoById(activateId);
		if (activateInfo == null) {
			// 异常处理
		}
		String activateTitle = activateInfo.getTitle();
		List<ActivatePersonnelList> lists = activatePersonnelListService.findByActivateId(activateId);
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
		ActivateInfo activateInfo = activateInfoService.getActivateInfoById(activateId);
		if (activateInfo == null) {
			// 异常处理
		}
		String activateTitle = activateInfo.getTitle();
		List<ActivateReviewDetail> lists = activateReviewDetailService.findByActivateId(activateId);
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
