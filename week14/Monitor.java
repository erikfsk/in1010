class Monitor{
    SortLenkeListe<Melding> sortertListe = new SortLenkeListe<Melding>();

    // LAG en til liste hvis du skal ha en monitor.
    SortLenkeListe<Melding> sortertListe = new SortLenkeListe<Melding>();


    public Melding hentMelding(){
        // Lås
            if sortertListe.tom() && !erTelegrafisteneFerdig(){
                await()...
            }
            sortertListe.hent();

        // Lås av


    }

    public void leggTilMelding(Melding melding){
        // Lås

        sortertListe.leggTil(Melding)

        // Lås av
    }

    public boolean tom(){
        return sortertListe.tom();
    }

    public boolean erTelegrafisteneFerdig(){
        return telegrafistFerdig == 3;
    }

    public boolean erKryptografeneFerdig(){
        return kryptografFerdig == 20;
    }



}
