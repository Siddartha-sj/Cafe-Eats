package com.food.DAO;

import java.util.List;

import com.food.model.Menu;

public interface MenuDAO {
	
	void addMenu(Menu menu);
	Menu getMenu(int menu_id);
	void updateMenu(Menu menu);
	void deleteMenu(int menu_id);
	List<Menu> getAllMenusByRestuarant(int restuarant_id);

}
