package com.ebook.model.item;

import com.ebook.model.customer.Customer;

public class Review {
	private Integer reviewId;
	private String title;
	private String description;
	private Integer rating;
	private Customer customer;
	
	// Default Constructor
	public Review() {
	}

	public Review(Integer reviewId, String title, String description, Integer rating, Customer customer) {
		this.reviewId = reviewId;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.customer = customer;
	}
	
	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
