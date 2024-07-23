package com.tap.servlets;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOimplents.MenuDAOImp;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		HttpSession session =  req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		String action=req.getParameter("action");
		if("add".equals(action))
		{
			addItemToCart(req,cart);
		}
		else if(update.)
		{
			
		}
		
		
		
	}
	
	
	
	private void addItemToCart(HttpServletRequest req,Cart cart)
	{
		int itemId= Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAOImp  menuDAO = new MenuDAOImp();
		Menu menuitem =  menuDAO.getMenu(itemId);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("restuarantId",menuitem.getRestaurant_id());
		
		if(menuitem != null)
		{
			CartItem item = new CartItem(menuitem.getMenu_id(), menuitem.getRestaurant_id(),menuitem.getItem_name(),quantity,menuitem.getPrice());
			cart.addItem(item);
		}
		
		 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
