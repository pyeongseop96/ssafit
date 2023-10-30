package com.ssafy.review.model.dao;

import java.util.List;

import com.ssafy.review.model.dto.Review;

public interface ReviewDao {
	// 게시글 전체 조회
	List<Review> selectAll();

	// 게시글 등록
	void insertReview(Review review);

	// 게시글 상세 조회
	Review selectOne(int id);

	// 게시글 수정
	void updateReview(Review review);

	// 게시글 삭제
	void deleteReview(int id);

	// 조회수 증가
	void updateViewCnt(int id);

}
