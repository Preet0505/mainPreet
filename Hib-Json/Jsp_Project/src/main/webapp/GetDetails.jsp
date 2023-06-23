<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Jsp_Project.Emp"%>
<%@page import="com.Jsp_Project.EmpDao"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>User_List</h1>

	<table border='1' width='50%'>
	<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th></tr>
	
	<%
	String sid = request.getParameter("id");
	int id1 = Integer.parseInt(sid);
	ResultSet list = EmpDao.GetDetails(id1);
	while(list.next()){
		list.getInt(1);
		list.getString(2);
		list.getString(3);
		list.getString(4);
		list.getString(5);
		
	}
	
	%>
	<a href = "Index.jsp">Home Page</a>
	
</body>
</html>