import  javafx.application.Application;
import  javafx.stage.Stage;
import  javafx.scene.Scene;
import  javafx.scene.layout.Pane;
import  javafx.scene.text.Font;
import  javafx.scene.text.Text;

import java.time.LocalTime;


public class Klokke extends Application {
    Text hilsen new Text(naa());

    class Sekundteller extends Thread{
        public void run(){
            boolean slutt = false;
            while (!slutt){
                try{
                    sleep(1000)
                } catch (InterruptedException e){
                    slutt = true;
                }

                //1. Sett ny tekst/nytt klokkeslett i “hilsen”-variablen, FYLL INN:’
                //( Hint: se paa hvordan “hilsen” er opprettet..)
            }
        }
    }
    @Override
    //3. FYLL INN METODENAVN OG EVT PARAMETRE
    public void ______________{

        //4. Sett Y-aksen til teksten til å være 100.

        //5. SETT FONT, opprett font med parameter 100

        Pane kulisser = new Pane();


        //6. LEGG TIL "hilsen i kulisser"

        //7. Opprett en scene med kulisser

        //8. SETT tittle på "teateret":

        //9. Sett scenen og vis den!

        //10. Opprett og start en "Sekundteller"-tråd
    }

    private static String naa(){
        //Hva er klokken nå? Svaret er på formen "12:34:56".
        LocalTime t = LocalTime.now();
        return String.format("%02d:%02d:%02d",
            t.getHour(),t.getMinute(),t.getSecond());
    }

    public static void main(String[] args) {
        //11. Start applikasjonen
    }
}
