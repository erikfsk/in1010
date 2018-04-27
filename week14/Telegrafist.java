

class Telegrafist implements Runnable{
    Kanal minKanal;
    Monitor minKryptertMonitor;
    private int minKanalID;
    private static int kanalID = 0;


    Telegrafist(Kanal minKanal,minKryptertMonitor){
        this. = ....;
        this.minKanalID = kanalID++;
    }



    public void run(){
        try{
            String kryptertTekst = minKanal.lytt();
            sekvensNummer = 0;
            while(kryptertTekst != null){
                minKryptertMonitor.leggTilMelding(new Melding(kryptertTekst,sekvensNummer++,kanalID))
                kryptertTekst = minKanal.lytt();
            }
            // SIGNALISER AT DU ER FERDIG
        } catch (InterruptedException e){
            System.out.println("UFF");
        }
    }

}
