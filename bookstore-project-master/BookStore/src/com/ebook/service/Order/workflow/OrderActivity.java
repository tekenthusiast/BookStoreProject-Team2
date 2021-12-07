package com.ebook.service.Order.workflow;

import java.util.ArrayList;
import java.util.List;

import com.ebook.dal.OrderDAO;
import com.ebook.model.link.Link;
import com.ebook.model.order.IFacade;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderFacadeImpl;
import com.ebook.service.Order.representation.OrderRepresentation;
import com.ebook.service.Order.representation.OrderRequest;
import com.ebook.service.common.MediaTypes;
import com.ebook.service.common.URIs;
import com.ebook.service.item.representation.ProductRepresentation;


public class OrderActivity {
	
//	OrderDAO orderdao = new OrderDAO();
	IFacade orderFacade = new OrderFacadeImpl();
    

	
	public OrderRepresentation getOrder(String orderId) {
		
		Order order =  orderFacade.getOrder(orderId);
		OrderRepresentation orderRep = new OrderRepresentation();
		
		orderRep.setOrderId(order.getOrderId());
		orderRep.setCustomerId(order.getCustomerId());

		orderRep.setOrderDetails(order.getOrderDetails());
		orderRep.setOrderState(order.getOrderState());
		orderRep.setPayment(order.getPayment());
		orderRep.setPaymentReceived(order.isPaymentReceived());
		return orderRep;
		
	}
	
	public List<OrderRepresentation> getAllOrders() {
		
		List<OrderRepresentation> orderRepList = new ArrayList<OrderRepresentation>();
		List<Order> orders =  orderFacade.getAllOrders();
		for(Order order:orders) {
			OrderRepresentation orderRep = new OrderRepresentation();
			
			
			orderRep.setOrderId(order.getOrderId());
			orderRep.setCustomerId(order.getCustomerId());
			orderRep.setOrderDetails(order.getOrderDetails());
			orderRep.setOrderState(order.getOrderState());
			orderRep.setPayment(order.getPayment());
			orderRep.setPaymentReceived(order.isPaymentReceived());	
			orderRepList.add(orderRep);
		}
		
		return orderRepList;
		
	}
	
	public OrderRepresentation createOrder(OrderRequest orderReq) {
		
		Order order = new Order();
		order.setOrderState(orderReq.getOrderState());
		order.setOrderDetails(orderReq.getOrderDetails());
		order.setPayment(orderReq.getPayment());
		order.setPaymentReceived(orderReq.isPaymentReceived());
		order.setCustomerId(orderReq.getCustomerId());
		
		
		Order order1 = orderFacade.createOrder(order);
		
		OrderRepresentation orderRep = new OrderRepresentation();
		
		orderRep.setOrderId(order1.getOrderId());
//		orderRep.setCustomerId(order1.getCustomerId());
		orderRep.setOrderDetails(order1.getOrderDetails());
		orderRep.setOrderState(order1.getOrderState());
		orderRep.setPayment(order1.getPayment());
		orderRep.setPaymentReceived(order1.isPaymentReceived());
		
		
		setLinks(orderRep);
		return orderRep;
	
	}
	
	public OrderRepresentation updateOrderstatus(String orderId, String Status) {
		
		Order order = orderFacade.updateOrderstatus(orderId, Status);
		
		OrderRepresentation orderRep = new OrderRepresentation();
		
		orderRep.setOrderId(order.getOrderId());
		orderRep.setCustomerId(order.getCustomerId());
		orderRep.setOrderDetails(order.getOrderDetails());
		orderRep.setOrderState(order.getOrderState());
		orderRep.setPayment(order.getPayment());
		orderRep.setPaymentReceived(order.isPaymentReceived());
		return orderRep;
		
	}
	
	public OrderRepresentation getOrderByCustomerId(String customerId) {
		
		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setCustomerId(customerId);
		
		List<String> orderIds =  orderFacade.getOrderByCustomerId(customerId);
		orderRep.setOrderIds(orderIds);
		return orderRep;
		
	}
	
