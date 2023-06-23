<%@page import="com.Jsp_Project.EmpDao"%>
<%@page import="com.Jsp_Project.Emp"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Add Or User_Details</title>
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
			<th>name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Country</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		Emp empl = new Emp();

		List<Emp> list = EmpDao.getemployee(empl);
		for (Emp e : list) {
			out.print("<tr><th><a href = GetDetails.jsp?id=" + e.getId() + ">" + e.getId()
			+ "</a></th><th><a href = GetDetails.jsp?fname" + e.getName() + ">" + e.getName() + "</th><th>"
			+ e.getEmail() + "</th><th>" + e.getPassword() + "</th><th>" + e.getCountry()
			+ "</th><th><a href = deleteUser.jsp?id=" + e.getId() + ">Delete</a></th><th><a href = UpdateUser.jsp?id="
			+ e.getId() + " >Update</a></th></tr>");
		}
		%>
	</table>



</body>
</html>