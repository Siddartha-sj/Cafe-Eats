package com.food.DAO;

import java.util.List;

import com.food.model.OrderItem;

public interface OrderItemDAO {
	
	void addOrderItem(OrderItem orderitem);
	OrderItem getOrderItem(int orderitem_id);
	void updateOrderItem(OrderItem orderitem);
	void deleteOrderItem(int orderitem_id);
	List<OrderItem> getOrderItems();
	
	
	
}