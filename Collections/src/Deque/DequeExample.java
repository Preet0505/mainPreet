package Deque;
import java.util.*;  
public class DequeExample {  
public static void main(String[] args) {  
    Deque<Integer> deque=new ArrayDeque<Integer>();  
    deque.offer(1);  
    
    Integer element = deque.element();
    System.out.println(element);
    deque.add(3); 
    boolean offerLast = deque.offerLast(2);
    System.out.println(offerLast);
    deque.offerFirst(4); 
    System.out.println("After offerFirst Traversal...");  
    for(Integer s:deque){  
        System.out.println(s);  
    }  
    //deque.poll();  
    //deque.pollFirst();//it is same as poll()  
    deque.pollLast();  
//    deque.clear();
    Integer peek = deque.peek();
    System.out.println(peek);
    System.out.println("After pollLast() Traversal...");  
    for(Integer s:deque){  
        System.out.println(s);  
    }  
}  
}  