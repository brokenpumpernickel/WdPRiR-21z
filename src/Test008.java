import java.util.concurrent.locks.ReentrantLock;

/*
	Przerywanie pracy wątkom.
 */
public class Test008 {
    public static class MyThread extends Thread {
        public void run() {
            while (!isInterrupted()) {
                System.out.println("Kochamy programowanie rownolegle i naszego prowadzacgo! Jest da best!");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();

        Thread.sleep(4900);
        t.interrupt();

        t.join();
    }
}
