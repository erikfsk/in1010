abstract class Dyr {
	public abstract void lagLyd();
}


class Katt extends Dyr{

	@Override
	public void lagLyd(){
		System.out.println("Mjau...");
	}
}


class Hund extends Dyr{

	@Override
	public void lagLyd(){
		System.out.println("VOFF!!!");
	}
}


class Test{
	public static void main(String[] args) {
		Katt katt1 = new Katt();
		Katt katt2 = new Katt();
		Hund katt3 = new Hund();
	}
}