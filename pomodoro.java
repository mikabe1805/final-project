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
//import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class pomodoro extends Application{
    int second = 0;
    int minute = 0;
    boolean paused;
    boolean stopped;
    TextField workInput = new TextField();
    Timer timer = new Timer();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pomodoro Timer");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        
        //horizontal buttons, "Work" "Short Break" "Long Break"
        Button button = new Button("Work Time");
        button.setMaxWidth(100);
        GridPane.setConstraints(button, 16, 5);

        inputBox(workInput);
        workInput.setEditable(false);
        button.setOnAction(e -> {
            inputBox(workInput);
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: salmon; -fx-border-color: black; -fx-text-inner-color: white;");
            workInput.setEditable(true);
        });
        //only allow integers to be entered (add it), only let each one go up to 60
        //user cannot edit ":"

        Button button2 = new Button("Short Break");
        button2.setMaxWidth(100);
        GridPane.setConstraints(button2, 17, 5);
        button2.setOnAction(e -> {
            timer.cancel();
            workInput.setEditable(true);
            inputBox(workInput);
            workInput.setText("00 : 00");
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: skyblue; -fx-border-color: black; -fx-text-inner-color: white;");
            
        });
        
        Button button3 = new Button("Long Break");
        button3.setMaxWidth(100);
        GridPane.setConstraints(button3, 18, 5);
        button3.setOnAction(e -> {
            timer.cancel();
            inputBox(workInput);
            workInput.setEditable(true);
            workInput.setText("00 : 00");
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: royalblue; -fx-border-color: black; -fx-text-inner-color: white;");
        });

        grid.getChildren().addAll(button, button2, button3);

        // input boxes
        HBox options = new HBox();
        options.setSpacing(10);
        options.setPadding(new Insets(50, 150, 50, 170));

        options.getChildren().addAll(workInput);

        //start + stop + pause/unpause + reset buttons
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(10);
        grid2.setHgap(10);


        Button button4 = new Button("Start");
        GridPane.setConstraints(button4, 0, 0);
        button4.setOnAction(e -> {
            stopped = false;
            pomodoroTimer();
            workInput.setEditable(false);
            if (minute == 0 && second == 0) {
                System.out.println("where did i go wrong-");
            }
        });

        // Button button5 = new Button("Pause");
        // GridPane.setConstraints(button5, 1, 0);
        // button5.setOnAction(e -> {
        //     //pause the timer
        //     if (!paused) {
        //         paused = true;
        //         button5.setText("Unpause");
        //     }
        //     else if (paused) {
        //         paused = false;
        //         button5.setText("Pause");
        //     }
        // });

        Button button6 = new Button("Stop");
        button6.setMaxWidth(300);
        GridPane.setConstraints(button6, 2, 0);
        button6.setOnAction(e -> {
            inputBox(workInput);
            timer.cancel();
            timer.purge();
            stopped = true;
        });

        Button button7 = new Button("Reset");
        button7.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(button7, 39, 0);
        button7.setOnAction(e -> {
            timer.cancel();
            workInput.setText("00:00");
        });

        grid2.getChildren().addAll(button4, button6, button7);


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(grid);
        borderPane.setCenter(options);
        borderPane.setBottom(grid2);
        
        Scene scene = new Scene(borderPane, 600, 400);
                
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void inputBox (TextField inputt) {
        inputt.setMaxWidth(500);
        inputt.setStyle("-fx-font-size: 64; -fx-border-color: black;");
        inputt.setText("00 : 00");
        inputt.setAlignment(Pos.CENTER);
    }

    public void setTime(int time) {
        long huhh = 1000 * time;
        long second = (huhh / 1000) % 60;
        long minute = (huhh / (1000 * 60)) % 60;
        workInput.setText(String.format("%02d : %02d", minute, second));
        if (minute < 0) {
            minute = 0;
        }
        if (second < 0) {
            second = 0;
        }
    }

    public void pomodoroTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            String test = String.valueOf(workInput.getText());
            String[] workTimeIn = test.split(" : ");
            int workMin = Integer.parseInt(workTimeIn[0]);
            int workSec = Integer.parseInt(workTimeIn[1]);
            int counterLimit = (workMin * 60 + (workSec));
            
            @Override
            public void run() {
                if (!stopped) {
                    if (workMin < 0) {
                        workMin = 0;
                    }
                    else if (workSec < 0) {
                        workSec = 0;
                    }
                    counterLimit--;
                    setTime(counterLimit);
                    if (counterLimit == 0) {
                        timer.cancel();
                    }
                }
                if (stopped) {
                    timer.cancel();
                }

                
            }
        }, 1000, 1000);
    }

    public void shortTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            String test2 = String.valueOf(workInput.getText());
            String[] shortBreakIn = test2.split(" : ");
            int shortMin = Integer.parseInt(shortBreakIn[0]);
            int shortSec = Integer.parseInt(shortBreakIn[1]);
            int counterLimit2 = (shortMin * 60 + (shortSec));
            @Override
            public void run() {
                if (shortMin < 0) {
                    shortMin = 0;
                }
                else if (shortSec < 0) {
                    shortSec = 0;
                }
                counterLimit2--;
                setTime(counterLimit2);
                if (counterLimit2 == 0) {
                    timer.cancel();
                    pomodoroTimer();
                }
                if (stopped) {
                    timer.cancel();
                    pomodoroTimer();
                }
            }
        }, 1000, 1000);
    }

    public void longTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            String test3 = String.valueOf(workInput.getText());
            String[] longBreakIn = test3.split(" : ");
            int longMin = Integer.parseInt(longBreakIn[0]);
            int longSec = Integer.parseInt(longBreakIn[1]);
            int counterLimit3 = (longMin * 60 + (longSec));
            @Override
            public void run() {
                if (longMin < 0) {
                    longMin = 0;
                }
                else if (longSec < 0) {
                    longSec = 0;
                }
                counterLimit3--;
                setTime(counterLimit3);
                if (counterLimit3 == 0) {
                    timer.cancel();
                    pomodoroTimer();
                }
                
            }
        }, 0, 1000);
    }
}