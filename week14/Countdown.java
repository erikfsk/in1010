import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.Random;


public class CountDownExample {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        CountDownLatch allDoneBarrier = new CountDownLatch(NUM_THREADS);
        KeepLargestMonitor monitor = new KeepLargestMonitor();
        for (int i = 0; i < NUM_THREADS; i++) {
			new Thread(new Conteder(monitor, allDoneBarrier)).start();
        }

        try {
            allDoneBarrier.await();
        } catch (InterruptedException e) {}
        System.out.println("Largest: " + monitor.getLargest());
    }
}



class KeepLargestMonitor {
    private final Lock lock = new ReentrantLock();
    private int largest;

    public int getLargest() { return largest; }

    public void giveNumber(int number) {
       	//Laas laasen:
        lock.lock();
        try { largest = Math.max(largest, number); }
        finally { lock.unlock(); }
    }
}


class Contender implements Runnable {
    private final KeepLargestMonitor monitor;
    private final CountDownLatch allDoneBarrier;
    private final int id;
    private static int numberOfWorkersDoingThisJob = 0;

    public Contender(KeepLargestMonitor monitor, CountDownLatch allDoneBarrier) {


        this.id = numberOfWorkersDoingThisJob++;
        this.monitor = monitor;
        this.allDoneBarrier = allDoneBarrier;
    }

    public void run() {
        Random random = new Random();
        int number = random.nextInt(100);  // Max of 100.
        System.out.printf("Thread #%d generated number: %d\n", id, number);
        monitor.giveNumber(number);
        allDoneBarrier.countDown();
        try {
            allDoneBarrier.await();
        } catch (InterruptedException e) {}
        System.out.println("Test");
        // If we submitted the largest value, we won!
        if (number == monitor.getLargest())
            System.out.printf("Thread #%d won!.\n", id);
    }
}
