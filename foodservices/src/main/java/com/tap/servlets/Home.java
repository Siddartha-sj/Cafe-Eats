package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.RestuarantDAO;
import com.food.DAOimplents.RestaurantDAOImp;
import com.food.model.Restaurant;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       RestuarantDAO restaurant;
    /**
     * @see HttpServlet#HttpServlet()
     */
       @Override
    public void init() throws ServletException {
    	restaurant = new RestaurantDAOImp();    
    	}
    
       
       
       public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     List<Restaurant> restaurantlist = restaurant.getAllRestuarant();
		
     	
		req.setAttribute("restaurantlist", restaurantlist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
		dispatcher.include(req, resp);
	}
		
		
		
		
	}

