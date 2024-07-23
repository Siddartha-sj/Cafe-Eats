package com.food.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<Integer,CartItem> items;
	
	public Cart()
	{
		this.items=new HashMap<Integer,CartItem>();
	}
	
	public void addItem(CartItem cartitem)
	{
		int itemId = cartitem.getItem_id();
		if(items.containsKey(itemId))
		{
			CartItem existingcartitem = items.get(itemId);
			existingcartitem.setQuantity(existingcartitem.getQuantity()+ cartitem.getQuantity());
		}
		else
		{
			items.put(itemId,cartitem);
		}
		
	}

	public void updateItem(int itemId,int quantity)
	{
		if(items.containsKey(itemId))
		{
			if(quantity<=0)
			{
				items.remove(itemId);
			}
			else
			{
				items.get(itemId).setQuantity(quantity);
			}
		}
	}
	
	
	public void removeItem(int itemId)
	{
		items.remove(itemId);
	}
	
	
	
	public Map<Integer,CartItem> getItems()
	{
		return items;
	}
	
	
	
	public void clear()
	{
		items.clear();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
