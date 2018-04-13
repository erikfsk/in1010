import  javafx.application.Application;
import  javafx.stage.Stage;
import  javafx.scene.Scene;
import  javafx.scene.shape.Rectangle;
import  javafx.scene.layout.Pane;
import  javafx.scene.layout.GridPane;
import  javafx.scene.layout.StackPane;
import  javafx.scene.paint.Color;
import  javafx.scene.text.Font;
import  javafx.scene.text.Text;

public class EnkeltRutenett extends Application {
    public void start(Stage stage) {

        GridPane pane = new GridPane();

        int teller = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Text text = new Text(""+teller);
                text.setFont(new Font(30));
                Rectangle rect = new Rectangle(40, 40, Color.SKYBLUE);
                rect.setStroke(Color.BLACK);

                StackPane cell = new StackPane();
                cell.getChildren().addAll(rect, text);
                pane.add(cell, j, i);

                teller++;
            }
        }

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Rutenett");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
