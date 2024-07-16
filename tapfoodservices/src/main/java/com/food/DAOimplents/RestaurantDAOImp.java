package com.food.DAOimplents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestuarantDAO;
import com.food.model.Restaurant;


public class RestaurantDAOImp implements RestuarantDAO {
	
	Connection connection = null;
	public RestaurantDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app","root","root");
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void addRestuarant(Restaurant restaurant) {
    
		String sql = "INSERT into restaurant(name, cousine_type, delivery_time, address, rating, is_active) values(?,?,?,?,?,?)";
		 
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, restaurant.getName());
			stmt.setString(2, restaurant.getCousine_type());
			stmt.setInt(3, restaurant.getDelivery_time());
			stmt.setString(4, restaurant.getAddress());
//			stmt.setInt(5, restaurant.getAdmin_user_id());
			stmt.setDouble(5, restaurant.getRating());
			stmt.setBoolean(6, restaurant.getIs_active());
			
			stmt.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Restaurant getRestuarant(int restaurant_id) {
		
		String sql="SELECT * from restaurant where restaurant_id = ?";
		Restaurant restaurant = null;
		
		try {
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setInt(1, restaurant_id);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next())
			{
			
				restaurant = extractRestaurantFromResultSet(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return restaurant;
		
	}

	private Restaurant extractRestaurantFromResultSet(ResultSet res) throws SQLException {
		
		Restaurant restaurant=new Restaurant();
		
		restaurant.setRestaurant_id(res.getInt("restaurant_id"));
		restaurant.setName(res.getString("name"));
		restaurant.setCousine_type(res.getString("cousine_type"));
		restaurant.setAddress(res.getString("address"));
		restaurant.setDelivery_time(res.getInt("delivery_time"));
		restaurant.setRating(res.getInt("rating"));
		restaurant.setIs_active(res.getBoolean("is_active"));
		restaurant.setAdmin_user_id(res.getInt("admin_user_id"));
		restaurant.setImg_path(res.getString("img_path"));
		
		return restaurant;
	}
		
		


	@Override
	public void updateRestuarant(Restaurant restaurant) {
		String sql = "UPDATE restaurant set name=?, cousine_type=?, delivery_time=?, address=?, rating=?, is_active=? where restaurant_id=?";
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, restaurant.getName());
			stmt.setString(2, restaurant.getCousine_type());
			stmt.setInt(3, restaurant.getDelivery_time());
			stmt.setString(4, restaurant.getAddress());
//			stmt.setInt(5, restaurant.getAdmin_user_id());
			stmt.setDouble(5, restaurant.getRating());
			stmt.setBoolean(6, restaurant.getIs_active());
			stmt.setInt(7, restaurant.getRestaurant_id());
			
			stmt.executeUpdate();
			

		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public void deleteRestuarant(int restaurant_id) {
		
		String sql = "DELETE from restaurant where restaurant_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, restaurant_id);
			
			stmt.executeUpdate();
			
		} 	
		catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}
	
	
	
	

	@Override
	public List<Restaurant> getAllRestuarant() {
		String sql = "SELECT * from restaurant";
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				Restaurant restaurant = extractRestaurantFromResultSet(res);
				restaurants.add(restaurant);
				
			}
			
			
		} 
		
		
		
		catch (SQLException e) {
			e.printStackTrace();
		}
				
		return restaurants;
	}

}
