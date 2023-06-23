package object;
 class MainClass extends Thread {
	 
	 public void run() {
		// do {
			 for (int i = 0; i < 5; i++) {
				 String name = Thread.currentThread().getName();
					System.out.println(Thread.currentThread().getName());
					System.out.println(name.equalsIgnoreCase(name));
			}
		//} while ()
	// }
	 
 }}
public class ThreadWhile{

	
	public static void main(String[] args) {
		
		MainClass main= new MainClass();
		
		Thread thread1 = new Thread(main);
		Thread thread2 = new Thread(main);
		
		thread1.setName("hello");
		thread2.setName("hi");
		
		thread1.start();
		thread2.start();
	}
}
