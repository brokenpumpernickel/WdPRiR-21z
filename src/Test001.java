/*
	Witaj, okrutny świecie!
 */
public class Test001 {
    public static class ThreadA extends Thread {
        @Override
        public void run() {
            System.out.println("Hello mulithreaded world! " + getId());
        }
    }

    public static class ThreadB implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello mulithreaded world! " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        ThreadA ta = new ThreadA();
        ta.start();

        Thread tb = new Thread(new ThreadB());
        tb.start();

        Thread tc = new Thread(() -> {
            System.out.println("Hello mulithreaded world! " + Thread.currentThread().getId());
        });
        tc.start();

        try {
            ta.join();
            tb.join();
            tc.join();
        } catch (InterruptedException e) {
        }
        System.out.println("Hello from main! " + Thread.currentThread().getId());
    }
}
