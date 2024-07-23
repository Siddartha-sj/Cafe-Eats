package com.food.DAO;

import java.util.List;

import com.food.model.OrderHistory;

public interface OrderHistoryDAO {
	void addOrderHistory(OrderHistory orderhistory);
	OrderHistory getOrderHistory(int orderhistory_id);
	void updateOrderHistory(OrderHistory orderhistory);
	void deleteOrderHistory(int orderhistory_id);
	List<OrderHistory> getOrderHistoryByUser(int user_id);
	

}
