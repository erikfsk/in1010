import java.util.*;

class TestFIFO {
  public static void main(String[] args) {
    FIFOListe<String> liste = new FIFOListe<>();

    liste.leggTil("Hei");
    liste.leggTil("på");
    liste.leggTil("deg");
    liste.leggTil("!");

    System.out.println("\nBruker skrivUtListe() ... ");
    liste.skrivUtListe();

    System.out.println("\nBruker iterator ... ");
    for (String tekst : liste) {
      System.out.print(tekst + " ");
    }
    System.out.println();
  }
}



class FIFOListe<T> implements Iterable<T>{

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



    public void fjernAlt(){
        hode = null;
        hale = null;
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

    public T fjern(int indeks) {
        Node node_indeks = hentNode(indeks);
        if (node_indeks != null){
            Node forrige_node = node_indeks.forrige;
            Node neste_node = node_indeks.neste;
            forrige_node.neste = neste_node;
            neste_node.forrige = forrige_node;
            storrelse_--;
            return node_indeks.ting;
        }
        return null;
    }

    public void skrivUtListe() {
        Node node_teller = hode;
        while (node_teller != null) {
            System.out.println(node_teller.ting);
            node_teller = node_teller.neste;
        }
    }

    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }

    private class LenkelisteIterator implements Iterator<T>{
        int pos = 0;
        public boolean hasNext(){
            if (pos < storrelse_){
                return true;
            }
            return false;
        }

        public T next(){
            T innhold = hent(pos);
            pos++;
            return innhold;
        }

    }
}












//
