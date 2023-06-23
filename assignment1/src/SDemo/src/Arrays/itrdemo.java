package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class itrdemo {
	public static void main(String[] args) {
		List al = new ArrayList();
		al.add(10);
		al.add("deepak");
		al.add("Preet");
		System.out.println(al);
		
		ListIterator itr = al.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("----------------------------");
		
//		ListIterator li = al.listIterator();
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
		
		
	}
}
