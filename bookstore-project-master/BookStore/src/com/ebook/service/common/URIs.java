package com.ebook.service.common;

public class URIs {
	
	public static final String ORDERUPDATE = "http://localhost:8080/orderservice/order/update";
	
	public static final String PRODUCTS = "http://localhost:8080/productservice/product";
	
	public static final String ORDERBYID = "http://localhost:8080/orderservice/order/{orderId}";

	public static final String ORDERSGETALL = "http://localhost:8080/orderservice/orders";
	
	public static final String ORDERCREATE = "http://localhost:8080/orderservice/order";
	
	public static final String ORDERSBYCUSTOMERID = "http://localhost:8080/orderservice/orders/{customerId}";
	
	
	public static final String CUSTOMERSGETALL = "http://localhost:8080/customerservice/customer";
	public static final String CUSTOMERSGETBYID = "http://localhost:8080/customerservice/customer/{customerId}";
	
	
	public static final String CUSTOMERADD = "http://localhost:8080/customerservice/customer";
	
	public static final String CUSTOMERDELBYID = "http://localhost:8080/customerservice/customer/{customerId}";
}
