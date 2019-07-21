package com.resitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.OperationRecord;

public interface OperationRecordResitory extends JpaRepository<OperationRecord, Integer> {

}
