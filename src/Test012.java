import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
	Pula wątków
	Zwracanie wartości z joba.
 */
public class Test012 {
    public static double fibon(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibon(n - 1) + fibon(n - 2);
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LinkedList<Future<Double>> noFuture = new LinkedList<>();

        for (int i = 0; i < 50; ++i) {
            int index = i;
            noFuture.add(ex.submit(() -> fibon(index)));
        }

        for (var future : noFuture) {
            System.out.println(future.get());
        }

        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("All fibons ready!");

    }
}
