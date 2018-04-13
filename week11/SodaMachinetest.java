import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * Class for a monitor object, maintaining a soda machine.
 * The number of sodas will always be 0 <= sodas <= capacity.
 */
class SodaMachine {
    private final Lock sodaLock = new ReentrantLock();
    private final Condition hasSodasToBy = sodaLock.newCondition();
    private final Condition needsRefill = sodaLock.newCondition();
    private final int capacity;
    private int sodaCount;

    public SodaMachine(int capacity) {
        this.capacity = capacity;
        sodaCount = 0;  // Not needed in Java, but just to be explicit.
    }

    /**
     * Try to buy a soda, possibly waiting intill there are sodas to buy.
     * If no sodas remain after the purchase, notify the refiller.
     */
    public void buySoda() {
        sodaLock.lock();
        try {
            while (sodaCount == 0)
                hasSodasToBy.await();

            // take a soda
            System.out.println("Buying a soda, remaining count is " + --sodaCount);

            if (sodaCount == 0)
                needsRefill.signal();
        } catch (InterruptedException e) {
            System.out.println("Got interrupted while trying to buy soda.");
        } finally {
            sodaLock.unlock();
        }
    }

    /**
     * Try to refill the machine to maximum capacity, possibly waiting untill
     * a refill is needed. When the machine is refilled, let all the buyers know.
     */
    public void refill() {
        sodaLock.lock();
        try {
            while (sodaCount > 0)
                needsRefill.await();

            // Refill
            sodaCount = capacity;
            System.out.println("Refilling, soda count is " + sodaCount);

            // Let buyers know there is more soda!
            hasSodasToBy.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Got interrupted while trying to refill soda.");
        } finally {
            sodaLock.unlock();
        }
    }
}
