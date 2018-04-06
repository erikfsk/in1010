import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Main4{
    public static void main(String[] args){
        CountMonitor monitor = new CountMonitor ();
        Runnable task = new MyTaskMonitor(monitor);
        Thread worker1 = new Thread(task);
        Thread worker2 = new Thread(task);
        worker1.start();
        worker2.start();
    }
}


class CountMonitor{
    private final Lock lock = new ReentrantLock ();
    private int sharedCounter = 0;// The protected data.

    public void increment(){
        lock.lock();
        try {
            sharedCounter = sharedCounter+1;
        } finally {
            lock.unlock();
        }
    }
    public int getCounter(){
        return sharedCounter;
    }
}

class MyTaskMonitor implements Runnable {
    private final int MAX_COUNT = 10000;
    private final CountMonitor monitor;

    public MyTaskMonitor(CountMonitor monitor){
        this.monitor = monitor;
    }

    public void run(){
        for(int i = 0; i < MAX_COUNT; i++){
            monitor.increment();
        }
        System.out.println("Done! Shared counter = "+monitor.getCounter());
    }
}
