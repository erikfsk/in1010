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
        // kommer neste time :)
    }
}
