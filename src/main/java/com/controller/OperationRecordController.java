package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.OperationRecord;
import com.service.OperationRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 操作记录
 * 
 * @author lyz
 *
 */
@Api(value = "/api", tags = "Api接口")
@RestController
@RequestMapping("/szxyh/operationRecord")
public class OperationRecordController {
	@Resource
	private OperationRecordService operationRecordService;

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ApiOperation(value = "取得所有操作记录", notes = "展示所有操作记录")
	@GetMapping(value = "/listAllOperationRecord")
	public List<OperationRecord> getOperationRecordList() {
		return operationRecordService.findAll();
	}

	@ApiOperation(value = "添加一条操作记录", notes = "添加一条操作记录")
	@PostMapping(value = "/addOperationRecord")
	public int addOperationRecord(@RequestParam("userId") Integer userId,
			@RequestParam("action") String action) {
		OperationRecord operationRecord = new OperationRecord();
		operationRecord.setUserId(userId);
		Date dateNow = new Date();
		operationRecord.setCreateTime(dateNow);
		operationRecord.setOperationTime(dateNow);
		operationRecord.setAction(action);
		return operationRecordService.addOperationRecord(operationRecord);
	}

}
