class OverTest{
	public static void main(String[] args) {
		Over test = new Over();
		System.out.println(test);
		test.overloadingTest();
		test.overloadingTest("Erik");

		Over2 test2 = new Over2();
	}
}


class Over{

	public void overrideTest(){
		System.out.println("Now we are in an Over-object.");
	}

	
	public void overloadingTest(){
		System.out.println("Hello World!");
	}

	public void overloadingTest(String navn){
		System.out.println("Hello "+navn+"! My name is Over@7852e922.");
	}
}

class Over2 extends Over{

	@Override
	public void overrideTest(){
		System.out.println("Now we are in an Over2-object.");	
	}
}