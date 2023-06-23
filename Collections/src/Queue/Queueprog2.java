package Queue;

import java.util.PriorityQueue;

import CollectionFramework.Queue;

class Books implements Comparable<Book>{
	int id , quantity ;
	String name , author , publisher ;
	
	public Books(int id , String name , String author , String publisher , int quantity) {
	this.id = id;
	this.name = name;
	this.author = author;
	this.publisher = publisher;
	this.quantity = quantity;
	}
	
	public int compareto(Books b) {
		if(id>b.id) {
			return 1;
		}else if(id<b.id) {
			return-1;
		}else {
			return 0;
		}
	}

	@Override
	public int compareTo(Books o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}



public class Queueprog2 {

	public static void main(String[] args) {
		
		//Book b1 = new Book();
		
	    PriorityQueue<Books> queue=new PriorityQueue<Books>();

	    Books b1=new Books(121,"Let us C","Yashwant Kanetkar","BPB",8);
	    Books b2=new Books(120,"Operating System","Galvin","Wiley",6); 
	    Books b3=new Books(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    Books b4=new Books(155,"Data analyst","Vapi","Mc caffee",5);
	    
	    queue.add(b1);
	    queue.add(b2);
	    queue.add(b3);
	    queue.add(b4);
	    
	    for(Books b:queue){  
	        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	        }  
		
	    queue.remove();  
	    
	    System.out.println("After removing one book record:");  
	    for(Books b:queue){  
	        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	        }  
	    
	    
		
	}
}
