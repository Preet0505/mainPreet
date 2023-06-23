package PracticeProgram;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;  
public class Sequence {  
	public static void main(String[] args)   {
	
		int temp = 0;
		
//	Integer[] array1 = {5,1,22,25,6,-1,8,10};
//	List<Integer> list1=Arrays.asList(array1);
//	
//	Integer[] array2 = {1,6,-1,10};
//	List<Integer> list2=Arrays.asList(array2);
	
	ArrayList<Integer> list1=new ArrayList<Integer>();  
	list1.add(5);    
	list1.add(-1);    
	list1.add(22);  
	list1.add(25);
	list1.add(10);
	list1.add(1);
	list1.add(8);
	list1.add(6);
	
    System.out.println(list1);
     
    ArrayList<Integer> list2=new ArrayList<Integer>();
    list2.add(1);    
 	list2.add(6);    
 	list2.add(-1);  
 	list2.add(10);
     
 	System.out.println(list2);
 	
 	list1.retainAll(list2);
 	
 	System.out.println("Retain the list2");
 	System.out.println(list2);
 	System.out.println("Retain the list1");
 	System.out.println(list1);
 	
 	
// 	System.out.println(list1.size());
 	
 	if(list1.size() == list2.size()) {
 	for(int i=0;i<=list1.size();i++) {
 		for(int j=1;j<=list2.size();j++) {
 			if(i==j) {
// 				System.out.println("In sequence");
 				temp = temp+1;
 			}

 			
 		}
 		
 		
 	}
 	}
 	if(temp>0) {
 		System.out.println("In Sequence");
 	}else {
 		System.out.println("Not in sequence");
 	}
     
	}
}