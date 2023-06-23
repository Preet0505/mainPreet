<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.curd.Emp"%>
<%@ page import="com.curd.EmpDao"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Add_New User and User_List</h1>
	<a href="AddNewUser.jsp">Add New User</a>
	<br>
	<br>

	<h1>User_List</h1>

	<table border='1' width='50%'>


		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<%
		
		List<Emp> list = EmpDao.getemployee();

		for (Emp e : list) {
			out.println("<tr><th><a href = UserServlet?name=getid&id=" + e.getId() + ">" +e.getId()+ "</a></th><th>" 
								   + e.getName() + "</th><th>" 
								   + e.getEmail() + "</th><th>"
								   + e.getPassword() + "</th><th><a href = UserServlet?name=update&id=" 
								   + e.getId() + ">Update</a></th><th><a href = UserServlet?name=delete&id=" 
								   + e.getId() + ">Delete</a></th></tr>");
		}
		%>
	</table>
</body>
</html>