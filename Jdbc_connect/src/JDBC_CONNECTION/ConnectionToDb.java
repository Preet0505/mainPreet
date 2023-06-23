package JDBC_CONNECTION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {
	
	static  Connection con;
	public static Connection GetConnection() throws SQLException { 
	String url = "jdbc:sqlserver://;localhost=1433;DatabaseName=Company;encrypt=false";
	String username = "sa";
	String password = "Preet@123";
	
	con = DriverManager.getConnection(url,username, password);
	return con;
	}
}
