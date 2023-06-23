package Linked_list;

import java.util.LinkedList;

public class Linkedlist {
	public static void main(String[] args) {
		 LinkedList<String> ll=new LinkedList<String>();  
         ll.add("Ajay");  
         ll.add("Anuj"); 
         ll.add("Ravi");  
         ll.add("Vijay");   
         ll.add("Gaurav");  
         ll.add("Harsh");  
         ll.add("Virat");  
         ll.add("Gaurav");  
         ll.add("Harsh");  
         ll.add("Amit");  
         System.out.println("Initial list of elements: "+ll);  
//         ll.removeFirst();  
//         System.out.println("After invoking removeFirst() method: "+ll);  
         ll.removeFirstOccurrence("Gaurav");  
         System.out.println("After invoking removeFirstOccurrence() method: "+ll);  
	
	}

}
