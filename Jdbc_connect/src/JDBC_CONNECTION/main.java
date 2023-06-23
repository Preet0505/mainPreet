package JDBC_CONNECTION;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
		try {
			Connection Getconnection = ConnectionToDb.GetConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserServices users = new UserServiceImple();
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Create User \n2. Get user by id \n3. Get all user \n4.Update user ");
		int ch = scan.nextInt();
		switch(ch) {
		case 1:
			User u1 = new User();
			int id=u1.getId();
			String name=u1.getName();
			String address=u1.getAddress();
			users.createUser(u1);
			
			break;
		}
	}

}
