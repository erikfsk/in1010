import java.util.*;

class TestFIFO {
  public static void main(String[] args) {
    FIFOListe<String> liste = new FIFOListe<>();

    liste.leggTil("Hei");
    liste.leggTil("på");
    liste.leggTil("deg");
    liste.leggTil("!");

    System.out.println("\nBruker skrivUtListe() ... ");
    liste.skrivUtForste();
    liste.skrivUtSiste();
    System.out.println();
  }
}



class FIFOListe<T>{

    private Node hode;
    private Node hale;
    private int storrelse_ = 0;

    private class Node{
        Node neste;
        Node forrige;
        T ting;

        Node(T t){
            ting = t;
        }
    }

    public void leggTil(T t){
        Node node_new = new Node(t);
        if (erTom()) {
            hode = node_new;
            hale = hode;
        } else {
            hale.neste = node_new;
            node_new.forrige = hale;
            hale = hale.neste;
        }storrelse_++;
    }

    public int storrelse(){
        return storrelse_;
    }

    public boolean erTom(){
        return hode == null;
    }

    public Node hentNode(int indeks){
        int teller = 0;
        Node node_teller = hode;
        while (node_teller != null) {
            if (teller == indeks) {
                return node_teller;
            }
            node_teller = node_teller.neste;
            teller++;
        }
        return null;
    }

    public T hent(int indeks){
        Node node_indeks = hentNode(indeks);
        if (node_indeks != null){
            return node_indeks.ting;
        }
        return null;
    }

    public int storrelse_rek(){
        return storrelse_rek(hode);
    }
    public int storrelse_rek(Node denne){
        if (denne == null){
            return 0;
        }
        return storrelse_rek(denne.neste)+1;
    }

    public void skrivUtForste() {
        skrivUtForste(hode);
    }
    public void skrivUtForste(Node denne) {
        if (denne == null){
            return;
        }
        System.out.print(denne.ting);
        skrivUtForste(denne.neste);
    }

    public void skrivUtSiste() {
        skrivUtSiste(hode);
    }
    public void skrivUtSiste(Node denne) {
        if (denne == null){
            return;
        }
        skrivUtSiste(denne.neste);
        System.out.print(denne.ting);
    }

    public void skrivUtListe() {
        Node node_teller = hode;
        while (node_teller != null) {
            System.out.println(node_teller.ting);
            node_teller = node_teller.neste;
        }
    }
}
