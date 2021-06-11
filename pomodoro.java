import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class pomodoro extends Application{
    Button button;
    Button button2;
    Button button3;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pomodoro Timer");

        Label label1 = new Label("Hello!");
        label1.setStyle("-fx-font-size: 24");
        
        //horizontal buttons, "Work" "Short Break" "Long Break"
        HBox options = new HBox();
        options.setSpacing(10);
        options.setPadding(new Insets(10, 10, 10, 10));


        button = new Button();
        button.setMaxWidth(100);
        button.setText("Work Time");
        button.setAlignment(Pos.CENTER);
        //button.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);

        button2 = new Button();
        button2.setMaxWidth(100);
        button2.setText("Short Break");
        button2.setAlignment(Pos.CENTER);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);

        button3 = new Button();
        button3.setMaxWidth(100);
        button3.setText("Long Break");
        button3.setAlignment(Pos.CENTER);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);
       
        options.getChildren().addAll(button, spacer, button2, button3);
        options.setAlignment(Pos.CENTER);

        // VBox layout = new VBox();
        // layout.setSpacing(10);
        // layout.setPadding(new Insets(0, 10, 10, 10));
        
        
        Scene scene = new Scene(options, 600, 400);
        
        // Scene scene1 = new Scene(layout, 600, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}