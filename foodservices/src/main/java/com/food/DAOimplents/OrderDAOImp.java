package com.food.DAOimplents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.food.DAO.OrderDAO;
import com.food.model.Order;

public class OrderDAOImp implements OrderDAO {
	
	Connection connection = null;
	public OrderDAOImp()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app","root","root");
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	

	
	@Override
	public void addOrder(Order order) {
		String sql = "INSERT into orderfood(total_amount, status, payment_method) values(?,?,?)";
		 
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setDouble(1, order.getTotal_amount());
			
			stmt.setString(2, order.getStatus());
			
			stmt.setString(3, order.getPayment_method());
			
			stmt.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	@Override
	public Order getOrder(int order_id) {
		
		String sql="SELECT * from orderfood where order_id = ?";
		Order order = null;
		
		try {
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setInt(1, order_id);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next())
			{
			
				order = extractOrderFromResultSet(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return order;
		
	}

	private Order extractOrderFromResultSet(ResultSet res) throws SQLException {
		
		Order order=new Order();
		
		order.setOrder_id(res.getInt("order_id"));
		order.setUser_id(res.getInt("user_id"));
		order.setRestaurant_id(res.getInt("restaurant_id"));
		order.setDate(res.getDate("order_date"));
		order.setTotal_amount(res.getDouble("total_amount"));
		order.setStatus(res.getString("status"));
		order.setPayment_method(res.getString("payment_method"));
		
		
		return order;
	}

	
	

	
	@Override
	public void updateOrder(Order order) {
		String sql = "UPDATE orderfood set total_amount=?, status=?, payment_method=? where order_id=?";
		
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setDouble(1, order.getTotal_amount());
			stmt.setString(2, order.getStatus());
			stmt.setString(3, order.getPayment_method());
//			foreign keys
			stmt.setInt(4, order.getOrder_id());
			
			stmt.executeUpdate();
			

		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	@Override
	public void deleteOrder(int order_id) {
		
		String sql = "DELETE from orderfood where order_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, order_id);
			
			stmt.executeUpdate();
			
		} 	
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	@Override
	public List<Order> getAllOrdersByUser(int user_id) {
		String sql = "SELECT * from orderfood where user_id=?";
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1	, user_id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				Order order = extractOrderFromResultSet(res);
				orders.add(order);
				
			}
			
			
		} 
		
		
		
		catch (SQLException e) {
			e.printStackTrace();
		}
				
		return orders;
	}


}
