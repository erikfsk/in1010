class Test{
	public static void main(String[] args) {
		PlanteDyr plantedyr0 = new Elg();
		PlanteDyr plantedyr1 = new Elg();
		PlanteDyr plantedyr2 = new Sau();
		PlanteDyr plantedyr3 = new Sau();

		DyreDyr dyredyr0 = new Bjorn();
		DyreDyr dyredyr1 = new Bjorn();
		DyreDyr dyredyr2 = new Ulv();
		DyreDyr dyredyr3 = new Ulv();

		PlanteDyr[] planteliste = new PlanteDyr[10];
		DyreDyr[] dyreliste = new DyreDyr[10];

	}
}

interface DrikkBar{
	void drikkGlass();
	void fyllOpp();
}


class Drikke implements DrikkBar{
	protected int innhold;
	protected int max;


	public Drikke(int max){
		innhold = max;
		this.max = max;
	}

	public void drikkGlass(){
		innhold = innhold - 2;
		if(innhold < 0){
			innhold = 0;
		}
	}

	public void fyllOpp(){
		innhold = max;
	}

	public String toString(){
		return "Det var godt!";
	}
}


class Ol extends Drikke{

	public Ol(int max){
		super(max);}

	@Override
	public void drikkGlass(){
		innhold = innhold - 5;
		if(innhold < 0){
			innhold = 0;
		}
	}

	public String toString(){
		return "ÆSJ!!!";
	}
}


/* 
		INTERFACE
		  ___
	      |Z|
    ^				^
    |				|
    |				|
INTERFACE  
   ___			   ___
   |Y|			   |B| 
    ^				^
    |				|
    |				|
	  ––––––––––––
		 | A |
		   ^
		   |
		   |
	    ––––––
		| C  |

*/

/*
ErPattedyr
HarPels extends ErPattedyr
Dyr
Hund extends Dyr implements HarPels
Katt extends Dyr implements HarPels
Havdyr extends Dyr
Hval extends Havdyr implements ErPattedyr
Fisk extends Havdyr
*/



interface DyreDyr{
	boolean jakte();
}

interface PlanteDyr{
	boolean beskytte();
}


class Bjorn implements DyreDyr{
	public boolean jakte(){
		return true;
	}
}

class Ulv implements DyreDyr{
	public boolean jakte(){
		return true;
	}
}

class Elg implements PlanteDyr{
	public boolean beskytte(){
		return false;
	}
}

class Sau implements PlanteDyr{
	public boolean beskytte(){
		return false;
	}
}


