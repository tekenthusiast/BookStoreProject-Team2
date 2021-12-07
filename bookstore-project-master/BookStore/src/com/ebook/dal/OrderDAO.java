package com.ebook.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ebook.model.customer.Customer;
import com.ebook.model.item.Product;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.Payment;

@Repository
public class OrderDAO {
	
	private static HashMap <String, Order> orders = new HashMap <String, Order>();
	
	private static HashMap <String, List<String>> custmoerOrders = new HashMap <String, List<String>>();

	
	public OrderDAO() {
		
	}
	
	public Order getOrder(String orderId) {
		
		return orders.get(orderId);
		
	}
	
	public List<String> getOrdersByCustomerId(String customerId) {
		List<String> orderList = custmoerOrders.get(customerId);
		return orderList;
		
	}
	public List<Order> getAllOrders() {
		List<Order> orderList = new ArrayList<Order>(orders.values());

	return orderList;
		
	}
	public Order createOrder(Order order) {
		
		Order newOrder = new Order();
		newOrder.setOrderId(UUID.randomUUID().toString());
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		
//		orderDetails = order.getOrderDetails();
//		for(int i = 0; i < order.getOrderDetails().size(); i++)
		
			for(OrderDetail orderdetail : order.getOrderDetails()){
			Product newProduct = new Product();
			Product product = orderdetail.getProduct();
			
			newProduct.setproductId(product.getproductId());
			newProduct.setPrice(product.getPrice());
			newProduct.setTitle(product.getTitle());
			newProduct.setDescription(product.getDescription());
			newProduct.setAuthor(product.getAuthor());
			
			OrderDetail neworderDetail = new OrderDetail();
			neworderDetail.setProduct(newProduct);
			neworderDetail.setQuantity(orderdetail.getQuantity());
			orderDetails.add(neworderDetail);

			
		}
	
		
		newOrder.setOrderDetails(orderDetails);
		
		newOrder.setCustomerId(order.getCustomerId());
		
		if(custmoerOrders.get(order.getCustomerId()) !=  null) {
			
			List<String> newOrderIds = custmoerOrders.get(order.getCustomerId());
			newOrderIds.add(newOrder.getOrderId());
			
			custmoerOrders.put(order.getCustomerId(), newOrderIds);
			
		}
		else {
		
			List<String> newOrderIds = new ArrayList<String>();
			newOrderIds.add(newOrder.getOrderId());
			
			custmoerOrders.put(order.getCustomerId(), newOrderIds);
			
		}
		
		
		
		newOrder.setOrderState(order.getOrderState());
		newOrder.setPaymentReceived(order.isPaymentReceived());
		
		
		Payment newPayment = new Payment();
		newPayment.setPaymentId(order.getPayment().getPaymentId());
		newPayment.setPaymentStatus(order.getPayment().getPaymentStatus());
		newPayment.setPaymentType(order.getPayment().getPaymentType());
		
		
		newOrder.setPayment(newPayment);
		
		orders.put(newOrder.getOrderId(), newOrder);
		
		return newOrder;
		
	}
	
	
	
	public Order updateOrderstatus(String orderId, String Status) {
		
		orders.get(orderId).setOrderState(Status);
		return orders.get(orderId);
	}
	
	
	
	

}
