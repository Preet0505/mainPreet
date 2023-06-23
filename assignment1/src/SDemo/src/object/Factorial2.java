package object;

import java.util.Scanner;

public class Factorial2 {
	int fact = 1;
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	
	Factorial2 fact() {
	
	
	
	for(int i=1;i<=n;i++) {
		fact = fact*i;
	}
	
	System.out.println(fact);
	return null;
	}
	public static void main(String[] args) {
		Factorial2 f1 = new Factorial2().fact();;
	}
}


