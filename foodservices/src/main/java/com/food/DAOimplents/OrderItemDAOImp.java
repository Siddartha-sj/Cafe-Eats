package com.food.DAOimplents;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.model.OrderItem;


public class OrderItemDAOImp implements OrderItemDAO {

	Connection connection = null;
	public OrderItemDAOImp()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app","root","root");
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void addOrderItem(OrderItem orderitem) {
		String sql = "INSERT into orderitem(quantity, item_total) values(?,?)";
		 
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
//			stmt.setInt(1, orderitem.getOrder_id());
//			stmt.setInt(2, orderitem.getMenu_id());
			stmt.setInt(1, orderitem.getQuantity());
			stmt.setDouble(2, orderitem.getItem_total());
			
			stmt.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	@Override
	public OrderItem getOrderItem(int orderitem_id) {
		String sql="SELECT * from orderitem where order_item_id = ?";
		OrderItem orderitem = null;
		
		try {
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setInt(1, orderitem_id);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next())
			{
			
				orderitem = extractOrderItemFromResultSet(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return orderitem;
		
	}

	private OrderItem extractOrderItemFromResultSet(ResultSet res) throws SQLException {
		
		OrderItem orderitem=new OrderItem();
		
		orderitem.setOrder_item_id(res.getInt("order_item_id"));
		orderitem.setOrder_id(res.getInt("order_id"));
		orderitem.setMenu_id(res.getInt("menu_id"));
		orderitem.setQuantity(res.getInt("quantity"));
		orderitem.setItem_total(res.getDouble("item_total"));
		
		return orderitem;
	}

	
	
	
	
	
	
	@Override
	public void updateOrderItem(OrderItem orderitem) {
		String sql = "UPDATE orderitem set quantity=?, item_total=? where order_item_id=?";
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setInt(1, orderitem.getQuantity());
			stmt.setDouble(2, orderitem.getItem_total());
//			foreign keys
			stmt.setInt(3, orderitem.getOrder_item_id());
			
			stmt.executeUpdate();
			

		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	@Override
	public void deleteOrderItem (int orderitem_id) {
		String sql = "DELETE from orderitem where order_item_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, orderitem_id);
			
			stmt.executeUpdate();
			
		} 	
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	@Override
	public List<OrderItem> getOrderItems() {
		String sql = "SELECT * from orderitem";
		ArrayList<OrderItem> orderitems = new ArrayList<OrderItem>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				OrderItem orderitem = extractOrderItemFromResultSet(res);
				orderitems.add(orderitem);
				
			}
			
		} 
		

		catch (SQLException e) {
			e.printStackTrace();
		}
				
		return orderitems;
	}
}
