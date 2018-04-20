import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

public class LeetCoder extends Application {
    
    TextArea leetText = null;
    static ArrayList<String> chunks = null;
    
    public void start (Stage stage) {
        
        FileChooser filvelger = new FileChooser();
        File fil = filvelger.showOpenDialog(stage);
        
        chunks = new ArrayList<>();
        
        //Les noe fra fil
        Scanner scanner = null;
        try {
            scanner = new Scanner(fil);
            
            while (scanner.hasNextLine()) {
                String[] linje = scanner.nextLine().split(" ");
                for (int i = 0; i < linje.length; i++) {
                    chunks.add(linje[i]);
                }
                //"Hack" fordi newline fjernes når vi splitter på mellomrom.
                chunks.add("\n");
            }
        } catch (FileNotFoundException e) {
            //Fant ikke filen, lukker programmet
            Platform.exit();
        }
        
        //Lag et tekstfelt 
        leetText = new TextArea();
        //Det er ikke redigerbart, men registrerer fortsatt knappetrykk!
        leetText.setEditable(false);
        leetText.setWrapText(true);
        leetText.setPrefSize(600, 400);
        
        TekstfeltLytter lytter = new TekstfeltLytter();
        leetText.setOnKeyPressed(lytter);
        
        HBox root = new HBox();
        root.getChildren().add(leetText);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("1337 Hacker");
        stage.show();
        
    }
    
    public class TekstfeltLytter implements EventHandler<KeyEvent> {
        
        String leetCode = "";
        Iterator listeIterator = chunks.iterator();
        
        @Override
        public void handle(KeyEvent e) {
        
            //Oppdater tekstfeltet med en gang
            if (! listeIterator.hasNext()) {
                listeIterator = chunks.iterator();
            }
            
            leetCode = leetCode + " " + listeIterator.next();
            leetText.setText(leetCode);
            leetText.setScrollTop(Double.MAX_VALUE);
        }
        
    }
}
