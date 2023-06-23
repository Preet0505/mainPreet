<%@page import="com.curd.Emp"%>
<%@page import="com.curd.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Record</title>
</head>
<body>
	<a href="Index.jsp">Home Page</a>
	
	<%
		Emp emp = (Emp) request.getAttribute("idDetails"); 
		
		%>
		<table border='1' width='50%'>
	<tr>
			<th>Id</th>
			<th>name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		
		<tr>
		<td><%= emp.getId() %></td>
		<td><%= emp.getName() %></td>
		<td><%= emp.getEmail() %></td>
		<td><%= emp.getPassword() %></td>
		</tr>
		</table>
</body>
</html>