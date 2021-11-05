import java.util.concurrent.locks.ReentrantLock;

/*
	Synchronizujemy dostęp do zasobu za pomocą locka.
 */
public class Test004 {
    public static class Counter {
        private int counter = 0;
        private ReentrantLock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            ++counter;
            lock.unlock();
        }

//		public int get() {
//			lock.lock();
//			int value = counter;
//			lock.unlock();
//			return value;
//		}

        public int get() {
            try {
                lock.lock();
                return counter;
            } finally {
                lock.unlock();
            }
        }


    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.get();

    }
}
