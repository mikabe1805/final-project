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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
// import javax.swing.Timer;
//import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class pomodoro extends Application{
    int second = 0;
    int minute = 0;
    String ddMinute, ddSecond;
    DecimalFormat dFormat = new DecimalFormat("00");
    TextField workInput = new TextField();
    Timer timer = new Timer();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pomodoro Timer");

        pomodoro ttt = new pomodoro();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        
        //horizontal buttons, "Work" "Short Break" "Long Break"
        Button button = new Button("Work Time");
        button.setMaxWidth(100);
        GridPane.setConstraints(button, 16, 5);

        //TextField workInput = new TextField();
        inputBox(workInput);
        workInput.setEditable(false);
        button.setOnAction(e -> {
            inputBox(workInput);
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: salmon; -fx-border-color: black; -fx-text-inner-color: white;");
            workInput.setEditable(true);
            //ttt.start();
        });
        //only allow integers to be entered (add it), only let each one go up to 60
        //user cannot edit ":"

        // String test = String.valueOf(workInput.getText());
        // String[] workTimeIn = test.split(" : ");
        // int workMin = Integer.parseInt(workTimeIn[0]);
        // int workSec = Integer.parseInt(workTimeIn[1]);

        Button button2 = new Button("Short Break");
        button2.setMaxWidth(100);
        GridPane.setConstraints(button2, 17, 5);
        button2.setOnAction(e -> {
            inputBox(workInput);
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: skyblue; -fx-border-color: black; -fx-text-inner-color: white;");
        });

        String test2 = String.valueOf(workInput.getText());
        String[] shortBreakIn = test2.split(" : ");
        int shortMin = Integer.parseInt(shortBreakIn[0]);
        int shortSec = Integer.parseInt(shortBreakIn[1]);

        Button button3 = new Button("Long Break");
        button3.setMaxWidth(100);
        GridPane.setConstraints(button3, 18, 5);
        button3.setOnAction(e -> {
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: royalblue; -fx-border-color: black; -fx-text-inner-color: white;");
        });
        String test3 = String.valueOf(workInput.getText());
        String[] longBreakIn = test2.split(" : ");
        int longMin = Integer.parseInt(longBreakIn[0]);
        int longSec = Integer.parseInt(longBreakIn[1]);

        grid.getChildren().addAll(button, button2, button3);

        // input boxes
        HBox options = new HBox();
        options.setSpacing(10);
        options.setPadding(new Insets(50, 150, 50, 170));

        options.getChildren().addAll(workInput);

        //start + stop + reset buttons
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(10);
        grid2.setHgap(10);


        Button button4 = new Button("Start");
        button4.setMaxWidth(100);
        GridPane.setConstraints(button4, 0, 0);
        button4.setOnAction(e -> {
            //timer(workInput, workMin, workSec, ttt);
            //ttt.start();
            pomodoroTimer();
            workInput.setEditable(false);
        });

        Button button5 = new Button("Pause");
        //

        Button button6 = new Button("Stop");
        button6.setMaxWidth(100);
        GridPane.setConstraints(button6, 1, 0);

        Button button7 = new Button();
        button7.setMaxWidth(100);
        button7.setText("Reset");
        GridPane.setConstraints(button7, 43, 0);

        grid2.getChildren().addAll(button4, button5, button6);


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(grid);
        borderPane.setCenter(options);
        borderPane.setBottom(grid2);
        
        Scene scene = new Scene(borderPane, 600, 400);
        
        // Scene scene1 = new Scene(layout, 600, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void inputBox (TextField inputt) {
        inputt.setMaxWidth(500);
        inputt.setStyle("-fx-font-size: 64; -fx-border-color: black;");
        inputt.setText("00:00");
        inputt.setAlignment(Pos.CENTER);
    }

    public void timer (TextField inputt, int minutes, int seconds, pomodoro tt) {

        for (int i = seconds; i <= 0; i++) {
            inputt.setText("" + seconds);
            //tt.start();
        }

        for (int i = minutes; i <= 0; i++) {
            inputt.setText("" + minutes);
        }
        //FIGURE OUT how to only move through the loop if a second/minute passes

    }

    public void updateText(TextField okay, int minutes, int seconds) {
        okay.setText(minutes + " : " + seconds);
    }

    public void setTime(int time) //function to display timer
    {
        long timeNow = 1000*time;
        long second = (timeNow / 1000) % 60;
        long minute = (timeNow / (1000 * 60)) % 60;
        //long hour = (timeNow / (1000 * 60 * 60)) % 24;
        workInput.setText(String.format("%02d:%02d", minute, second));
    }

    public void pomodoroTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = 0;
            String test = String.valueOf(workInput.getText());
            String[] workTimeIn = test.split(" : ");
            int workMin = Integer.parseInt(workTimeIn[0]);
            int workSec = Integer.parseInt(workTimeIn[1]);
            int counterLimit = (workMin * 60 + (workSec *60));
            @Override
            public void run() {
                count++;
                setTime(count);
                if (count == counterLimit) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
}