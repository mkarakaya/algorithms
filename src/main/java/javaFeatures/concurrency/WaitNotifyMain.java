package javaFeatures.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mokarakaya on 29.10.2016.
 */
public class WaitNotifyMain {
    private boolean pizzaArrived = false;
    public static void main(String[] args) throws InterruptedException {
        WaitNotifyMain waitNotifyMain = new WaitNotifyMain();
        waitNotifyMain.solve();
    }

    private void solve() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable customer = () -> {
            synchronized (this) {
                while (!pizzaArrived) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("yumyum..");
        };
        executor.execute(customer);
        executor.execute(customer);
        Runnable pizzaGuy = () -> {
            synchronized (this) {
                this.pizzaArrived = true;
                System.out.println("catch a pokemon before knocking door");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("knock knock");
                notifyAll();
            }
        };
        executor.execute(pizzaGuy);
        executor.shutdown();
    }
}

