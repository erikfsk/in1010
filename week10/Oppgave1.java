import java.util.Scanner;
import java.io.*;

class Oppgave1{
    public static void main(String[] args) {
        String testTekst = "12345, lengde = 18";
        System.out.println(testTekst.charAt(2));
        System.out.println(testTekst.length());
        System.out.println(testTekst.substring(2));
        System.out.println(testTekst.substring(2,5));
        System.out.println(testTekst.split("lengde"));
        String[] testTekstList = testTekst.split("lengde, =");
        for(String s : testTekstList){
            System.out.println(s);
        }
    }

    public static void fromFile(){
        //Oppgave1.txt
    }

    public static void fromText(){
        String text = "hallo i luken, og hei paa deg du er veldig kul og snill";
    }

    public static void printToTerminal(String[] words){
        System.out.println(words);
    }
}
