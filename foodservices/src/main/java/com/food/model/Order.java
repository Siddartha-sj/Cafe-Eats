package com.food.model;
import java.util.Date;

public class Order {

	private int order_id;
	private int user_id;
	private int restaurant_id;
	private Date date;
	private double total_amount;
	private String status;
	private String payment_method;
	
	public Order()
	{
		
	}

	public Order(int order_id, int user_id, int restaurant_id, double total_amount, String status,
			String payment_method) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.payment_method = payment_method;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", restaurant_id=" + restaurant_id + ", date="
				+ date + ", total_amount=" + total_amount + ", status=" + status + ", payment_method=" + payment_method
				+ "]";
	}
	
	
}
