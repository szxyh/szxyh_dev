package com.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ActivateReviewDetailMapper;
import com.entity.ActivateReviewDetail;
import com.service.ActivateReviewDetailService;

@Service("activateReviewDetailService")
public class ActivateReviewDetailServiceImpl implements ActivateReviewDetailService {
	@Resource
	private ActivateReviewDetailMapper activateReviewDetailMapper;

	@Override
	public int addActivateReview(ActivateReviewDetail activateReviewDetail) {
		return activateReviewDetailMapper.insert(activateReviewDetail);
	}

	@Override
	public List<ActivateReviewDetail> findByActivateId(Integer activateId) {
		return activateReviewDetailMapper.findByActivateId(activateId);
	}

}
