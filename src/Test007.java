import java.util.concurrent.locks.ReentrantLock;

/*
	Przerywanie pracy wątkom -- wersja gorsza.
 */
public class Test007 {
	public static class MyThread extends Thread {
		private volatile boolean shouldRun = true;
		public void run() {
			while(shouldRun) {
				System.out.println("Kochamy programowanie rownolegle i naszego prowadzacgo! Jest da best!");
			}
		}
		
		public void stopMeNow() {
			System.out.println("Don't stop me now!");
			shouldRun = false;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		t.start();
		
		Thread.sleep(5000);
		t.stopMeNow();
		
		t.join();
	}
}
