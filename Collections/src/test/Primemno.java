package test;

import java.util.Scanner;

public class Primemno{
	public static void main(String[] args){
//	Scanner sc = new Scanner(System.in);
//	int no = sc.nextInt();
	int no = 20;
	int count;
	for(int i=1 ; i<=no ; i++){
	count = 0;
	for(int j=2 ; j <= i/2 ; j++){
	if(i%j==0){
	count ++;
	break;
			
		}
	}
	if(count == 0){
	System.out.println(i);
		}

  	 }
     }
}