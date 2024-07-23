package com.food.DAOimplents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.food.DAO.OrderHistoryDAO;
import com.food.model.OrderHistory;


public class OrderHistoryDAOImp implements OrderHistoryDAO {
	
	Connection connection = null;
	public OrderHistoryDAOImp()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app","root","root");
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public void addOrderHistory(OrderHistory orderhistory) {
		
		String sql = "INSERT into orderhistory(total_amount, status) values(?,?)";
		 
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setDouble(1, orderhistory.getTotal_amount());
			stmt.setString(2, orderhistory.getStatus());
			
//			foreign key
			
			
			stmt.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

	@Override
	public OrderHistory getOrderHistory(int orderhistory_id) {
		String sql="SELECT * from orderhistory where order_history_id = ?";
		OrderHistory orderhistory = null;
		
		try {
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setInt(1, orderhistory_id);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next())
			{
			
				orderhistory = extractOrderHistoryFromResultSet(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return orderhistory;
		
	}

	private OrderHistory extractOrderHistoryFromResultSet(ResultSet res) throws SQLException {
		
		OrderHistory orderhistory = new OrderHistory();
		
		orderhistory.setUser_id(res.getInt("user_id"));
		orderhistory.setOrder_id(res.getInt("order_id"));
		orderhistory.setOrder_date(res.getDate("order_date"));
		orderhistory.setTotal_amount(res.getDouble("total_amount"));
		orderhistory.setStatus(res.getString("status"));
		orderhistory.setOrder_history_id(res.getInt("order_history_id"));
		
		return orderhistory;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void updateOrderHistory(OrderHistory orderhistory) {
		String sql = "UPDATE orderhistory set total_amount=?, status=? where order_history_id=?";
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setDouble(1, orderhistory.getTotal_amount());
			stmt.setString(2, orderhistory.getStatus());
			stmt.setInt(3, orderhistory.getOrder_history_id());
			
//			foreign keys
			
			stmt.executeUpdate();
			

		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	@Override
	public void deleteOrderHistory(int orderhistory_id) {
		String sql = "DELETE from orderhistory where order_history_id=?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, orderhistory_id);
			
			stmt.executeUpdate();
			
		} 	
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
	

	
	
	
	@Override
	public List<OrderHistory> getOrderHistoryByUser(int user_id) {
		String sql = "SELECT * from orderhistory where user_id=?";
		ArrayList<OrderHistory> orderhistorys = new ArrayList<OrderHistory>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				OrderHistory orderhistory = extractOrderHistoryFromResultSet(res);
				orderhistorys.add(orderhistory);
				
			}
			
			
		} 
		
		
		
		catch (SQLException e) {
			e.printStackTrace();
		}
				
		return orderhistorys;
	}

}
