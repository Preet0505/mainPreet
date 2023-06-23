package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HMap {
	
	public static void main(String[] args) {
		
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		
//		hm.putIfAbsent(3, "Preet");
		
		System.out.println(hm);
		
		for(Map.Entry<Integer, String> e : hm.entrySet()) {
			System.out.println(e);
			
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		
		
	}
}
