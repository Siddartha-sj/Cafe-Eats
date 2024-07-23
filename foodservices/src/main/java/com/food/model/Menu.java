package com.food.model;

public class Menu {
	
	
	private int menu_id;
	private int restaurant_id;
	private String item_name;
	private String description;
	private double price;
	private boolean is_available;
	private String img_path;
	
	public Menu()
	{
		
	}

	public Menu(int menu_id, int restaurant_id, String item_name, String description, double price,
			boolean is_available, String img_path) {
		super();
		this.menu_id = menu_id;
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.is_available = is_available;
		this.img_path = img_path;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", restaurant_id=" + restaurant_id + ", item_name=" + item_name
				+ ", description=" + description + ", price=" + price + ", is_available=" + is_available + ", img_path="
				+ img_path + "]";
	}
	

}
