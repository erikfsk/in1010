import java.util.Scanner;

class HeiVerden{
	public static void main(String[] args){
		System.out.println("Hei! Hva heter du?");
		Scanner input_ = new Scanner(System.in);
		String navn = input_.nextLine();
		System.out.println("Hei, "+navn+"! Velkommen til IN1010.");
	}
}