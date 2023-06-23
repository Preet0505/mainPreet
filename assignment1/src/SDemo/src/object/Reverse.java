package object;

public class Reverse {
	
	long number = 98765;
	int reverse = 0;
	
	
	  void rev(int number , int reverse) {
		while(number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number /10 ;
		}
		System.out.println(reverse);
	}
	
	public static void main(String[] args) {
		int number = 98765, reverse = 0;
		Reverse r1 = new Reverse();
		//int rev = 
		r1.rev(number,reverse);
		//System.out.println(rev);
		
	}
	

}
