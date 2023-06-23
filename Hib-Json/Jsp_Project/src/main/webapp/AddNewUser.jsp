<%@page import="com.Jsp_Project.Emp"%>
<%@page import="com.Jsp_Project.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Get Employee Info...</h1>

	<form action="add.jsp" method=post>

		<label>Enter Name</label><br> <input type="text" name="fname"><br>

		<label>Enter Email</label><br> <input type="text" name="email"><br>

		<label>Enter Password</label><br> <input type="password"
			name="password"><br> <br>

		<tr>
			<td>Country:</td>
			<td><select name="country" style="width: 155px">
					<option>India</option>
					<option>Pakistan</option>
					<option>Afghanistan</option>
					<option>Berma</option>
					<option>Other</option><br>

					<input type="submit" name="AddNewUser">
					<br>
					<br>
	</form>
	


	
</body>
</html>