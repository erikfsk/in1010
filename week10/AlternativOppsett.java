import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class TestFormat {

    public static void main(String[] args) {
        numbersText();
        // gameTime();
    }

    public static void numbersText(){
        /*
        i      1/i       i^0.5     i^i
        1.0    1.00000   1.00000   1.0
        2.0    0.50000   1.41421   4.0
        3.0    0.33333   1.73205   9.0
        4.0    0.25000   2.00000   16.0
        5.0    0.20000   2.23607   25.0
        6.0    0.16667   2.44949   36.0
        7.0    0.14286   2.64575   49.0
        8.0    0.12500   2.82843   64.0
        9.0    0.11111   3.00000   81.0
        10.0   0.10000   3.16228   100.0
        */
        
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

    }
}
