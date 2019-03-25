package com.deepak.dbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Updatecheck")
public class Updatecheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	String fname=request.getParameter("fn");
	String Pass=request.getParameter("ps");
	String user=request.getParameter("uname");
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iistcs","root","dkv@1234");
		Statement stmt=con.createStatement();
		String Query="Update registration SET Fname='"+fname+"', Password='"+Pass+"' Where UserName='"+user+"' ";
		int number=stmt.executeUpdate(Query);
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
