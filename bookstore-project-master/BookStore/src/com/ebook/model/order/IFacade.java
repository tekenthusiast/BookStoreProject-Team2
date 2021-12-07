package com.ebook.model.order;

import java.util.List;

import com.ebook.service.Order.representation.OrderRepresentation;

public interface IFacade {

	public Order getOrder(String orderId);
	
	public Order createOrder(Order order);
	
	public Order updateOrderstatus(String orderId, String Status);
	
	public void update(Object id, Object object);
	
	public void create(Object object);
	
	public Object get(Object objectId);
	
	public List<Order> getAllOrders();
	
	public List<String> getOrderByCustomerId(String customerId);
}
