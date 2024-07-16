package com.food.model;

import java.util.Date;

public class User {
	
	private int user_id;
	private String user_name;
	private String password;
	private String email;
	private String address;
	private String role;
	private Date created_date;
	private Date last_login_date;
	

	public User()
	{
		
		
	}
	
	
	public User(String user_name, String password, String email, String address, String role) {
		super();
//		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role + ", created_date=" + created_date + ", last_login_date="
				+ last_login_date + "]";
	}
	

}