	 private void setLinks(OrderRepresentation prLink) {
	    	
//	    	List<Link> o1 = new ArrayList<Link>();
	    	Link[] mymyLink = {new Link(URIs.ORDERBYID,"Get order by order id",MediaTypes.JSON), 
	    			new Link(URIs.ORDERSBYCUSTOMERID,"Get orders by customerId",MediaTypes.JSON),
	    			new Link(URIs.PRODUCTS,"Continue Shopping",MediaTypes.JSON) };
	    	
//	    	o1.add(new Link(URIs.ORDERBYID,"Get order by order id",MediaTypes.JSON));
//	    	
//	    	o1.add(new Link(URIs.ORDERSBYCUSTOMERID,"Get orders by customerId",MediaTypes.JSON));
//	    	
	    	prLink.setLinks(mymyLink);
//	    		prLink.setLinks(new Link(URIs.ORDERBYID,"Get order by order id",MediaTypes.JSON));
	    		
//	    		prLink.setLinks(new Link(URIs.ORDERSGETALL,"Get all orders",MediaTypes.JSON));
//	    		prLink.setLinks(new Link(URIs.ORDERSBYCUSTOMERID,"Get orders by customerId",MediaTypes.JSON));
	    	
	    }


}
//public class OrderActivity {
//	
////	OrderDAO orderdao = new OrderDAO();
//	IFacade orderdao = new OrderFacadeImpl();
//    
//	public OrderRepresentation getOrder(String orderId) {
//		
//		Order order =  orderdao.getOrder(orderId);
//		OrderRepresentation orderRep = new OrderRepresentation();
//		
//		orderRep.setOrderId(order.getOrderId());
//		orderRep.setCustomerId(order.getCustomerId());
//
//		orderRep.setOrderDetails(order.getOrderDetails());
//		orderRep.setOrderState(order.getOrderState());
//		orderRep.setPayment(order.getPayment());
//		orderRep.setPaymentReceived(order.isPaymentReceived());
//		return orderRep;
//		
//	}
//	
//	public List<OrderRepresentation> getAllOrders() {
//		
//		List<OrderRepresentation> orderRepList = new ArrayList<OrderRepresentation>();
//		List<Order> orders =  orderdao.getAllOrders();
//		for(Order order:orders) {
//			OrderRepresentation orderRep = new OrderRepresentation();
//			
//			
//			orderRep.setOrderId(order.getOrderId());
//			orderRep.setCustomerId(order.getCustomerId());
//			orderRep.setOrderDetails(order.getOrderDetails());
//			orderRep.setOrderState(order.getOrderState());
//			orderRep.setPayment(order.getPayment());
//			orderRep.setPaymentReceived(order.isPaymentReceived());	
//			orderRepList.add(orderRep);
//		}
//		
//		return orderRepList;
//		
//	}
//	
//	public OrderRepresentation createOrder(OrderRequest orderReq) {
//		
//		Order order = new Order();
//		order.setOrderState(orderReq.getOrderState());
//		order.setOrderDetails(orderReq.getOrderDetails());
//		order.setPayment(orderReq.getPayment());
//		order.setPaymentReceived(orderReq.isPaymentReceived());
//		order.setCustomerId(orderReq.getCustomerId());
//		
//		
//		Order order1 = orderdao.createOrder(order);
//		
//		OrderRepresentation orderRep = new OrderRepresentation();
//		
//		orderRep.setOrderId(order1.getOrderId());
////		orderRep.setCustomerId(order1.getCustomerId());
//		orderRep.setOrderDetails(order1.getOrderDetails());
//		orderRep.setOrderState(order1.getOrderState());
//		orderRep.setPayment(order1.getPayment());
//		orderRep.setPaymentReceived(order1.isPaymentReceived());
//		
//		
//		setLinks(orderRep);
//		return orderRep;
//	
//	}
//	
//	public OrderRepresentation updateOrderstatus(String orderId, String Status) {
//		
//		Order order = orderdao.updateOrderstatus(orderId, Status);
//		
//		OrderRepresentation orderRep = new OrderRepresentation();
//		
//		orderRep.setOrderId(order.getOrderId());
//		orderRep.setCustomerId(order.getCustomerId());
//		orderRep.setOrderDetails(order.getOrderDetails());
//		orderRep.setOrderState(order.getOrderState());
//		orderRep.setPayment(order.getPayment());
//		orderRep.setPaymentReceived(order.isPaymentReceived());
//		return orderRep;
//		
//	}
//	
//	public OrderRepresentation getOrderByCustomerId(String customerId) {
//		
//		OrderRepresentation orderRep = new OrderRepresentation();
//		orderRep.setCustomerId(customerId);
//		
//		List<String> orderIds =  orderdao.getOrdersByCustomerId(customerId);
//		orderRep.setOrderIds(orderIds);
//		return orderRep;
//		
//	}
//	
//	 private void setLinks(OrderRepresentation prLink) {
//	    	
////	    	List<Link> o1 = new ArrayList<Link>();
//	    	Link[] mymyLink = {new Link(URIs.ORDERBYID,"Get order by order id",MediaTypes.JSON), 
//	    			new Link(URIs.ORDERSBYCUSTOMERID,"Get orders by customerId",MediaTypes.JSON)};
//	    	
////	    	o1.add(new Link(URIs.ORDERBYID,"Get order by order id",MediaTypes.JSON));
////	    	
////	    	o1.add(new Link(URIs.ORDERSBYCUSTOMERID,"Get orders by customerId",MediaTypes.JSON));
////	    	
//	    	prLink.setLinks(mymyLink);
////	    		prLink.setLinks(new Link(URIs.ORDERBYID,"Get order by order id",MediaTypes.JSON));
//	    		
////	    		prLink.setLinks(new Link(URIs.ORDERSGETALL,"Get all orders",MediaTypes.JSON));
////	    		prLink.setLinks(new Link(URIs.ORDERSBYCUSTOMERID,"Get orders by customerId",MediaTypes.JSON));
//	    	
//	    }
//
//
//}
