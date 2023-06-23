package JDBC_CONNECTION;

public class User {
	
	private int id;
	private String Address,name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Address=" + Address + ", name=" + name + ", getId()=" + getId() + ", getAddress()="
				+ getAddress() + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}