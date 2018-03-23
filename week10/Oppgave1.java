import java.util.*;
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
        System.out.println("TEKST".toLowerCase());
        String text = "hallo i luken, og hei paa deg du er veldig kul og snill";
        fromText(text);
        fromFile("Oppgave1_.txt");
    }

    public static void fromFile(String filnavn){
        List<String> words_List = new ArrayList<String>();
        Scanner fil = null;

        try{
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e){
            System.out.println("Dette var dumt");
        }
        while(fil.hasNextLine()){
            String line = fil.nextLine();
            String[] words = line.split(" ");
            for (String word : words){
                words_List.add(word);
            }
        }

        printToTerminal(words_List.toArray(new String[words_List.size()]));
    }

    public static void fromText(String text){
        printToTerminal(text.split(" "));
    }

    public static void printToTerminal(String[] words){
        for (String word : words){
            if (word.length() < 2){
                System.out.format("Ord: %-10s %-10s%n",word,"Ingen andre bokstav.");
            } else {
                System.out.format("Ord: %-10s Andre Bokstav %s\n",word,word.charAt(1));
            }
        }
    }
}
