import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
	CountDownLatch
	Jak dokonać synchronizacji pewnej liczby jobów.
 */
public class Test013 {
    public static double fibon(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibon(n - 1) + fibon(n - 2);
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cl = new CountDownLatch(40);
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 40; ++i) {
            int index = i;
            ex.execute(() -> {
                System.out.println(fibon(index));
                cl.countDown();
            });
        }
        cl.await();

        System.out.println("All fibons ready!");
        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.DAYS);
    }
}
