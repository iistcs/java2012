package com.deepak.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addcheck
 */
public class addcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addcheck() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("val1"));
		int b=Integer.parseInt(request.getParameter("val2"));
		
		int c=a+b;
		String d=String.valueOf(c);

		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		request.setAttribute("data", d);
		rd.forward(request, response);
		
	}
	

}
