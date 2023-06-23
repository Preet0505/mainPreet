<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign_UP</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
<h1>Get Employee Info...</h1>

	<form action="UserServlet?work=create" method=post>

		<label>Enter Name</label><br> <input type="text" name="fname"><br>

		<label>Enter Email</label><br> <input type="text" name="email"><br>

		<label>Enter Password</label><br> <input type="password"
			name="password"><br> <br>


					<input type="submit" name="AddNewUser">
					<br>
					<br>
	</form>

</body>
</html>