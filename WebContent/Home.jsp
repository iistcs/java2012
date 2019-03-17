<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: aqua;">
<div style="text-align: center;">
<h1>
<%
String name=(String)request.getAttribute("user");
out.print("Hello:"+ name);
%>
</h1>
<br>
<hr/>
Located in a plush 50 acre campus opposite IIM Indore, Indore Institute of Science & Technology (IIST) is amongst the Top 10 Engineering Colleges of Madhya Pradesh (MP) and amongst the best engineering colleges of Indore. Set up in 2003 under the Shail Education and Welfare Society, IIST has quickly ascended to this position by ensuring a high focus on quality education and effective as well as holistic development that further translates into high placements.

With the vision of providing the best technical education, IIST started with a humble number of disciplines but soon expanded to include a wide range of courses in Mechanical, Electronics & Communication, Computer Science, Information Technology, Civil and Chemical Engineering. It also runs post graduate courses in Mechanical, CS and EC. The institute also offers Masters Degree in Business Administration to meet the growing requirements of management professionals.
</div>
<h1 style="text-align: center;">
<a href="index.jsp">Logout</a></h1>
</body>
</html>