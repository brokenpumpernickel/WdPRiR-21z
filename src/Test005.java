/*
	Synchronizacja całych metod.
 */
public class Test005 {
    public static class Counter {
        private int counter = 0;

        public synchronized void increment() {
            ++counter;
        }

        public synchronized int get() {
            return counter;
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.get();

    }
}
