<html>
<body>
<h2>Hello World!</h2>

<form action="getadd" method="get">
First Value:<br><input type="text" name="val1" placeholder="first Value"><br>
Second Value:<br><input type="text" name="val2" placeholder="Second Value"><br>

<input type="submit" value="Add">

<%

	
	String x=(String)request.getAttribute("data");
if(x !=null)
	out.print("<br/>"+"Addition="+x);


%>
</form>

</body>
</html>
