package com.tap.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderDAO;
import com.food.DAOimplents.OrderDAOImp;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.User;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private OrderDAO orderDAO;
    
    
    @Override
    public void init() throws ServletException {
    	orderDAO = new OrderDAOImp();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		User user=(User)session.getAttribute("user");
		
		
		if(cart != null && user !=null && !cart.getItems().isEmpty())
		{
			
			String paymentmethod = request.getParameter("paymentmethod");
			Order order = new Order();
			order.setUser_id(user.getUser_id());
			
			System.out.println(session.getAttribute("restaurantId"));
			
			order.setRestaurant_id((int)session.getAttribute("restaurantId"));
			order.setDate(new Date());
			order.setPayment_method(paymentmethod);
			order.setStatus("Pending");
			
			
			double totalamount=0;
			for(CartItem item : cart.getItems().values())
			{
				totalamount = item.getPrice() * item.getQuantity();
			}
			order.setTotal_amount(totalamount);
			
			orderDAO.addOrder(order);
			
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			response.sendRedirect("OrderConfirmation.jsp");
			
		}
		else
		{
			response.sendRedirect("cart.jsp");
		}
		
		
	}

	
	
}
