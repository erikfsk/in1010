class DyreTest{
	public static void main(String[] args) {
		Rotte testRotte = new Rotte();
		testRotte.lagLyd();
	}
}

 class Dyr{

	public  void lagLyd();
}


class Hund extends Dyr{

	@Override
	public void lagLyd(){
		System.out.println("VOFF!!!");
	}
}

class Katt extends Dyr{

	@Override
	public void lagLyd(){
		System.out.println("Mjau...");
	}
}

class Rotte extends Dyr{

	@Override
	public void lagLyd(){
		System.out.println(navn);
	}
}