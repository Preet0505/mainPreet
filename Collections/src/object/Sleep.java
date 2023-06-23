package object;

public class Sleep extends Thread {
	
	public void run() {
		for (int i=0 ; i<5 ; i++) {
			try {
				Thread.sleep(5000,2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
	
	public static void main(String[] args) {
		Sleep t1 = new Sleep();
		Sleep t2 = new Sleep();
		
		t1.start();
		t2.start();
		
		
	}
}
