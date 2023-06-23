<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.curd.Emp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>

<form action="UserServlet?work=update" method="post">
	<table border='1' width='50%'>
		<tr>
			<th>Id</th>
			<th>name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<%
		Emp emp = (Emp) request.getAttribute("idDetails"); 
		
		%>
		<tr>
		<td><input type="text" name="id" value="<%= emp.getId() %>" readonly></td>
		<td><input type="text" name="fname" value="<%= emp.getName() %>"></td>
		<td><input type="text" name="email" value="<%= emp.getEmail() %>"></td>
		<td><input type="text" name="password" value="<%= emp.getPassword() %>"></td>
		<td><input type="submit" value="update"></td>
		</tr>
		</table>
</form>
</body>
</html>