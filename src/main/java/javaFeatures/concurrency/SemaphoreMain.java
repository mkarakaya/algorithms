package javaFeatures.concurrency;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;



/**
 * Created by mokarakaya on 28.10.2016.
 * semaphore example
 */
public class SemaphoreMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(3);
        Semaphore semaphore= new Semaphore(2);
        Runnable runnable=()->{
            try {
                semaphore.acquire();
                System.out.println("acquired");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("doing things");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println("released");
        };
        time(executor,3,runnable);

    }

    public static void time(ExecutorService executor, int concurrency,
                            final Runnable action) throws InterruptedException {
        for(int i=0;i<concurrency;i++){
            executor.execute(action);
        }
        executor.shutdown();
    }
}
