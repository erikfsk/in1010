import  javafx.application.Application;
import  javafx.stage.Stage;
import  javafx.scene.Scene;
import  javafx.scene.layout.Pane;
import  javafx.scene.text.Font;
import  javafx.scene.text.Text;

import java.time.LocalTime;


public class KlokkeFerdig extends Application {
    Text hilsen = new Text(naa());
    public static boolean slutt = false;

    class Sekundteller extends Thread{
        public void run(){
            while (!slutt){
                try{
                    sleep(1000);
                } catch (InterruptedException e){
                    slutt = true;
                }

                //1. Sett ny tekst/nytt klokkeslett i “hilsen”-variablen, FYLL INN:’
                //( Hint: se paa hvordan “hilsen” er opprettet..)
                hilsen.setText(naa());
            }
        }
    }
    //3. FYLL INN METODENAVN OG EVT PARAMETRE
    @Override
    public void start(Stage teater){

        //4. Sett Y-aksen til teksten til å være 100.
        hilsen.setY(100);

        //5. SETT FONT, opprett font med parameter 100
        hilsen.setFont(new Font(100));

        Pane kulisser = new Pane();
        //6. LEGG TIL "hilsen i kulisser"
        kulisser.getChildren().add(hilsen);

        //7. Opprett en scene med kulisser
        Scene scene = new Scene(kulisser);

        //8. SETT tittle på "teateret":
        teater.setTitle("Klokken er");

        //9. Sett scenen og vis den!
        teater.setScene(scene);
        teater.show();

        //10. Opprett og start en "Sekundteller"-tråd
        new Sekundteller().start();
    }

    private static String naa(){
        //Hva er klokken nå? Svaret er på formen "12:34:56".
        LocalTime t = LocalTime.now();
        return String.format("%02d:%02d:%02d",
            t.getHour(),t.getMinute(),t.getSecond());
    }

    public static void main(String[] args) {
        //11. Start applikasjonen
        Application.launch(args);
        slutt = true;
    }
}
