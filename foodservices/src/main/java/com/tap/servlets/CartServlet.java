package com.tap.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
		
		 List<CartItem> menus = new ArrayList<>();
		    
		    // Retrieve parameters
		    String quantity = req.getParameter("quantity");
		    String menuId = req.getParameter("menuId");
		    String action = req.getParameter("action");
		    int restaurantId = Integer.parseInt(req.getParameter("restaurantid"));
		    
		    HttpSession session = req.getSession();
		    session.setAttribute("restaurantId", restaurantId);
		    
		   //System.out.println(quantity);
		   //System.out.println(menuId);
		   //System.out.println(action);
		   
		    // Add to a list (you may need to adapt this part based on your actual needs)
		    if (quantity != null && menuId != null && action != null) {
		    	CartItem cartitemgpt = new CartItem();
		    	cartitemgpt.setItem_id(Integer.parseInt(menuId));
		    	cartitemgpt.setQuantity(Integer.parseInt(quantity));
		        menus.add(cartitemgpt);
		    }
		    
		    
		
		
		session.setAttribute("cartMenus", menus);
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		
		
		if("add".equals(action))
		{
			addItemToCart(req,cart);
		}
		else if("update".equals(action))
		{
			updateCartItem(req, cart);
		}
		else if("remove".equals(action))
		{
			removeItemFromCart(req, cart);
		}
		
		
		session.setAttribute("cart", cart);
		resp.sendRedirect("Cart.jsp");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	private void addItemToCart(HttpServletRequest req,Cart cart)
	{

		int menuId= Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAOImp  menuDAO = new MenuDAOImp();
		Menu menu =  menuDAO.getMenu(menuId);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("restuarantId",menu.getRestaurant_id());
		
		if(menu != null)
		{
			CartItem item = new CartItem(menu.getMenu_id(), menu.getRestaurant_id(),menu.getItem_name(),quantity,menu.getPrice());
			cart.addItem(item);
		}
		
		
	}
	
	
	
	public void updateCartItem(HttpServletRequest req, Cart cart)
	{
		int menuId= Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		cart.updateItem(menuId,quantity);
	}
	
	
	public void removeItemFromCart(HttpServletRequest req, Cart cart)
	{
		int menuId= Integer.parseInt(req.getParameter("menuId"));
		cart.removeItem(menuId);
	}
	
	
	
	
	
	
	
	
	
	

}
