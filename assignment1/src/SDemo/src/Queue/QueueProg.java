package Queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class QueueProg {
	
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("Anuj");
		pq.add("Anju");
		pq.add("Preet");
		pq.add("Purav");
		pq.add("Harsh");
		pq.add("Priyansh");
		
		Iterator itr = pq.iterator();
		while(itr.hasNext()) {
		System.out.println(itr.next());
		}
		
		System.out.println("---------------------------------------");
		System.out.println(pq.remove());
		System.out.println("---------------------------------------");
		
		Iterator itr2 = pq.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
			}
		
		
		
		
		
	}

}
