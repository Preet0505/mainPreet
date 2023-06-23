package Linked_list;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterator_ll {
	public static void main(String[] args) {
		LinkedList<String> ll=new LinkedList<String>();  
		
		 ll.add("Ravi");  
         ll.add("Vijay");  
         ll.add("Ajay");  
         
         Iterator il = ll.descendingIterator();
         
         while(il.hasNext()) {
        	 System.out.println(il.next());
         }
		
		
		
	}

}
