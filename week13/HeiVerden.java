import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HeiVerden extends Application {
    
    Button knapp = null;
    
	@Override
	public void start (Stage stage) {
        
        knapp = new Button("Si hei!");
        Knappebehandler behandler = new Knappebehandler();
		knapp.setOnAction(behandler);
        
        VBox pane = new VBox(knapp);
        
		stage.setScene(new Scene(pane));
		stage.show();
	}
    
    class Knappebehandler implements EventHandler <ActionEvent> {
        
        @Override
        public void handle(ActionEvent e) {
           knapp.setText(String.format("Hei verden!"));
        }
    }
}