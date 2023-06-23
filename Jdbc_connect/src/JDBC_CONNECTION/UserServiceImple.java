package JDBC_CONNECTION;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserServiceImple implements UserServices {
	
	Scanner sc = new Scanner(System.in);
	

	@Override
	public void createUser(User user)  {
		// TODO Auto-generated method stub
		PreparedStatement st1;
		try {
		st1=ConnectionToDb.con.prepareStatement("INSERT INTO Employee VALUES(?,?,?)");
		System.out.println("Enter Usre ID:");
		st1.setInt(1, sc.nextInt());
		System.out.println("Enter Usre Name:");
		st1.setString(2, sc.next());
		System.out.println("Enter Usre Address:");
		st1.setString(3, sc.next());
		
		st1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void getUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
