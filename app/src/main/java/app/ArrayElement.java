package app;

import java.util.ArrayList;

public class ArrayElement {
	public static void main(String[] args)   {
	
	ArrayList<Integer> list1=new ArrayList<Integer>();  
	list1.add(6);    
	list1.add(1);    
	list1.add(22);  
	list1.add(25);
	list1.add(6);
	list1.add(6);
	list1.add(-1);
	list1.add(8);
	list1.add(10);
	
	
    System.out.println(list1);
     
    ArrayList<Integer> list2=new ArrayList<Integer>();
    list2.add(1);    
 	list2.add(6);    
 	list2.add(-1);  
 	list2.add(10);
     
 	System.out.println(list2);
 	 	Object[] array1 = list1.toArray();
 	Object[] array2 = list2.toArray();
 	int i = 0;
 	int j = 0;
 	
 	// array1=(6,1,22,25,);
 	while(i<array1.length && j< array2.length) {
 		
 		if(array1[i]==array2[j]) {
 			j++;
 		}
 		i++;
 	}
 	if(j== array2.length) {
 		System.out.println("true");
 		System.out.println(j);
 	}else {
 		System.out.println("false");
 	}

	}
 		
 		
 	}
