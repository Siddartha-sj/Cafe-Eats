package com.food.model;

public class Restaurant {
	
	private int restaurant_id;
	private String name;
	private String cousine_type;
	private int delivery_time;
	private String address;
	private int admin_user_id;
	private double rating;
	private boolean is_active;
	private String img_path;
	
	
	public Restaurant()
	{
		
	}


	public Restaurant(int restaurant_id, String name, String cousine_type, int delivery_time, String address,
			 double rating, boolean is_active, String img_path) {
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.cousine_type = cousine_type;
		this.delivery_time = delivery_time;
		this.address = address;
//		this.admin_user_id = admin_user_id;
		this.rating = rating;
		this.is_active = is_active;
		this.img_path = img_path;
	}


	public int getRestaurant_id() {
		return restaurant_id;
	}


	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCousine_type() {
		return cousine_type;
	}


	public void setCousine_type(String cousine_type) {
		this.cousine_type = cousine_type;
	}


	public int getDelivery_time() {
		return delivery_time;
	}


	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAdmin_user_id() {
		return admin_user_id;
	}


	public void setAdmin_user_id(int admin_user_id) {
		this.admin_user_id = admin_user_id;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public boolean getIs_active() {
		return is_active;
	}


	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}


	public String getImg_path() {
		return img_path;
	}


	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}


	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", name=" + name + ", cousine_type=" + cousine_type
				+ ", delivery_time=" + delivery_time + ", address=" + address + ", admin_user_id=" + admin_user_id
				+ ", rating=" + rating + ", is_active=" + is_active + ", img_path=" + img_path + "]";
	}
	
	
}
