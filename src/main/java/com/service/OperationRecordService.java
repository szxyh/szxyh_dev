package com.service;

import java.util.List;

import com.entity.OperationRecord;


public interface OperationRecordService {
	public int addOperationRecord(OperationRecord operationRecord);

	public List<OperationRecord> findAll();
}
