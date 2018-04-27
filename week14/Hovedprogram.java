public class Hovedprogram{
    public static void main(String[] args) {
        Operasjonsentral obs = new Operasjonsentral(3)
        int antKanaler = obs.hentAntallKanaler();
        Kanal[] kanaler = obs.hentKanalArray();

        // 1 monitor
        Monitor monitor = new Monitor();

        // 2 monitorer
        Monitor kmonitor = new Monitor();
        Monitor dkmonitor = new Monitor();




        for(int i = 0; i<antKanaler; i++){
            new Thread(new Telegrafist(kanaler[i],kmonitor)).start();
        }

        for(int i = 0; i<20; i++){
            new Thread(new Kryptograf(kanaler[i],kmonitor,dkmonitor)).start();
        }

        // Trenger ikke å være en tråd
        new Thread(new Operasjonleder()).start();
    }
}
