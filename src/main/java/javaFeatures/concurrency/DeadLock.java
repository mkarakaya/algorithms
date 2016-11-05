package javaFeatures.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mokarakaya on 05.11.2016.
 */
public class DeadLock {
    public static Lock table=new ReentrantLock();
    public static Lock bathroom=new ReentrantLock();


    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        DeadLock deadLock= new DeadLock();
        ExecutorService executor= Executors.newFixedThreadPool(3);
        Runnable eatRunnable= () -> {
            try {
                deadLock.eatAndWashHands();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable washHandsRunnable= () -> {
            try {
                deadLock.washHandsAndEat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Future<?> submitEat = executor.submit(eatRunnable);
        Future<?> submitWashHands = executor.submit(washHandsRunnable);
        executor.shutdown();
        while (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

    }

    public boolean eatAndWashHands() throws InterruptedException {
         if(table.tryLock(5,TimeUnit.SECONDS)){
            System.out.println("eating first");
             //table.unlock();
            if(bathroom.tryLock(5,TimeUnit.SECONDS)){
                System.out.println("washing hands then");
            }
        }
        return true;
    }

    public boolean washHandsAndEat() throws InterruptedException {
        if(bathroom.tryLock(5,TimeUnit.SECONDS)){
            System.out.println("washing hands first");
            //bathroom.unlock();
            if(table.tryLock(5,TimeUnit.SECONDS)){
                System.out.println("eating then");
            }
        }
        return true;
    }
}


