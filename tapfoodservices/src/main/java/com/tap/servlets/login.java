package com.tap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserDAO;
import com.food.DAOimplents.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserDAO user;
     @Override
    	public void init() throws ServletException {
    		user = new UserDAOImp();
    	}
     
     
     
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		
		User loggedin = user.getUser(email);
		
		if(loggedin.getPassword() != null && password.equals(loggedin.getPassword()))
				{
						
					HttpSession session =  request.getSession(true);
					session.setAttribute("user", loggedin);
					response.sendRedirect("home");
				}
		else
		{
			response.sendRedirect("Login.jsp");
		}
		
	}

}
