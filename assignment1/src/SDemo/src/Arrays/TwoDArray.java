package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArray {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int[][] arr = new int[3][5];
		
		System.out.println(arr.length);
		// input
		for (int row = 0 ; row < arr.length ; row++) {
			for (int col = 0 ; col < arr[row].length ; col++) {
				arr[row][col] = sc.nextInt();
			}
		}
		
		
		//output
		for (int row = 0 ; row < arr.length ; row++) {

			
			
			//			for (int col = 0 ; col < arr[row].length ; col++) {
//				System.out.print(arr[row][col] + " ");
//			}
//			System.out.println();
		
		
			System.out.println(Arrays.toString(arr[row]));
			
		
		
		}
	
	}
	

}
