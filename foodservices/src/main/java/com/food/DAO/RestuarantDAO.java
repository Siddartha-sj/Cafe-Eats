package com.food.DAO;

import java.util.List;

import com.food.model.Restaurant;

public interface RestuarantDAO {
	
	void addRestuarant(Restaurant restaurant);
	Restaurant getRestuarant(int restaurant_id);
	void updateRestuarant(Restaurant restaurant);
	void deleteRestuarant(int restaurant_id);
	List<Restaurant> getAllRestuarant();
	

}