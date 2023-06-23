package object;

public class TestStudent4 {
	
	int rollno ; 
	String name;
	float salary;

//using these method for initializing.
	public void insertRecord(int r,String n,float s) {
		rollno=r;
		name=n;
		salary=s;
	}
//using these method for displaying.
	public void displayInformation() {
		System.out.println(rollno+" "+name+" "+salary);
	}
	
class Methodlni{
	
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		s1.insertRecord(111,"Karan",450000);  
		s2.insertRecord(222,"Aryan",56777);  
		s1.displayInformation();  
		s2.displayInformation();  
		
		
		
	}
	
	
}

}
