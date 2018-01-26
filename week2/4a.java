class Baat {
    private String regNr;
    private int kilometer;

    public Baat(String regNr){ //Baaten
        this.regNr = regNr;
        this.kilometer = 0; //kilometerstand
    }
    
    //Skriver info om baaten
    public void skrivBaat() {
        System.out.println(regNr); // print
        System.out.println(kilometer); // print & kilometerstand
    }
}
