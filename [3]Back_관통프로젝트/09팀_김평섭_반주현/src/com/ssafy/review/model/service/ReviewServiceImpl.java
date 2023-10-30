package com.ssafy.review.model.service;

import java.util.List;

import com.ssafy.review.model.dao.ReviewDao;
import com.ssafy.review.model.dao.ReviewDaoImpl;
import com.ssafy.review.model.dto.Review;

public class ReviewServiceImpl implements ReviewService {

	private static ReviewService service = new ReviewServiceImpl();
	
	//의존성 주입
	private ReviewDao dao = ReviewDaoImpl.getInstance();
	
	
	private ReviewServiceImpl() {
	}
	
	public static ReviewService getInstance() {
		return service;
	}
	
	
	@Override
	public List<Review> getList() {
		return dao.selectAll();
	}

	@Override
	public void writeReview(Review review) {
		dao.insertReview(review);
	}

	@Override
	public Review getReview(int id) {
		dao.updateViewCnt(id);
		return dao.selectOne(id);
	}

	@Override
	public void modifyReview(Review review) {
		dao.updateReview(review);
	}

	@Override
	public void removeReview(int id) {
		dao.deleteReview(id);
	}

}
