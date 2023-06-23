package CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;

public class List {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		//adding element in list.
		list.add("Preet");
		list.add("Purav");
		list.add("Harsh");
		list.add("Dev");
		list.add("Priyansh");
		list.add("Kana");
		
		Iterator itr = list.iterator();

		
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
//		if(itr.hasNext()) {
//			System.out.println("True");
//		}
//		else {
//			System.out.println("False");
//		}
	}

}
