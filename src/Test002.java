import java.util.concurrent.locks.ReentrantLock;


/*
	Synchronizujemy dostęp do zasobów za pomocą zamka.
 */
public class Test002 {
    public static int counter = 0;
    public static ReentrantLock lock = new ReentrantLock();

    public static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 2000000; ++i) {
                lock.lock();
                ++counter;
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ThreadA ta = new ThreadA();
        ThreadA tb = new ThreadA();
        ta.start();
        tb.start();

        try {
            ta.join();
            tb.join();
        } catch (Exception e) {
        }
        System.out.println(counter);
    }
}
