import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class HeiPersonFerdig extends Application {

    public TextField tekstfelt = null;
    public Label hilsen;

    @Override
    public void start (Stage stage) {
        VBox pane = new VBox();
        VBox pane2 = new VBox();

        Label merkelapp = new Label("Fyll inn navn:");
        tekstfelt = new TextField("Navn");

        Button knapp = new Button("Si hei!");
        Knappebehandler behandler = new Knappebehandler();
        knapp.setOnAction(behandler);

        hilsen = new Label("");
        pane2.getChildren().addAll(knapp,hilsen,merkelapp, tekstfelt);
        pane.getChildren().addAll(knapp,hilsen,merkelapp, tekstfelt,pane2);
        stage.setScene(new Scene(pane, 200, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }


    class Knappebehandler implements EventHandler <ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
           String hilsetekst = tekstfelt.getText();
           hilsen.setText(String.format("Hei på deg, %s!", hilsetekst));
        }
    }
}
