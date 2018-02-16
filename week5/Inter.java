class Inter{
  public static void main(String[] args) {
    Glass glass_ = new Glass(new Øl());
    System.out.println(glass_);

  }
}

interface DrikkBar{
  public void drikkGlass();
  public void fyllOpp(drikkBar type_drikke_input);
}

interface Drikke{
  public String smak();
}


class Glass implements DrikkBar{
  private Drikke type_drikke;

  public Glass(Drikke type_drikke_input){
    type_drikke = type_drikke_input;
  }

  public void drikkGlass(){
    return;
  }
  public void fyllOpp(drikkBar type_drikke_input){
    return;
  }

  public String toString(){
    return "Drikken i glasset smaker "+type_drikke.smak();
  }
}

class Øl implements Drikke{
  public String smak(){
    return "ÆSJ!!!";
  }
}
