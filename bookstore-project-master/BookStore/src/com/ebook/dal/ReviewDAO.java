package com.ebook.dal;

import java.util.HashMap;
import java.util.List;

import com.ebook.model.item.Review;

public class ReviewDAO {
private static HashMap <Integer, Review> reviews = new HashMap <Integer, Review>();
	
	public ReviewDAO() {		
	}
	
	public Review getReviewById(Integer reviewId) {
		return reviews.get(reviewId);
	}
	
	public void AddReview(Review review) {
		Review rev = new Review();
		rev.setReviewId(review.getReviewId());
		reviews.put(rev.getReviewId(), rev);
	}

	public List<Review> getAllReviews() {
		return (List<Review>) reviews.values(); 
	}

	public boolean removeReview(Review review) {
		Review rev = new Review();
		rev.setReviewId(review.getReviewId());
		return reviews.remove(rev.getReviewId(), rev);
	}


}
