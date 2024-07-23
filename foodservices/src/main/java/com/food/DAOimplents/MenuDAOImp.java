package com.food.DAOimplents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.food.DAO.MenuDAO;
import com.food.model.Menu;


public class MenuDAOImp implements MenuDAO {

	Connection connection = null;
	public MenuDAOImp()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app","root","root");
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void addMenu(Menu menu) {
		String sql = "INSERT into menu(item_name, description, price, is_available) values(?,?,?,?)";
		 
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, menu.getItem_name());
			stmt.setString(2, menu.getDescription());
			stmt.setDouble(3, menu.getPrice());
			stmt.setBoolean(4, menu.getIs_available());
//			foreign keys
			
			stmt.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	@Override
	public Menu getMenu(int menu_id) {
		String sql="SELECT * from menu where menu_id = ?";
		Menu menu = null;
		
		try {
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setInt(1, menu_id);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next())
			{
			
				menu = extractMenuFromResultSet(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return menu;
		
	}

	private Menu extractMenuFromResultSet(ResultSet res) throws SQLException {
		
		Menu menu=new Menu();
		
		menu.setMenu_id(res.getInt("menu_id"));
		menu.setRestaurant_id(res.getInt("restaurant_id"));
		menu.setItem_name(res.getString("item_name"));
		menu.setDescription(res.getString("description"));
		menu.setPrice(res.getDouble("price"));
		menu.setIs_available(res.getBoolean("is_available"));
		menu.setImg_path(res.getString("img_path"));
		
		return menu;
	}

	
	
	
	
	@Override
	public void updateMenu(Menu menu) {
		String sql = "UPDATE menu set item_name=?, description=?, price=?, is_available=? where menu_id=?";
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, menu.getItem_name());
			stmt.setString(2, menu.getDescription());
			stmt.setDouble(3, menu.getPrice());
			stmt.setBoolean(4, menu.getIs_available());
//			foreign keys
			stmt.setInt(5, menu.getMenu_id());
			
			stmt.executeUpdate();
			

		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	

	
	@Override
	public void deleteMenu(int menu_id) {
		String sql = "DELETE from menu where menu_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, menu_id);
			
			stmt.executeUpdate();
			
		} 	
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	@Override
	public List<Menu> getAllMenusByRestuarant(int restaurant_id) {
		String sql = "SELECT * from menu where restaurant_id = ?";
		ArrayList<Menu> menus = new ArrayList<Menu>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, restaurant_id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				Menu menu = extractMenuFromResultSet(res);
				menus.add(menu);
				
			}
			
			
		} 
		
		
		
		catch (SQLException e) {
			e.printStackTrace();
		}
				
		return menus;
	}


}
