enum Dag{
    MANDAG,TIRSDAG,ONSDAG,TORSDAG,FREDAG,LORDAG,SONDAG
}
public class EnumTest{
    Dag dag;

    public EnumTest(Dag dag){
        this.dag = dag;
    }

    public void tellItLikeItIs(){
        if (dag == Dag.MANDAG){
            System.out.println("Mondays are bad.");
        }else if (dag == Dag.FREDAG){
            System.out.println("Fridays are better." );
        }else if (dag == Dag.LORDAG || dag == Dag.SONDAG){
            System.out.println("Weekends are best.");
        } else {
            System.out.println("Midweek days are so-so.");
        }
    }

    public static void main(String[] args){
        EnumTest firstDay = new EnumTest(Dag.MANDAG);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Dag.ONSDAG);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Dag.FREDAG);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Dag.LORDAG);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Dag.SONDAG);
        seventhDay.tellItLikeItIs();
    }
}


//          int order = Integer.parseInt(user_input.next());
// 			System.out.println();
//
// 			switch (order){
// 				case 1:
// 					readFile();
// 					break;
//
// 				case 2:
// 					writeFile();
// 					break;
//
// 				case 3:
// 					writeInfo();
// 					break;
//
// 				case 4:
// 					addLegemiddel(true,null,0,0);
// 					break;
//
// 				case 5:
// 					addLege(true,null,0);
// 					break;
//
// 				case 6:
// 					addPerson(true,null,0,null,0);
// 					break;
//
// 				case 7:
// 					addResept(true, null, null, 0, 0);
// 					break;
//
// 				case 8:
// 					legemiddelFromResept();
// 					break;
//
// 				case 9:
// 					stats();
// 					break;
//
// 				case 0:
// 					fortsett = false;
// 					break; }
