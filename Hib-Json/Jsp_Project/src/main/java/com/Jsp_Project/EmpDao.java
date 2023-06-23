package com.Jsp_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


//import com.httpServlet.Emp;

public class EmpDao {
	
	static Connection conn;
	
	public static Connection GetConnection() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database=Jsp;encrypt=false", "sa", "Preet@123");
			return conn;
			
			
		}catch (Exception ex) {
			System.out.println("Connection not Created");
		}
		
		return conn;
		
	}
	
	public static int AddNewUser(Emp e) {
		int status = 0;
		
		try {
			conn = GetConnection();
			String url = "INSERT INTO Jsp values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(url);
			
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3,e.getPassword());
			ps.setString(4,e.getCountry());
			
			status = ps.executeUpdate();
			
			conn.close();
		}catch(Exception ex) {
			
		}
		
		return status;
	}
	
	public static List<Emp> getemployee(Emp empl) {
		
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			conn = GetConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Jsp");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				e.setCountry(rs.getString(5) );
				list.add(e);
			}
			
			conn.close();
		}catch(Exception ex) {
			}
		
		return list;
		
	}
	
	public static int deleteUser(int id) {
		int status = 0;
		try {
			conn = GetConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Jsp WHERE Id =? ");
			ps.setInt(1, id);
			status=ps.executeUpdate();
		}catch(Exception ex) {ex.printStackTrace();}
		return status;
	}
	
	public static int UpdateUser(Emp e) {
		int status = 0;
		try {
			conn=GetConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE Jsp set fname=?, email=?, password=?  where id=?");
			 ps.setString(1,e.getName()); 
			 ps.setString(2,e.getEmail());  
		     ps.setString(3,e.getPassword()); 
		     //ps.setString(5,e.getCountry());  
		     ps.setInt(4,e.getId());  
			status=ps.executeUpdate();
		}catch(Exception ex) {
			System.out.println("dckn");
			ex.printStackTrace();}
		return status;
	}
	
	public static ResultSet GetDetails(int id) {
		new Emp();
		try {
			conn = GetConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Jsp WHERE Id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			return rs;
			
		}catch(Exception ex) {ex.printStackTrace();}
		return null;
	}

	
}
