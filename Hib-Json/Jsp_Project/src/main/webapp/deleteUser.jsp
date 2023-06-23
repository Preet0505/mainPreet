<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="com.Jsp_Project.EmpDao"%>
<jsp:useBean id="u" class="com.Jsp_Project.Emp"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%@page import="java.util.*"%>


<%
String sid = request.getParameter("id");
int id1 = Integer.parseInt(sid);
EmpDao.deleteUser(id1);
response.sendRedirect("Index.jsp");
%>

</body>
</html>