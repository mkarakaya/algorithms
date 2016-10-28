package javaFeatures.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by mokarakaya on 28.10.2016.
 * barrier example
 */
public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
        Executor executor= Executors.newFixedThreadPool(3);
        Runnable runnable=()->{
          System.out.println("doing things");
        };
        time(executor,2,runnable);
    }
    public static long time(Executor executor, int concurrency,
                            final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    System.out.println("1");
                    ready.countDown(); // Tell timer we're ready
                    System.out.println("2");
                    try {
                        start.await(); // Wait till peers are ready
                        System.out.println("3");
                        action.run();
                        System.out.println("4");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown(); // Tell timer we're done
                    }
                }
            });
        }
        System.out.println("5");
        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        System.out.println("6");
        start.countDown(); // And they're off!
        System.out.println("7");
        done.await(); // Wait for all workers to finish
        System.out.println("8");
        return System.nanoTime() - startNanos;
    }
}
