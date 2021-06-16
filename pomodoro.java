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
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.layout.StackPane;
import javafx.scene.media.*;

public class pomodoro extends Application{
    Scene scene1, scene2;
    int second = 0;
    int minute = 0;
    int pomoNum = 0;
    String ding1 = "ding-sound-effect_2.mp3";
    boolean paused;
    boolean stopped;
    boolean resetted;
    TextField workInput = new TextField();
    Label instructions = new Label("The Pomodoro Technique is a time management method which typically breaks down work into intervals.\nIt is typically broken down into working for 25 minutes, and taking a 5 minute break. The process repeats until the task is completed.\n\nTo use this program, you can select either to work, or to take a short/long break. Type in the amount of\ntime you'd like to spend for each task and press start to begin.");
    Label pomoCount = new Label("Pomodoro Count: " + pomoNum);
    Timer timer = new Timer();
    Media sound = new Media(new File(ding1).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

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

        VBox grid0 = new VBox(20);
        grid0.setPadding(new Insets(10, 10, 10, 10));

        instructions.setAlignment(Pos.CENTER);

        Button button0 = new Button("Instructions");
        GridPane.setConstraints(button0, 0, 0);
        button0.setOnAction(e -> {
            primaryStage.setScene(scene2);
        });

        Button backButton = new Button("< Back");
        backButton.setOnAction(e -> primaryStage.setScene(scene1));
        
        grid0.getChildren().addAll(backButton, instructions);

        //pomoCount label
        GridPane.setConstraints(pomoCount, 11, 0);

        //horizontal buttons, "Work" "Short Break" "Long Break"
        Button button = new Button("Work Time");
        button.setMaxWidth(100);
        GridPane.setConstraints(button, 9, 4);

        inputBox(workInput);
        workInput.setEditable(false);
        button.setOnAction(e -> {
            stopped = false;
            resetted = false;
            paused = false;
            inputBox(workInput);
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: salmon; -fx-border-color: black; -fx-text-inner-color: white;");
            workInput.setEditable(true);
        });
        //only allow integers to be entered (add it), only let each one go up to 60
        //user cannot edit ":"

        Button button2 = new Button("Short Break");
        button2.setMaxWidth(100);
        GridPane.setConstraints(button2, 10, 4);
        button2.setOnAction(e -> {
            timer.cancel();
            workInput.setEditable(true);
            inputBox(workInput);
            workInput.setText("00 : 00");
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: skyblue; -fx-border-color: black; -fx-text-inner-color: white;");
            
        });
        
        Button button3 = new Button("Long Break");
        button3.setMaxWidth(100);
        GridPane.setConstraints(button3, 11, 4);
        button3.setOnAction(e -> {
            timer.cancel();
            inputBox(workInput);
            workInput.setEditable(true);
            workInput.setText("00 : 00");
            workInput.setStyle("-fx-font-size: 64; -fx-background-color: royalblue; -fx-border-color: black; -fx-text-inner-color: white;");
        });

        grid.getChildren().addAll(button0, pomoCount, button, button2, button3);

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
            resetted = false;
            pomodoroTimer();
            pomoNum++;
            workInput.setEditable(false);
            updatePomo();
        });

        Button button5 = new Button("Pause");
        GridPane.setConstraints(button5, 2, 0);
        button5.setOnAction(e -> {
            //pause the timer
            if (!paused) {
                timer.cancel();
                paused = true;
                button5.setText("Unpause");
            }
            else if (paused) {
                paused = false;
                button5.setText("Pause");
                if (minute <= 0 && second <= 0) {
                    pomodoroTimer();
                }
            }
        });

        Button button6 = new Button("Stop");
        button6.setMaxWidth(300);
        GridPane.setConstraints(button6, 3, 0);
        button6.setOnAction(e -> {
            inputBox(workInput);
            timer.cancel();
            timer.purge();
            stopped = true;
            pomoNum--;
            if (pomoNum < 0) {
                pomoNum = 0;
            }
            updatePomo();
        });

        Button button7 = new Button("Reset");
        button7.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(button7, 30, 0);
        button7.setOnAction(e -> {
            inputBox(workInput);
            timer.cancel();
            timer.purge();
            resetted = true;
            stopped = false;
            paused = false;
            button5.setText("Pause");
            pomoNum = 0;
            updatePomo();
            workInput.setText("00 : 00");
        });

        grid2.getChildren().addAll(button4, button5, button6, button7);


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(grid);
        borderPane.setCenter(options);
        borderPane.setBottom(grid2);
        //borderPane.setLeft(grid0);
        
        scene1 = new Scene(borderPane, 600, 400);
        
        //Layout 2
        // StackPane layout = new StackPane();
        // layout.getChildren().addAll(instructions);
        scene2 = new Scene(grid0, 600, 400);

        primaryStage.setScene(scene1);
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
            int count = (workMin * 60 + (workSec));
            
            @Override
            public void run() {
                if (!stopped) {
                    if (workMin < 0) {
                        workMin = 0;
                    }
                    else if (workSec < 0) {
                        workSec = 0;
                    }
                    count--;
                    setTime(count);
                    if (count == 0) {
                        timer.cancel();
                        mediaPlayer.play();
                    }
                }
                if (stopped ^ resetted ^ paused) {
                    timer.cancel();
                }
                
            }
        }, 0, 1000);
    }

    public void shortTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            String test2 = String.valueOf(workInput.getText());
            String[] shortBreakIn = test2.split(" : ");
            int shortMin = Integer.parseInt(shortBreakIn[0]);
            int shortSec = Integer.parseInt(shortBreakIn[1]);
            int count2 = (shortMin * 60 + (shortSec));
            @Override
            public void run() {
                if (shortMin < 0) {
                    shortMin = 0;
                }
                else if (shortSec < 0) {
                    shortSec = 0;
                }
                count2--;
                setTime(count2);
                if (count2 == 0) {
                    timer.cancel();
                    pomodoroTimer();
                    mediaPlayer.play();
                }
                if (stopped ^ resetted ^ paused) {
                    timer.cancel();
                    pomodoroTimer();
                }
            }
        }, 0, 1000);
    }

    public void longTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            String test3 = String.valueOf(workInput.getText());
            String[] longBreakIn = test3.split(" : ");
            int longMin = Integer.parseInt(longBreakIn[0]);
            int longSec = Integer.parseInt(longBreakIn[1]);
            int count3 = (longMin * 60 + (longSec));
            @Override
            public void run() {
                if (longMin < 0) {
                    longMin = 0;
                }
                else if (longSec < 0) {
                    longSec = 0;
                }
                count3--;
                setTime(count3);
                if (count3 == 0) {
                    timer.cancel();
                    pomodoroTimer();
                    mediaPlayer.play();
                }
                if (stopped ^ resetted ^ paused) {
                    timer.cancel();
                    pomodoroTimer();
                }
                
            }
        }, 0, 1000);
    }

    public void updatePomo() {
        pomoCount.setText("Pomodoro Count: " + pomoNum);
    }
}