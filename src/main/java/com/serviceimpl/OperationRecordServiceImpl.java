package com.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.OperationRecordMapper;
import com.entity.OperationRecord;
import com.service.OperationRecordService;

@Service("operationRecordService")
public class OperationRecordServiceImpl implements OperationRecordService {
	@Resource
	private OperationRecordMapper operationRecordMapper;

	@Override
	public int addOperationRecord(OperationRecord operationRecord) {
		return operationRecordMapper.insert(operationRecord);
	}

	@Override
	public List<OperationRecord> findAll() {
		return operationRecordMapper.findAll();
	}

}
