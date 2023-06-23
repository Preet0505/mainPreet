package com.httpServlet;

//import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

@WebServlet("/http")
public class EmpDao {
	  
	static Connection connection;
//	static Statement statement;

	public static Connection GetConnection() {
		
		try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database=Servlet;encrypt=false", "sa", "Preet@123");
			return connection;
		} catch (Exception e) {
			System.out.println("Connection not created");
		}
		return connection;
 
	}
	
public static int Save(Emp e) {
	int status = 0;

	try {
		connection = GetConnection();
		String url = "insert into httpServlet(fname,email,password) values (?,?,?)";
		PreparedStatement ps = connection.prepareStatement(url);
		
		ps.setString(1,e.getName());
		ps.setString(2,e.getEmail());
		ps.setString(3,e.getPassword());

		status = ps.executeUpdate();
	
		
	}catch(Exception ex) {ex.printStackTrace();}
	
	return status;
	
	}





public static List<Emp> getemployee() {
	
	List<Emp> list = new ArrayList<Emp>();
	
	try {
		connection = GetConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM httpServlet");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Emp e = new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setPassword(rs.getString(4));
			list.add(e);
		}
		
		connection.close();
	}catch(Exception ex) {ex.printStackTrace();}
	
	return list;
	
}

@SuppressWarnings("unused")
public static ResultSet getsingleUser(int id) {
	Emp e = new Emp();
	try {
		connection = GetConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM HttpServlet WHERE Id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		return rs;
		
	}catch(Exception ex) {ex.printStackTrace();}
	return null;
}

public static int delete(int id) {
	int status = 0;
	try {
		connection = GetConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM HttpServlet WHERE Id =? ");
		ps.setInt(1, id);
		status=ps.executeUpdate();
	}catch(Exception ex) {ex.printStackTrace();}
	return status;
}

public static int update(Emp e) {
	
	int status =0;
	try {
		connection = GetConnection();
		PreparedStatement ps = connection.prepareStatement("Update HttpServlet set name=?,email=?,password=? WHERE Id =? ");
		ps.setString(1,e.getName());  
		ps.setString(2,e.getEmail());
		ps.setString(3,e.getPassword());
		ps.setInt(4,e.getId());  
		
		status = ps.executeUpdate();
		connection.close();
		
	}catch (Exception ex) {ex.printStackTrace();}
	return status;
}

public static ResultSet Login(Emp e) {
//	Emp e = new Emp();
	try {
		connection=GetConnection();
		PreparedStatement ps = connection.prepareStatement("Select * FROM HttpServlet Where id=? and password=?");
		ps.setInt(1, e.getId());
		ps.setString(2,e.getPassword());
		ResultSet rs = ps.executeQuery();
//		System.out.println(rs);
		return rs;
		
	}catch (Exception ex) {ex.printStackTrace();}
	return null;
	
}
}
