import java.util.Random;

public class SodaMachineExample {
    private static final int NUM_BUYERS = 3;
    private static final int NUM_SODAS_PER_BUYER = 5;
    private static final int SODAS_PER_REFILL = 5;
    private static final int NUM_REFILLS = (NUM_BUYERS * NUM_SODAS_PER_BUYER) /
                                            SODAS_PER_REFILL;
    private static final int MAX_BUYER_SLEEP = 5000;
    private static final int MAX_REFILL_SLEEP = 3000;
    private static final Random random = new Random(12345);

    public static void main(String[] args) {

        SodaMachine sodaMachine = new SodaMachine(SODAS_PER_REFILL);

        // Make buyers
        Runnable buySoda = new Runnable() {
            public void run() {
                for (int i = 0; i < NUM_SODAS_PER_BUYER; i++) {
                    try {
                        Thread.sleep(Math.abs(random.nextInt()) % MAX_BUYER_SLEEP);
                    } catch (InterruptedException e) {}
                    sodaMachine.buySoda();
                }
            }
        };

        // Start buyers (won't be able to do anything before refiller starts).
        for (int i = 0; i < NUM_BUYERS; i++)
            new Thread(buySoda).start();

        // Make and start the refiller thread.
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < NUM_REFILLS; i++) {
                    try {
                        Thread.sleep(Math.abs(random.nextInt()) % MAX_REFILL_SLEEP);
                    } catch (InterruptedException e) {}
                    sodaMachine.refill();
                }
            }
        }).start();
    }
}
