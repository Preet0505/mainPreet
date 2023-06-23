<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="com.Jsp_Project.Emp"%>
	<%@page import="com.Jsp_Project.EmpDao"%>


	<%
	String id = request.getParameter("id");
	%>


	<h1>Get Employee Info...</h1>

	<form action="fromupdate.jsp">
		<label>Enter Id</label><br> <input type="text" name="id" value=<%=id %> readonly><br>
		<label>Enter Name</label><br> <input type="text" name="fname"><br>

		<label>Enter Email</label><br> <input type="text" name="email"><br>

		<label>Enter Password</label><br> <input type="password"
			name="password"><br> <br>

		

					<input type="submit" name="UpdateUser">
					<br>
	</form>


</body>
</html>