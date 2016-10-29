package javaFeatures.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Recursive multithreaded implementation of quicksort.
 * Created by mokarakaya on 29.10.2016.
 */
public class ForkJoinMain {
    private static String sort(int[] ar, int low, int high, ExecutorService executor) throws InterruptedException {
        if (low < high) {
            int p = partition(ar, low, high);
            List<Callable<String>> callables = new ArrayList<>();
            callables.add(() -> sort(ar, low, p - 1, executor));
            callables.add(() -> sort(ar, p + 1, high, executor));
            executor.invokeAll(callables).stream().forEach(future -> {
                try {
                    System.out.println(low + " and " + high + " calls " + future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
        return low + " and " + high;
    }

    static int partition(int[] ar, int low, int high) {
        int pivot = low;
        for (int i = low + 1; i <= high; i++) {
            if (ar[i] < ar[pivot]) {
                shift(ar, i, pivot);
                pivot++;
            }
        }

        return pivot;
    }

    static void printArray(int[] ar, int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println("");
    }

    private static void shift(int[] ar, int i, int j) {
        int value = ar[i];
        for (int k = i; k > j; k--) {
            ar[k] = ar[k - 1];
        }
        ar[j] = value;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] ar = new int[]{1, 3, 4, 6, 1, 23, 6, 8, 4, 53, 23};
        ExecutorService executor = Executors.newWorkStealingPool(8);
        sort(ar, 0, ar.length - 1, executor);
        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("waiting");
        }
        printArray(ar, 0, ar.length - 1);
    }
}
