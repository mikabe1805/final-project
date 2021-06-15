import java.util.Timer;
import java.util.TimerTask;

//import javax.swing.JFrame;
//import javax.swing.JLabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class pomodoro2 extends Application{
    Stage window;
    Scene scene;
    Scene frame1;
    Button button;

    TextField textt;
    //JLabel label;

    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start (Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Pomodoro Timer");

        Label instructions = new Label("The Pomodoro method");

        button = new Button("Click me!");
        button.setOnAction(e -> window.setScene(frame1));

        setTime(30);


        StackPane layout = new StackPane();
        layout.getChildren().addAll(instructions, button);

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(textt);
        scene = new Scene(layout, 500, 500);
        frame1 = new Scene(layout2, 500, 500);
        window.setScene(scene);
        window.show();
    }

    public void setTime(int time) //function to display timer
    {
        long timeNow = 1000*time;
        long second = (timeNow / 1000) % 60;
        long minute = (timeNow / (1000 * 60)) % 60;
        long hour = (timeNow / (1000 * 60 * 60)) % 24;
        textt.setText(String.format("%02d:%02d:%02d", hour, minute, second));
    }

    public void pomodoroTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                count++;
                setTime(count);
            }
        }, 0, 1000);
    }
}
