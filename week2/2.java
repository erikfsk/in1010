class Personer{
	public static void main(String[] args) {
		Person erik = new Person(23,"Erik");

		System.out.println(erik);
		System.out.println("\nErik har bursdag :)\n");
		erik.harBursdag();
		System.out.println(erik);
	}
}

class Person{
	private String name;
	private int alder;

	public Person(int _alder,String _name){
		this.name = _name;
		this.alder = _alder;
	}

	public String toString(){
		return name+" "+alder;
	}

	public void harBursdag(){
		this.alder++;
	}
}