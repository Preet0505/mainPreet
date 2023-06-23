package Facade_Crud;

import java.util.Scanner;

public class Facade {

	private static int choice;

	public static void main(String[] args) {
		runAgain();
	}
	public static void runAgain() {
		

		System.out.println("====================================");

		System.out.println("1 Iphone");
		System.out.println("2 Samsung");
		System.out.println("3 Vivo");
		System.out.println("4 Exit");

		System.out.println("Enter your choice ");

		try (Scanner sc = new Scanner(System.in)) {
			int choice = sc.nextInt();

			ShopKeeper sk = new ShopKeeper();

			switch (choice) {
			case 1:

				sk.iphoneSale();
				break;
			case 2: {
				sk.samsungSale();
			}
				break;
			case 3: {
				sk.vivoSale();
			}
				break;
			default: {
				System.out.println("Not Purchased");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
