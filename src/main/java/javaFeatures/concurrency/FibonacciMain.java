package javaFeatures.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * multithreaded version of fibonacci number calculation.
 * Created by mokarakaya on 30.10.2016.
 */
public class FibonacciMain {
    private static Integer solve(int i, ExecutorService executor) throws InterruptedException {
        if(i==0) return 0;
        if(i==1 || i==2) return 1;
        List<Callable<Integer>> callables= new ArrayList<>();
        callables.add(()-> solve(i-1,executor));
        callables.add(()-> solve(i-2,executor));
        return executor.invokeAll(callables).stream().mapToInt(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return -1;
        }).sum();
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(8);
        int fib=10;

        long start = System.currentTimeMillis();
        Integer multithreaded = solve(fib, executor);
        long end = System.currentTimeMillis();
        System.out.println("multithreaded takes:"+(end-start));

        start = System.currentTimeMillis();
        int original = originalFib(fib);
        end = System.currentTimeMillis();
        System.out.println("original takes:"+(end-start));

        System.out.println("original:"+original+" multithreaded:"+multithreaded);
        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("waiting");
        }

    }
    public static int originalFib(int n){
        if(n==0) return 0;
        if( n==1 || n ==2) return 1;
        return originalFib(n-1)+originalFib(n-2);
    }



}
