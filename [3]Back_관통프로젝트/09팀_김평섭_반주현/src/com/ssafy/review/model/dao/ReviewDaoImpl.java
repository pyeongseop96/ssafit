package com.ssafy.review.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.review.model.dto.Review;

public class ReviewDaoImpl implements ReviewDao {

	private static ReviewDao dao = new ReviewDaoImpl();

	private List<Review> list = new ArrayList<>(); // 데이터 베이스 대신

	private ReviewDaoImpl() {
		list.add(new Review("운동 너무 어렵다.", "김싸피", "포기야..포기김치 맛있다."));
		list.add(new Review("오늘 좀 운동이 잘 되는데?", "박싸피", "평소보다 30분 더한다. 끝나고 치킨이다."));
		list.add(new Review("집에가고싶다", "이싸피", "절대로 나 아님 ㅎ"));

	}

	public static ReviewDao getInstance() {
		return dao;
	}

	@Override
	public List<Review> selectAll() {
		return list;
	}

	@Override
	public void insertReview(Review review) {
		list.add(review);
	}

	@Override
	public Review selectOne(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id)
				return list.get(i);
		}
		return null;
	}

	@Override
	public void updateReview(Review review) {
		for(int i = 0 ; i<list.size(); i++) {
			Review b = list.get(i);
			if(b.getId() == review.getId()) {
				b.setTitle(review.getTitle());
				b.setContent(review.getContent());
				return;
			}
		}
	}

	@Override
	public void deleteReview(int id) {
		for(int i = 0 ; i<list.size(); i++) {
			Review b = list.get(i);
			if(b.getId() == id) {
				list.remove(i);
				return;
			}
		}
	}

	@Override
	public void updateViewCnt(int id) {
		for (int i = 0; i < list.size(); i++) {
			Review b = list.get(i);
			if (b.getId() == id) {
				int viewCnt = b.getViewCnt();
				b.setViewCnt(viewCnt + 1);
				break;
			}
		}
	}

}
