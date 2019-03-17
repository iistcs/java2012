package com.deepak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logincheck
 */
@WebServlet("/getLogcheck")
public class Logincheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("un");
		String pass=request.getParameter("ps");
		
		if(uname.equals("iistcs") && pass.equals("12345"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
		request.setAttribute("user", uname);
		rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			request.setAttribute("data", "You have entered worng user id or password");
			rd.forward(request, response);
			
		}
		
	}

}
