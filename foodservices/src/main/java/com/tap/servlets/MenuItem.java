package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAOimplents.MenuDAOImp;
import com.food.model.Menu;

/**
 * Servlet implementation class MenuItem
 */
@WebServlet("/menu")
public class MenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		MenuDAOImp menus = new MenuDAOImp();
		List<Menu> menulist = menus.getAllMenusByRestuarant(restaurantId);
		
		req.setAttribute("menulist", menulist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Menu.jsp");
		dispatcher.include(req, resp);

		
		
		
	}
			
	}

