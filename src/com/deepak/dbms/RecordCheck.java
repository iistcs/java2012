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

@WebServlet("/RecordCheck")
public class RecordCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String user=request.getParameter("un");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iistcs","root","dkv@1234");
		Statement stmt=con.createStatement();
		String query="Select * from registration Where UserName='"+user+"'";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			HttpSession session=request.getSession();
			session.setAttribute("User", rs.getString(2));
			session.setAttribute("Pass", rs.getString(3));
			session.setAttribute("Fname", rs.getString(4));
		}
		
		rs.close();
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
