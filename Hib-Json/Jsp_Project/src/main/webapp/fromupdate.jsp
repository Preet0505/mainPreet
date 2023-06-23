<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.Jsp_Project.Emp"%>
<%@page import="com.Jsp_Project.EmpDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String userId = request.getParameter("id");
	int id = Integer.parseInt(userId);
	String name = request.getParameter("fname");
	String Email = request.getParameter("email");
	String Password = request.getParameter("password");
	//String Country = request.getParameter("country");

	Emp e = new Emp();
	e.setId(id);
	e.setName(name);
	e.setEmail(Email);
	e.setPassword(Password);
	//e.setCountry(Country);

	System.out.println(name);
	System.out.println(Email);
	System.out.println(Password);

	int Status = EmpDao.UpdateUser(e);

	if (Status > 0) {
		out.println("<p>Record Saved Successfully!</p>");
	} else {
		out.println("<br>Sorry Unable to save record.</br>");
	}
	
	
	response.sendRedirect("Index.jsp");
	%>
</body>
</html>