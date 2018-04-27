class Melding implements Comparable<Melding>{

    Melding(String tekst){
        this....
    }


    public int compareTo(Melding m){
        return sekvensNummer - m.sekvensNummer;
    }

    public String toString(){
        return tekst;
    }

    public void setTekst(String tekst){
        this.tekst = tekst;
    }
}
