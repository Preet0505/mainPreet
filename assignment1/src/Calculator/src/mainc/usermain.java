package mainc;

import java.util.Scanner;

public class usermain implements sub, multi, div, Remider {
	
	public static void main(String[] args) {
		usermain us = new usermain();
		add a=new add();
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter the two number : ");
		int x = sc.nextInt();


		String choose = sc.next();
	

		int y = sc.nextInt();

		if(choose.contains("+")) {//Method calling statements
			System.out.println(((add) a).add(x, y));
		}else if(choose.contains("-")) {
			System.out.println(us.sub(x,y));
		}
		
		
	}

	
}
