package com.ebook.model.order;

import java.util.List;

import com.ebook.dal.OrderDAO;
import com.ebook.service.Order.representation.OrderRepresentation;

public class OrderFacadeImpl implements IFacade{
	
	OrderDAO orderdao = new OrderDAO();
    
    
	public Order getOrder(String orderId) {
		return orderdao.getOrder(orderId);
	}
	
	
	
	public Order createOrder(Order order) {
		return orderdao.createOrder(order);
	}
	
	public Order updateOrderstatus(String orderId, String Status) {
		return orderdao.updateOrderstatus(orderId, Status);
	}

	@Override
	public void update(Object id, Object object) {
		// TODO Auto-generated method stub
		orderdao.updateOrderstatus((String)id, (String)object);
	}

	@Override
	public void create(Object object) {
		// TODO Auto-generated method stub
		orderdao.createOrder((Order)object);
	}

	@Override
	public Order get(Object objectId) {
		// TODO Auto-generated method stub
		return orderdao.getOrder((String)objectId);
		
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		

		return  orderdao.getAllOrders();
	}
	
	public List<String> getOrderByCustomerId(String customerId) {
		
		return orderdao.getOrdersByCustomerId(customerId);
	}
	
}
