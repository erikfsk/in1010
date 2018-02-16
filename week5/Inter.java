class Inter{
  public static void main(String[] args) {
    Glass glass_ = new Glass(new Øl());
    System.out.println(glass_);

  }
}

interface drikkBar{
  public void drikkGlass();
  public void fyllOpp(drikkBar type_drikke_input);
}

interface drikke{
  public String smak();
}


class Glass implements drikkBar{
  private drikke type_drikke;

  public Glass(drikke type_drikke_input){
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

class Øl implements drikke{
  public String smak(){
    return "ÆSJ!!!";
  }
}
