package Set;


import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//import CollectionFramework.Set;



public class Treeset {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();   
		treeSet.add("Ravi");  
		treeSet.add("Vijay");  
		treeSet.add("Ravi");  
		treeSet.add("Ajay"); 
		treeSet.add("Preet"); 
		treeSet.add("welhjle"); 
		treeSet.add("klwkle"); 
		
		Set<String> synset = Collections.synchronizedSet(treeSet);  
		
//		  TreeSet<String> syncrSet=new TreeSet<String>(); 
		
		System.out.println(synset);
		
		
		Iterator<String> itr=synset.iterator();  
		  while(itr.hasNext()){  
		System.out.println(itr.next());
		  }
	}

}
