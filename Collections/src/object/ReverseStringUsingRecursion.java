package object;

public class ReverseStringUsingRecursion {
	
	private static String ReverseStringUsingRecursion(String str) {
		//if(str.isEmpty())
		if(str == null || str.length()<=1) {
			
			return str;
		}
		
		return ReverseStringUsingRecursion(str.substring(1))+str.charAt(0);
		


	}
	
	public static void main(String[] args) {
		
		String str = "abcdef";
		
	System.out.println(ReverseStringUsingRecursion(str));
		

	}
		
} 
