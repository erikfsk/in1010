class Motorsykkel{
	
	// a - start
	private int kilometerstand = 0;
	private String registeringsnummer;
	private int produksjonsnummer;
	private static int teller = 0;

	public Motorsykkel(String regnr){
		this.registeringsnummer = regnr;
		this.produksjonsnummer = teller;
		teller++;
	}
	// a - end



	// b - start
	public int hentProduksjonsnummer(){
		return produksjonsnummer;
	}


	public int hentKilometerstand(){
		return kilometerstand;
	}
	// b - end

	// c - start
	public void kjoer(int nye_km){
		this.kilometerstand = this.kilometerstand + nye_km;
	}
	// c - end
}

	// d - start
class MotorsykkelProgram{
	public static void main(String[] args) {
		Motorsykkel test_motorsykkel = new Motorsykkel("Erik");
		for(int i = 0; i<10;i = i + 2){
			test_motorsykkel.kjoer(10);
		}
		// e - start
		System.out.println(test_motorsykkel.hentKilometerstand());
		// e - end

		// f - start
		for(int j = 0;j<2;j++){
			Motorsykkel test = new Motorsykkel("test");
			System.out.println(test.hentProduksjonsnummer());
		}
		// f - end
	
	}
	// d - end

}