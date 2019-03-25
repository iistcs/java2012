<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update the Record</title>
</head>
<body>
<div style="text-align: center" >
<h1>Update the record</h1>
<fieldset>
<legend>Insert Student Record</legend>
<form action="RecordCheck" method="get">
Enter User Name: <input type="text" name="un" placeholder="User Name" required>

<input type="submit" value="Insert Record">
</form>
</fieldset>
<br>

<fieldset>
<legend>Update Student Record</legend>

<%
String name="No data";
String user="No data";
String pass="No data";
if(session.getAttribute("User")!="")
{
	%>

<form action="Updatecheck" method="get">
Full Name: <input type="text" name="fn" value='<%=session.getAttribute("Fname")%>' required>
User Name: <input type="text" name="uname" value='<%=session.getAttribute("User")%>' required readonly>
Password: <input type="text" name="ps" value='<%=session.getAttribute("Pass")%>' required>

<input type="submit" value="Update Record" ></form>

<br>
<hr>
<br>
<form action="DeleteCheck" method="get">
Full Name: <input type="text" name="fn" value='<%=session.getAttribute("Fname")%>' required>
User Name: <input type="text" name="uname" value='<%=session.getAttribute("User")%>' required readonly>
Password: <input type="text" name="ps" value='<%=session.getAttribute("Pass")%>' required>

<input type="submit" value="Delete Record">
</form>

<br><hr><br>
Status: <label><%=session.getAttribute("rows")%></label>
<%

session.invalidate();
}
%>

<br>
<hr>
<br>
<form action="alldatacheck" method="get">

<input type="submit" value="All Data">
</form>
</fieldset>


</div>

</body>
</html>