import java.util.*;

class Test{
    public static void main(String[] args) {
        Person[] personer = {
            new Person("Andreas","Hurthe",25),
            new Person("Kristine","Henriksen",30),
            new Person("Henrik","Golsen",25),
            new Person("Sigvart","Dagsland",29)
        };
        Arrays.sort(personer);

        for (Person person_i : personer) {
            System.out.println(person_i);
        }
    }
}


class Person implements Comparable<Person>{
    private String fornavn,etternavn;
    private int alder;

    Person(String fn,String en,int alder){
        fornavn  = fn;
        etternavn = en;
        this.alder = alder;
    }
    public String toString(){
        return etternavn+", "+fornavn+": "+alder;
    }

    public int getAge(){
        return this.alder;
    }

    public int compareTo(Person annen){
        if (alder == annen.getAge()) {
            return toString().compareTo(annen.toString());
        }
        return alder - annen.getAge();
    }
}
