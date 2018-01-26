
class Week1{
public static void main(String[] args) {
Test test_av_toString = new Test("test_av_toString");
System.out.println(test_av_toString);

Test2 test_av_toString2 = new Test2("test_av_toString");
System.out.println(test_av_toString2);

Test3 test_av_toString3 = new Test3("test_av_toString");
System.out.println(test_av_toString3);

Test4 test_av_toString4 = new Test4("test_av_toString");
System.out.println(test_av_toString4.skrivUt());
}
}

class Test{

public int a = 1;
private String locname;

Test(String name){
locname = name;
}

public String toString(){
return "I'm "+locname;
}
}


class Test2{

public int a = 1;
private String name;

Test2(String name){
name = name;
}

public String toString(){
return "I'm "+name;
}
}

class Test3{

public int a = 1;
private String name;

Test3(String name){
this.name = name;
}

public String toString(){
return "I'm "+name;
}
}

class Test4{

public int a = 1;
private String name;

Test4(String name){
this.name = name;
}

public String skrivUt(){
return "I'm "+this.name;
}
}



