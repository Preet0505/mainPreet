package String;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class Employee {

	int rollno;
	String addr;
	String name;

	// constructor
	Employee(int rollno, String addr, String name) {
		this.rollno = rollno;
		this.addr = addr;
		this.name = name;
	}
}

//creates the comparator for comparing rollno.
class ComparatorName implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if (o1.rollno == o2.rollno)
			return 0;
		else if (o1.rollno > o2.rollno)
			return 1;
		else
			return -1;
	}
}

class ComparableRollno implements Comparable<ComparableRollno> {

	int rollno;
	String addr;
	String name;

	// constructor
	ComparableRollno(int rollno, String addr, String name) {
		this.rollno = rollno;
		this.addr = addr;
		this.name = name;
	}

	@Override
	public int compareTo(ComparableRollno Em2) {
		if (rollno == Em2.rollno)
			return 0;
		else if (Em2.rollno > Em2.rollno)
			return 1;
		else
			return -1;
	}
}


public class Assignment2 {

	public static void main(String[] args) {
//Q1 : Write a program to sort HashMap by keys ?

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(15, "Preet");
		map.put(25, "Fenil");
		map.put(35, "Darsh");
		map.put(45, "Raj");
		map.put(55, "kevin");

		System.out.println(map);

		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

//Q2 : Write a program to sort ArrayList using Comparable and Comparator?
		System.out.println("---------------comparable--------------------");
		ArrayList<ComparableRollno> arr = new ArrayList<ComparableRollno>();
		arr.add(new ComparableRollno(55, "Vapi", "Preet"));
		arr.add(new ComparableRollno(75, "Valasd", "Sunny"));
		arr.add(new ComparableRollno(65, "Daman", "Funny"));
		arr.add(new ComparableRollno(15, "Diu", "max"));
		arr.add(new ComparableRollno(05, "Ahmedabad", "Vietnam"));

		Collections.sort(arr);// comparable
		for (ComparableRollno employee : arr) {
			System.out.println(employee.rollno + "," + employee.addr + "," + employee.name);
		}

		System.out.println("----------------comparator-------------------");
		ArrayList<Employee> arr2 = new ArrayList<Employee>();
		arr2.add(new Employee(55, "Vapi", "Preet"));
		arr2.add(new Employee(75, "Valasd", "Sunny"));
		arr2.add(new Employee(65, "Daman", "Funny"));
		arr2.add(new Employee(15, "Diu", "max"));
		arr2.add(new Employee(05, "Ahmedabad", "Vietnam"));

		Collections.sort(arr2, new ComparatorName());
		for (Employee employee2 : arr2) {
			System.out.println(employee2.rollno + "," + employee2.addr + "," + employee2.name );
		}
		
		
// Q3 : Write a program to add element at particular index of ArrayList?	
		System.out.println("------------------------------------------------");
		ArrayList<String> arr3 = new ArrayList<String>();
		arr3.add("Deep");
		arr3.add("Preet");
		arr3.add("Abhi");
		System.out.println(arr3);
		arr3.add(1, "Jaki");
		arr3.remove(0);
		System.out.println(arr3);
		
// Q4 : Write a program to sort HashMap by value? 
		System.out.println("------------------------------------------------");
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();

		map.put(15, "Preet");
		map.put(25, "Fenil");
		map.put(35, "Darsh");
		map.put(45, "Raj");
		map.put(55, "Kevin");

		System.out.println(map);

		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		
// Q5 : How to synchronize an ArrayList in java?
		
		System.out.println("------------------------------------------------");
		CopyOnWriteArrayList<String> syc = new CopyOnWriteArrayList<String>();
		syc.add("Ahmedabad");
		syc.add("Valsad");
		syc.add("Surat");
		syc.add("Navsari");
		
		Iterator<String> itr = syc.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
// Q6 : Write a program to convert LinkedList to ArrayList?
		System.out.println("------------------------------------------------");
		LinkedList<String> ls = new LinkedList<String>();
		ls.add("Ahmedabad");
		ls.add("Valsad");
		ls.add("Surat");
		ls.add("Navsari");
		
		ArrayList<String> aList = new ArrayList<String>(ls);
		for (String str : aList) {
			
			System.out.println(str);
		}
		
	}
}
