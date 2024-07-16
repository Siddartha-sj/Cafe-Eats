package com.tap.main;

import java.util.List;
import java.util.Scanner;

import com.food.DAO.RestuarantDAO;
import com.food.DAOimplents.OrderHistoryDAOImp;
import com.food.DAOimplents.OrderItemDAOImp;
import com.food.DAOimplents.MenuDAOImp;
import com.food.DAOimplents.OrderDAOImp;
import com.food.DAOimplents.UserDAOImp;
import com.food.model.OrderHistory;
import com.food.model.OrderItem;
import com.food.model.Menu;
import com.food.model.Order;
import com.food.model.User;

public class Launch {

	public static void main(String[] args) {
		
		
		Scanner scan= new Scanner(System.in);

		
		
//		Order order = new Order(3, "mysorecafe", "idly", 20, "doddpet", 4.7, true, null);
//		OrderDAOImp r = new OrderDAOImp();
//		r.addRestuarant(order);
		
		
//		Order order = new Order(2, "laxmi tiffen", "dose", 20, "doddpet", 4.7, true, null);
//		OrderDAOImp r = new OrderDAOImp();
//		r.updateRestuarant(order);
		
		
		
//		System.out.print("restaturant_id:");
//		OrderDAOImp r = new OrderDAOImp();
//		r.deleteRestuarant(scan.nextInt());
		
		
//		OrderDAOImp r = new OrderDAOImp();
//		List<Order> al = r.getAllRestuarant();
//		for(Order order : al)
//		{
//			System.out.println(order);
//		}
		
		
//		OrderHistoryDAOImp oh = new OrderHistoryDAOImp();
//		List<OrderHistory> al = oh.getOrderHistoryByUser(3);
//		for(OrderHistory t : al )
//			{
//				System.out.println(t);
//			}
		
		OrderHistoryDAOImp r = new OrderHistoryDAOImp();
		List<OrderHistory> al = r.getOrderHistoryByUser(3);
		for(OrderHistory t : al)
			{
				System.out.println(t);
			}
		
		
		
		
	}

}
