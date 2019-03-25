package com.deepak.dbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteCheck")
public class DeleteCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String user=request.getParameter("uname");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql:3306/iistcs", "user", "password"); // Establish Connection
			Statement stmt=con.createStatement();
			String query="Delete from registration where UserName='"+user+"'";
			int number=stmt.executeUpdate(query);
			HttpSession session=request.getSession();
			session.setAttribute("rows", number);
			stmt.close();
			con.close();
			response.sendRedirect("Update.jsp");
			
			
			
		}
		catch(Exception e)
		{
			out.print(e);
			
		}
	
	}

}
