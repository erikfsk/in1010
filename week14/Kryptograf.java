

class Kryptograf implements Runnable{
    Kanal minKanal;
    Monitor minKryptertMonitor;
    Monitor minDeKryptertMonitor;


    Kryptograf(Kanal minKanal,minKryptertMonitor,minDeKryptertMonitor){
        this. = ....;
    }



    public void run(){
        try{
            while (!minKryptertMonitor.tom() || !minKryptertMonitor.erTelegrafisteneFerdig()){
                Melding melding = minKryptertMonitor.hentMelding();
                String dekryptert = Kryptografi.dekrypter(melding.toString());
                melding.setTekst(dekryptert);
                minDeKryptertMonitor.leggTilMelding(melding);
            }

            // SIGNALISER AT DU ER FERDIG
        } catch (InterruptedException e){
            System.out.println("UFF");
        }
    }



    public boolean erFerdig(){
        minKryptertMonitor.erTelegrafisteneFerdig() && minKryptertMonitor.tom()
    }

}
