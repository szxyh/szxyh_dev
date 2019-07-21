package com.resitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ActivateReviewDetail;

public interface ActivateReviewDetailResitory extends JpaRepository<ActivateReviewDetail, Integer> {
	public List<ActivateReviewDetail> findByActivateId(Integer activateId);
}
