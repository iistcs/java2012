package com.deepak.dbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/alldatacheck")
public class Alldatacheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			ArrayList<Atrribute> List=new ArrayList<Atrribute>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql:3306/iistcs", "user", "password"); // Establish Connection
			Statement stmt=con.createStatement();
			String query="Select * from registration";
			ResultSet rs=stmt.executeQuery(query);
			out.print("<table border='2px'>");
			while(rs.next())
			{ 
				
				Atrribute atr=new Atrribute();
				atr.FullName=rs.getString(2);
				atr.UserName=rs.getString(3);
				atr.Password=rs.getString(4);
				/*
				 * out.print("<tr>"); out.print("<td>"+rs.getString(1)+"</td>");
				 * out.print("<td>"+rs.getString(2)+"</td>");
				 * out.print("<td>"+rs.getString(3)+"</td>");
				 * out.print("<td>"+rs.getString(4)+"</td>"); out.print("</tr>");
				 */
				List.add(atr);
			}
			
			//out.print("</table>");
			request.setAttribute("data", List);
			rs.close();
			stmt.close();
			con.close();
			RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			out.print(e);

		}
	}

}
