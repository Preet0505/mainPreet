package object;

class A extends Thread {
	
	public void run() {
		for (int i=0 ; i<=100 ; i++) {
			System.out.println("hi");
//			try {
//				//Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
}

class B extends Thread{
	
	public void run() {
		for (int i=0 ; i<=100 ; i++) {
			System.out.println("hello");
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
}



public class multithreading {
	public static void main(String[] args) throws InterruptedException {
		A obj1 = new A();
		B obj2 = new B();
		int count = 0;
		do {
			obj1.start();
			obj1.join(1);
			obj2.start();
			count++;
			
		} while (true);
		
		
		
		
		
//		obj1.start();
//		try {
//			Thread.sleep(4);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		obj2.start();
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
