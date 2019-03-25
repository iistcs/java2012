<%@page import="java.util.Iterator"%>
<%@page import="com.deepak.dbms.Atrribute"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Registration Form</title>
</head>
<body>
<h1>Welcome to Registration Page</h1><br>
<%
String name=(String)session.getAttribute("name");
out.print("<h1>"+"Welcome back:"+name+"</h1>");
%>

<form action="regcheck" action="get">
<fieldset>
<legend>Enter Student Details</legend>
<table border="1px">
<tr><th>Details</th><th>Value</th></tr>
<tr><td>Full Name:</td><td><input type="text" placeholder="Full Name" name="fname"></td></tr>
<tr><td>User Name:</td><td><input type="text" placeholder="User Name" name="uname"></td></tr>
<tr><td>Password:</td><td><input type="text" placeholder="Password" name="ps"></td></tr>
<tr  ><td ><input type="submit" value="Registered"></td></tr>

</table>
<div style="text-align: center">

<%
String msg=(String)request.getAttribute("msg");
out.print(msg);
%>
</div>
</fieldset>
<br>

</form>
<form action="alldatacheck" method="get">
<input type="submit" value="Show All data">

</form>
<br>
<form action="Update.jsp" method="get">
<input type="submit" value="Update the record">

</form>


<table id="table" border="1">
    <tr>
        <th>Full Name</th>
        <th>User Name</th>
        <th>Password</th>
       </tr>

<%
try
{
ArrayList<Atrribute> List=(ArrayList)request.getAttribute("data");
Iterator itr=List.iterator();

while(itr.hasNext())
{
	Atrribute a=(Atrribute)itr.next();
	

	
	%>
	 <tr>
        <td><%=a.FullName%></td>
         <td><%=a.UserName%></td>   
        <td><%=a.Password%></td>
           
    </tr>
   
	
	<%
}}
catch(Exception e)
{
out.print(e);	
}

%>
</table>
</body>
</html>