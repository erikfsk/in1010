class Test{
	public static void main(String[] args) {
        double[] test = new double[0];
        try {
        	test[1] = 2;
        } catch (ArrayIndexOutOfBoundsException e) {
        	System.out.println("--------------------------------------------");
        	System.out.println(e);
        	System.out.println("              aka OUT OF RANGE");
        	System.out.println("--------------------------------------------");
        }
    }
}
