import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class pomodoro extends Application{
    Button button;
    Button button2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pomodoro Timer");
        
        //BorderPane border = new BorderPane();
        //border.setPadding(new Insets(20, 0, 20, 20));

        Label label1 = new Label("Please input ");
        //Label label2 = new Label();
        button = new Button();
        button.setMaxWidth(100);
        button.setText("Start");
        button.setOnAction(e -> System.out.println("cool"));

        button2 = new Button();
        button2.setMaxWidth(Double.MAX_VALUE);
        button2.setText("Stop");

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(0, 10, 10, 10));
        //StackPane layout = new StackPane();
        layout.getChildren().addAll(label1, button, button2);
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}