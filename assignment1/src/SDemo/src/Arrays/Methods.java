package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
class Student {
	int rollno;
	String name;
	long fee;
	
	Student(int rollno , String name , long fee){
		this.rollno = rollno;
		this.name = name;
		this.fee = fee;
		
//		System.out.println(rollno + " " +name+ " " +fee);
	}
}





//void display() {
//	
//	System.out.println(rollno + " " +name+ " " +fee);
//}
//}

public class Methods {
	
	
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		Student s1 = new Student(55,"Preet",50000);
		Student s2 = new Student(66,"Heet",70000);
		
		al.add(s1);
		al.add(s2);
		
		System.out.println("lets see");
		Iterator iterator = al.iterator();
		while (iterator.hasNext()) {
			
			Student next1 =(Student)iterator.next();
			System.out.println(next1.rollno + "," +next1.name + "," +next1.fee);
		}
		
		System.out.println(al);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.rollno+s1.name+s1.fee);
		al.clear();
		
	//	al.ensureCapacity(5);
		al.add(100);
		al.add(0, 200);
		al.add(300);
		al.add("Deepti");
		al.add("Dhadgf");
		al.add("peed");
		al.remove("100");
//		System.out.println();
		System.out.println(al);
		//al.ensureCapacity(5);
		System.out.println(al.get(0));
		
		ArrayList<String> fall = new ArrayList<String>();
		fall.add("Dev");
		fall.add("Kana");
		al.addAll(0,fall);
		//al.clear();
		System.out.println(al);
		System.out.println(al.size());
		
	}
	

}
