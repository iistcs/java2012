package com.deepak.dbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regcheck")
public class RegistrationCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();	
	String FName=request.getParameter("fname");
	String User=request.getParameter("uname");
	String pass=request.getParameter("ps");
	try {
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iistcs","root","dkv@1234");
	Statement stmt=con.createStatement();
	String query="Insert into registration (UserName,Password,FName) values ('"+User+"','"+pass+"','"+FName+"')";
	stmt.executeUpdate(query);
	stmt.close();
	con.close();
	
	request.setAttribute("msg", "Record Successfully inserted");
	RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
	rd.forward(request, response);
	
	}
	catch(Exception e)
	{
		
		out.print(e);
	}
	
	}

}
