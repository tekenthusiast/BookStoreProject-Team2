package com.ebook.model.order;

public class Payment {
	
	private Long paymentId;
	private String paymentStatus;
	private Double subTotal;
	private String paymentType;

	
	public Payment() {

	}

	public Payment(Long paymentId, String paymentStatus, double subTotal) {
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.subTotal = subTotal;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}	
	

}
