package com.food.DAO;

import java.util.List;

import com.food.model.Order;

public interface OrderDAO {
	
	void addOrder(Order order);
	Order getOrder(int order_id);
	void updateOrder(Order order);
	void deleteOrder(int order_id);
	List<Order> getAllOrdersByUser(int user_id);

}
