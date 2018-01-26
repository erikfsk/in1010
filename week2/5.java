class Test5{
	public static void main(String[] args) {
        Kaningaard kg = new Kaningaard();
        kg.settInn(new Kanin("Kaare"));
        kg.settInn(new Kanin("Kaare"));
        kg.fjern("Kaare");
        kg.fjern("Kaare");
        
    }
}

class Kaningaard {
    
    private Kanin [] kaniner = new Kanin[100];
   
    public boolean full() {
    	for(Kanin kanin : kaniner){
    		if(kanin == null) return false;
    	}
    	return true;
    }

    public boolean tom () {
    	for(Kanin kanin : kaniner){
    		if(kanin != null) return false;
    	}
    	return true;
    }

    public Kanin finnEn(String navn) {
    	for(Kanin kanin : kaniner){
    		if (kanin != null){
    			if(kanin.hentNavn().equals(navn)){
    				return kanin;
    			}
    		}
    	}
    	return null;
    }
    public void settInn (Kanin kanin) {
    	if(finnEn(kanin.hentNavn())!=null){
    		System.out.println(kanin.hentNavn()+" er her allerede");
    	} else if (full()){
    		System.out.println("FULL");
    	} else {
    		for(int i = 0; i<100;i++){
    			if(kaniner[i] == null){
					kaniner[i] = kanin;
					System.out.println(kanin.hentNavn()+" er satt inn");
    				return;
    			}
    		}
    	}
    	return; }


    public void fjern(String navn) {
    	if (tom()){
    		System.out.println("EMPTY");
    		return;
    	} else {
    		for(int i = 0;i<100;i++){
    			if(navn.equals(kaniner[i].hentNavn())){
    				kaniner[i] = null;
    				System.out.println(navn+" er tatt ut");
    				return;
    			}
    		}
    	}
    	System.out.println("NOT FOUND");
    	return;
    }
}


class Kanin{
	private String navn;

	public Kanin(String _navn){
		this.navn = _navn;
	}

	public String hentNavn(){
		return navn;
	}

}
