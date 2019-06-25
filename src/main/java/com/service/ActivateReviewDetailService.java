package com.service;

import java.util.List;

import com.entity.ActivateReviewDetail;

public interface ActivateReviewDetailService {
	public int addActivateReview(ActivateReviewDetail activateReviewDetail);

	public List<ActivateReviewDetail> findByActivateId(Integer activateId);

}
