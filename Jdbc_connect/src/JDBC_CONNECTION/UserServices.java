package JDBC_CONNECTION;

public interface UserServices {

	//create user
	public void createUser(User user);
	
	//get user by id
	public void getUserById(int id);
	
	//get all user
	public void getAllUser();
	
	//delete user id
	public void deleteUserById(int id);
	
	//update user id
	public void updateUserById(int id);
	
}
