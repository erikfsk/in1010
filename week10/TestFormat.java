import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class TestFormat {

    public static void main(String[] args) {
        numbersText();
        gameTime();
    }

    public static void numbersText(){
        System.out.format("%-10s %-10s %-10s %-10s%n","i", "1/i", "i^0.5","i^i");
        for (int i = 1; i<11 ;i++){
            double[] numbersList = numbers(i);
            for(double tall : numbersList){
                System.out.format("%-10.2f",tall);
            }
            // System.out.format("%-10.2f%-10.5f%-10.5f%-10.2f",
            // numbersList[0],numbersList[1],numbersList[2],numbersList[3]);
            System.out.format("%n");
        }
    }

    public static double[] numbers(int i){
        //Return a list with the elements i,1/i,i^0.5,i^i
        double[] floatList = {i,1.0/i,Math.pow(i,0.5),Math.pow(i,2)};
        return floatList;
    }

    public static void gameTime(){
        /*
        EXAMPLE:

        GAME TIME:
        I AM THINKING OF A DIGIT, BUT WHICH ONE?
        How many attempts do you need to guess it?


        0 1 2 3 4 5 6 7 8 9
        0
        > 1 2 3 4 5 6 7 8 9
        3
        > 1 2 > 4 5 6 7 8 9
        6
        > 1 2 > 4 5 < 7 8 9
        5
        > 1 2 > 4 < < 7 8 9
        4
        That is correct! 4 was the digit!
        */
        System.out.println("\n\n\nGAME TIME:");
        System.out.println("I AM THINKING OF A DIGIT, BUT WHICH ONE?");
        int randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        System.out.println("How many attempts do you need to guess it?\n\n");
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        int attempts = 10;
        int guess;
        Scanner in = new Scanner(System.in);
        while(true){
            for (String number : numbers) {
                System.out.format("%2s",number);
            }
            System.out.format("%n");

            while(true){
                try{
                    String linje = in.nextLine();
                    guess = Integer.parseInt(linje);
                    if (guess > -1 && guess < 10){
                        break;
                    }
                    throw new Exception();
                } catch (Exception e){

                }
            }

            if (guess == randomNum) {
                System.out.format("That is correct! %d was the digit!",randomNum);
                break;
            } else if (guess < randomNum){
                numbers[guess] = ">";
            } else if (guess > randomNum){
                numbers[guess] = "<";
            }
        }
    }
}
