package com.Jsp_Project;

public class Emp {
	private int Id;
	private String Name, email, password, Country;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

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

	public Emp(int id, String name, String email, String password, String country) {
		super();
		Id = id;
		Name = name;
		this.email = email;
		this.password = password;
		Country = country;
	}

	public Emp() {
	}

}
