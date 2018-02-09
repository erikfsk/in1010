class Hoved{
	public static void main(String[] args) {
		Sjafor erik = new Sjafor("Erik",18);
		Motorsykkel erikSinBil = new Motorsykkel(erik);
		Person kid1 = new Person("kid1",4);
		Person kid2 = new Person("kid1",4);
		Person kid3 = new Person("kid1",4);
		erikSinBil.leggTilPerson(kid1);
		erikSinBil.leggTilPerson(kid2);
		erikSinBil.leggTilPerson(kid3);
		System.out.println(erikSinBil);
	}
}

class Person{
	private String navn;
	private int alder;

	public Person(String navn,int alder){
		this.alder = alder;
		this.navn = navn;
	}

	public String toString(){
		return this.navn + ", "+ alder;
	}
}


class Sjafor extends Person{

	public Sjafor(String navn,int alder){
		super(navn,alder);
	}
}


class Kjortoy{
	private static int regNrTeller = 0;
	protected int regNr;
	private Person[] personer = new Person[1];
	private int teller = 1;
	private int plasser;

	public Kjortoy(Sjafor eier,int antPlasser){
		personer = new Person[antPlasser];
		regNr = regNrTeller;
		regNrTeller++;
		personer[0] = eier;
		plasser = antPlasser;
	}

	public boolean leggTilPerson(Person nyPerson){
		if(teller < plasser){
			personer[teller] = nyPerson;
			teller++;
			return true;
		} 
		return false;	
	}

	public String toString(){
		String output = "Bil med regNr "+regNr+" har folgende personer i bilen:\n";
		for(Person i :personer){
			if(i == null){
				return output;
			}
			output = output + i.toString()+"\n";
		}
		return output;
	}
}

class Bil extends Kjortoy{

	public Bil(Sjafor eier,int antPlasser){
		super(eier,antPlasser);
		System.out.println(regNr);
	}
}

class Motorsykkel extends Kjortoy{
	public Motorsykkel(Sjafor eier){
		super(eier,1);
	}
}