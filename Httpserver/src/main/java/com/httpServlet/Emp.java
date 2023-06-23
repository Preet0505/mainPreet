package com.httpServlet;

public class Emp {
	
	private String Name , email , password;
	private int Id;

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String toString() {
		return "Emp[Name= "+Name+",Email=" +email+",Password= "+password+"]";
	}
	
}
