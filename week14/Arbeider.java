import java.util.concurrent.CountDownLatch;

class Arbeider implements Runnable {
   private final CountDownLatch ferdigSignal;

   Arbeider(CountDownLatch ferdig) {
      ferdigSignal = ferdig;
   }
    public void run() {
        try {
            System.out.println("Gjor arbeid!");
            gjorArbeid();
            ferdigSignal.countDown();
        } catch (Exception e){
            System.out.println("Uff, det var dumt!");
        }
    }
    public void gjorArbeid() {
        System.out.println("...");
    }
}



class TestCountdown { // ...
   public static void main(String[] args) throws InterruptedException {
       int antTraader = 5;
       CountDownLatch ferdigSignal = new CountDownLatch(antTraader);

        for (int i = 0; i < antTraader; ++i) {
            new Thread(new Arbeider(ferdigSignal)).start();
        }
        ferdigSignal.await();           // venter paa alle traadene
        System.out.println("Alle er ferdige!");
    }
}
