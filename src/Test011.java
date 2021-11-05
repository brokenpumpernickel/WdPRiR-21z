import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
	Memoisacja, XD
	Jak przyspieszyć rekurencję inaczej.
 */
public class Test011 {
    public static ConcurrentHashMap<Integer, Double> memoiser = new ConcurrentHashMap<>();

    public static double fibon(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return memoiser.computeIfAbsent(n, (i) -> fibon(i - 1) + fibon(i - 2));
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 150; ++i) {
            int index = i;
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + " " + fibon(index));

                }
            });
        }

        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("All fibons ready!");

    }
}
