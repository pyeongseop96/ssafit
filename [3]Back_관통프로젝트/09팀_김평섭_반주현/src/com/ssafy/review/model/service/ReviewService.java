package com.ssafy.review.model.service;

import java.util.List;

import com.ssafy.review.model.dto.Review;

//사용자 친화적으로 작성
public interface ReviewService {
	// 게시글 전체 조회
	List<Review> getList();

	// 게시글 등록
	void writeReview(Review review);

	// 게시글 상세 조회
	Review getReview(int id);

	// 게시글 수정
	void modifyReview(Review review);

	// 게시글 삭제
	void removeReview(int id);
}
