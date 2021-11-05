import java.util.concurrent.locks.ReentrantLock;

/*
	Synchronizacja bloków.
 */
public class Test006 {
    public static class Counter {
        private int counter = 0;

        public void increment() {
            //...
            synchronized (this) {
                ++counter;
            }
            //...
        }

        public int get() {
            //....
            synchronized (this) {
                return counter;
            }
            //....
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.get();

    }
}
