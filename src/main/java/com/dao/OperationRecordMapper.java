package com.dao;

import java.util.List;

import com.entity.OperationRecord;


public interface OperationRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationRecord record);

    int insertSelective(OperationRecord record);

    OperationRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationRecord record);

    int updateByPrimaryKey(OperationRecord record);

	List<OperationRecord> findAll();
}