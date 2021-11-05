import java.util.concurrent.locks.ReentrantLock;

/*
	Przykład deadlocka.
 */
public class Test003 {
    public static int numberA = 0;
    public static ReentrantLock lockA = new ReentrantLock();
    public static int numberB = 0;
    public static ReentrantLock lockB = new ReentrantLock();

    public static class MyThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                lockA.lock();
                lockB.lock();
                numberA += 1;
                numberB += numberA;
                lockB.unlock();
                lockA.unlock();
                System.out.println(numberA + " " + numberB);
            }
        }
    }

    public static class MyThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                lockB.lock();
                lockA.lock();
                numberA += 1;
                numberB += numberA;
                lockA.unlock();
                lockB.unlock();
                System.out.println(numberA + " " + numberB);
            }
        }
    }

    public static void main(String[] args) {
        MyThreadA ta = new MyThreadA();
        ta.start();
        MyThreadB tb = new MyThreadB();
        tb.start();
        try {
            ta.join();
            tb.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
