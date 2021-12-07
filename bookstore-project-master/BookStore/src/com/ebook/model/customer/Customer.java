package com.ebook.model.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ebook.model.order.Order;

@XmlRootElement
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String lastName;
	private String firstName;	
	private Address billingAddress;
	private Address shippingAddress;
//	private List<Order> orders = new ArrayList<Order>();	
	private List<String> orders = new ArrayList<String>();

	public Customer() {}

	public String getcustomerId() {
		return customerId;
	}
	
	public void setcustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Address getbillingAddress() {
		return billingAddress;
	}
	
	public void setbillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public Address getshippingAddress() {
		return shippingAddress;
	}
	
	public void setshippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
//	
//	public void addOrder(Order order) {
//		orders.add(order);
//	}
	
	
	
}
