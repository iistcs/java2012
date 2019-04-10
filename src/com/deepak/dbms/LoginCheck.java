package com.deepak.dbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Logincheck")
public class LoginCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out=response.getWriter();
	String user=request.getParameter("un");
	String pass=request.getParameter("ps");
	
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Register the driver
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql:3306/iistcs", "user", "password"); // Establish Connection
			Statement stmt = con.createStatement(); // create statement
			ResultSet rs = stmt.executeQuery("Select * from registration where UserName='"+user+"' and Password='"+pass+"'"); // execute statement
			if(rs.next()) {
				
				String Name=rs.getString("FName");
				HttpSession session= request.getSession();
				session.setAttribute("name", Name);
				rs.close();
				stmt.close();
				con.close();
				response.sendRedirect("Registration.jsp");
			}
			else
			{
				rs.close();
				stmt.close();
				con.close();
				HttpSession session= request.getSession();
				session.setAttribute("msg", "you have entered wrong user id password");
				response.sendRedirect("Login.jsp");
			}
		
		} catch (Exception e) {

			out.print(e);
		}
		
	}

}
