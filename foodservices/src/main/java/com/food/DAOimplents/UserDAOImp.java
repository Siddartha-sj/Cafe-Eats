package com.food.DAOimplents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.food.DAO.UserDAO;
import com.food.model.User;

public class UserDAOImp implements UserDAO {
	
	Connection connection=null;
	
	public UserDAOImp()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app","root","root");
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	


	@Override
	public int addUser(User user) {
		String sql = "INSERT into user(user_name,password,email,address,role) values (?,?,?,?,?)";
		
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, user.getUser_name());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getRole());
			
			return stmt.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	
	
	@Override
	public User getUser(String  email) {
		String sql="SELECT * from user where email = ?";
		User UserFromRecord = null;
		
		try {
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setString(1, email);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next())
			{
			
				UserFromRecord = extractUserFromResultSet(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return UserFromRecord;
		
	}

	private User extractUserFromResultSet(ResultSet res) throws SQLException {
		
		User user=new User();
		
		user.setUser_id(res.getInt("user_id"));
		user.setUser_name(res.getString("user_name"));
		user.setPassword(res.getString("password"));
		user.setEmail(res.getString("email"));
		user.setAddress(res.getString("address"));
		user.setRole(res.getString("role"));
		user.setCreated_date(res.getDate("created_date"));
		user.setLast_login_date(res.getDate("last_login_date"));

		return user;
	}



	@Override
	public void updateUser(User user) {
		
		String sql = "UPDATE user set user_name=?, password=?, email=?, address=?, role=? where user_id=?";
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, user.getUser_name());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getRole());
			stmt.setInt(6, user.getUser_id());
			
			
			stmt.executeUpdate();
		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public void deleteUser(int user_id) {
		
		String sql = "DELETE from user where user_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user_id);
			
			stmt.executeUpdate();
			
		} 	
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public List<User> getAllUser() {
		
		String sql = "Select * from user";
		ArrayList<User> al = new ArrayList<User>();
		
		try {
			Statement stmt= connection.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
			while(res.next())
			{
				User user = extractUserFromResultSet(res);
				al.add(user);

			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return al;
	}





}
