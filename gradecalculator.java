import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class gradecalculator extends Application {
    int slot;
    int counter = 0;
    Label gradesText = new Label("");
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Grade Calculator");
        Image info = new Image(new FileInputStream("calcImages/info.png"));
        ImageView infoImageView = new ImageView();
        infoImageView.setX(50); 
        infoImageView.setY(25); 
        infoImageView.setFitHeight(800); 
        infoImageView.setFitWidth(800); 
        infoImageView.setPreserveRatio(true);  
        Group infoImage = new Group(infoImageView);
        infoImageView.setImage(info);

        HBox buttonsHBox = new HBox();
        buttonsHBox.setSpacing(10);
        Button beginButton = new Button("Begin");
        beginButton.setPrefSize(80, 30);
        beginButton.setStyle("-fx-font-size: 18");
        Button infoButton = new Button("Info");
        infoButton.setPrefSize(80, 30);
        infoButton.setStyle("-fx-font-size: 18");
        buttonsHBox.getChildren().addAll(beginButton, infoButton);
        buttonsHBox.setAlignment(Pos.CENTER);

        VBox startMenu = new VBox();
        Label title = new Label("Grade Calculator");
        title.setStyle("-fx-font-size: 30");
        Label title1 = new Label("Grade Calculator");
        title1.setStyle("-fx-font-size: 35");
        Text welcome = new Text("Welcome to the Grade Calculator!");
        welcome.setStyle("-fx-font-size: 24");
        startMenu.setSpacing(20);
        startMenu.getChildren().addAll(title1, welcome, buttonsHBox);
        startMenu.setAlignment(Pos.CENTER);      

        Button backButton = new Button("Back");
        backButton.setAlignment(Pos.TOP_LEFT);
        backButton.setPadding(new Insets(10,10,10,10));
        backButton.setPrefHeight(20);

        Button backButton2 = new Button("Back");
        backButton2.setAlignment(Pos.TOP_LEFT);
        backButton2.setPadding(new Insets(10,10,10,10));
        backButton2.setPrefHeight(20);

        Button resetButton = new Button("Reset");
        resetButton.setAlignment(Pos.TOP_LEFT);
        resetButton.setPadding(new Insets(10,10,10,10));
        resetButton.setPrefHeight(20);
        
        BorderPane infoPane = new BorderPane();
        BorderPane.setMargin(backButton, new Insets(10, 10, 10, 10));
        infoPane.setTop(backButton);
        BorderPane.setMargin(infoImage, new Insets(10, 10, 10, 10));
        infoPane.setCenter(infoImage);  

        HBox topHBox = new HBox();
        topHBox.setSpacing(460);
        topHBox.setAlignment(Pos.CENTER);
        topHBox.getChildren().addAll(backButton2, title, resetButton);

        Button slot1Button = new Button("Class 1");
        Button slot2Button = new Button("Class 2");
        Button slot3Button = new Button("Class 3");
        Button slot4Button = new Button("Class 4");
        Button slot5Button = new Button("Class 5");
        Button slot6Button = new Button("Class 6");
        slot1Button.setStyle("-fx-font-size: 18");
        slot2Button.setStyle("-fx-font-size: 18");
        slot3Button.setStyle("-fx-font-size: 18");
        slot4Button.setStyle("-fx-font-size: 18");
        slot5Button.setStyle("-fx-font-size: 18");
        slot6Button.setStyle("-fx-font-size: 18");

        Label classesLabel = new Label("Classes:");
        classesLabel.setStyle("-fx-font-size: 20");
        
        VBox slotsVBox = new VBox(); 
        slotsVBox.setSpacing(30);
        slotsVBox.setAlignment(Pos.CENTER);
        slotsVBox.getChildren().addAll(classesLabel, slot1Button, slot2Button, slot3Button, slot4Button, slot5Button, slot6Button);

        HBox enterClass = new HBox();
        TextField classTextField = new TextField();
        classTextField.setStyle("-fx-font-size: 16");
        Label nameOfClass = new Label("Name of class:");
        nameOfClass.setStyle("-fx-font-size: 18");
        enterClass.getChildren().addAll(nameOfClass, classTextField);
        enterClass.setSpacing(5);
        enterClass.setAlignment(Pos.CENTER);

        VBox mainButtons = new VBox();
        Button figureOut = new Button("Figure out TE/TP");
        figureOut.setStyle("-fx-font-size: 16");
        Button enterPoints = new Button("Enter TE/TP");
        enterPoints.setStyle("-fx-font-size: 16");
        mainButtons.getChildren().addAll(figureOut, enterPoints);
        mainButtons.setSpacing(10);
        mainButtons.setAlignment(Pos.CENTER);

        VBox middleVBox = new VBox();
        middleVBox.setSpacing(20);
        middleVBox.setAlignment(Pos.CENTER);
        middleVBox.getChildren().addAll(enterClass, mainButtons);
        
        HBox TEoverTPVBox2 = new HBox();
        TextField earnedTextField2 = new TextField();
        earnedTextField2.setStyle("-fx-font-size: 16");
        earnedTextField2.setPrefSize(60, 40);
        TextField possibleTextField2 = new TextField();
        possibleTextField2.setStyle("-fx-font-size: 16");
        possibleTextField2.setPrefSize(60, 40);
        Label slash2 = new Label("/");
        slash2.setStyle("-fx-font-size: 24");
        TEoverTPVBox2.getChildren().addAll(earnedTextField2, slash2, possibleTextField2);
        TEoverTPVBox2.setAlignment(Pos.CENTER);
        TEoverTPVBox2.setSpacing(10);

        VBox enterPointsVBox = new VBox();
        Label classLabel2 = new Label("");
        classLabel2.setPadding(new Insets(10,10,10,10));
        classLabel2.setStyle("-fx-font-size: 28");
        Label instructions2 = new Label("Enter your TE/TP.");
        instructions2.setStyle("-fx-font-size: 20");
        instructions2.setPadding(new Insets(0,10,10,10));
        Button finishButton2 = new Button("Next");
        finishButton2.setStyle("-fx-font-size: 18");
        enterPointsVBox.setSpacing(10);
        enterPointsVBox.setAlignment(Pos.CENTER);
        enterPointsVBox.getChildren().addAll(classLabel2, instructions2, TEoverTPVBox2, finishButton2);

        VBox figureOutVBox = new VBox();
        HBox TEoverTPHBox = new HBox();
        HBox nav = new HBox();
        Label classLabel = new Label("");
        classLabel.setPadding(new Insets(10,10,10,10));
        classLabel.setStyle("-fx-font-size: 28");
        Label instructions1 = new Label("Enter your score for each assignment, click finish when done.");
        instructions1.setStyle("-fx-font-size: 20");
        instructions1.setPadding(new Insets(0,10,10,10));
        Button finishButton = new Button("Finish");
        finishButton.setStyle("-fx-font-size: 18");
        TextField earnedTextField = new TextField();
        earnedTextField.setStyle("-fx-font-size: 16");
        earnedTextField.setPrefSize(60, 40);
        TextField possibleTextField = new TextField();
        possibleTextField.setStyle("-fx-font-size: 16");
        possibleTextField.setPrefSize(60, 40);
        Label slash = new Label("/");
        slash.setStyle("-fx-font-size: 24");
        TEoverTPHBox.getChildren().addAll(earnedTextField, slash, possibleTextField);
        TEoverTPHBox.setAlignment(Pos.CENTER);
        TEoverTPHBox.setSpacing(10);
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font-size: 18");
        nav.getChildren().addAll(addButton);
        nav.setSpacing(20);
        nav.setAlignment(Pos.CENTER);
        figureOutVBox.getChildren().addAll(classLabel, instructions1, TEoverTPHBox, nav, finishButton);
        figureOutVBox.setSpacing(25);
        figureOutVBox.setAlignment(Pos.CENTER);

        VBox averageBox = new VBox();
        Label averageLabel = new Label("Average:");
        averageLabel.setStyle("-fx-font-size: 40");
        Label percentLabel = new Label("");
        percentLabel.setStyle("-fx-font-size: 70");
        Button continueButton = new Button("Continue");
        continueButton.setStyle("-fx-font-size: 20");
        averageBox.getChildren().addAll(averageLabel, percentLabel, continueButton);
        averageBox.setAlignment(Pos.CENTER);

        HBox aimingHBox = new HBox();
        TextField aimingTextField = new TextField();
        aimingTextField.setStyle("-fx-font-size: 20");
        aimingTextField.setPrefSize(80, 40);
        Label percentSign = new Label("%");
        percentSign.setStyle("-fx-font-size: 50");
        aimingHBox.getChildren().addAll(aimingTextField, percentSign);
        aimingHBox.setSpacing(10);
        aimingHBox.setAlignment(Pos.CENTER);

        VBox percentAimingBox = new VBox();
        Label percentAimingLabel = new Label("What percent are you aiming for?");
        percentAimingLabel.setStyle("-fx-font-size: 40");
        Button continueButton2 = new Button("Continue");
        continueButton2.setStyle("-fx-font-size: 20");
        percentAimingBox.getChildren().addAll(percentAimingLabel, aimingHBox, continueButton2);
        percentAimingBox.setAlignment(Pos.CENTER);
        percentAimingBox.setSpacing(25);

        Label select = new Label("Select a slot.\nTE = Total Points Earned\nTP = Total Points Possible");
        select.setStyle("-fx-font-size: 28");
        select.setAlignment(Pos.CENTER);
        
        BorderPane mainPane = new BorderPane();
        BorderPane.setMargin(topHBox, new Insets(10, 10, 10, 10));
        mainPane.setTop(topHBox);  
        BorderPane.setMargin(slotsVBox, new Insets(10, 10, 20, 40));
        BorderPane.setMargin(figureOutVBox, new Insets(10, 100, 10, 10));
        BorderPane.setMargin(gradesText, new Insets(10, 0, 20, 20));
        BorderPane.setMargin(averageBox, new Insets(10, 10, 10, 10));
        mainPane.setLeft(slotsVBox);  
        BorderPane.setMargin(middleVBox, new Insets(10, 70, 10, 10));
        BorderPane.setMargin(select, new Insets(10, 70, 10, 10));
        mainPane.setCenter(select);
        
        // ScrollPane sp = new ScrollPane();
        // sp.setContent(slotsVBox);
        // sp.setPrefWidth(150);
        
        Scene scene = new Scene(startMenu, 1280, 1000);
        Scene infoScene = new Scene(infoPane, 1280, 1000);
        Scene mainScene = new Scene(mainPane, 1280, 1000);
        // reset scene: "click slot to reset." slots listed in a columun and then confirmation box when reseting
        window.setScene(scene);
        window.show();

        infoButton.setOnAction(e -> {
            window.setScene(infoScene);
        });
        backButton.setOnAction(e -> {
            window.setScene(scene);
        });
        backButton2.setOnAction(e -> {
            window.setScene(scene);
            mainPane.setLeft(slotsVBox);  
            mainPane.setCenter(select);
        });
        beginButton.setOnAction(e -> {
            window.setScene(mainScene);
        });
        slot1Button.setOnAction(e -> {
            possibleTextField.clear();
            earnedTextField.clear();
            classTextField.setText("Class 1");
            slot = 1;
            mainPane.setCenter(middleVBox);
        });
        slot2Button.setOnAction(e -> {
            classTextField.setText("Class 2");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 2;
            mainPane.setCenter(middleVBox);
        });
        slot3Button.setOnAction(e -> {
            classTextField.setText("Class 3");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 3;
            mainPane.setCenter(middleVBox);
        });
        slot4Button.setOnAction(e -> {
            classTextField.setText("Class 4");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 4;
            mainPane.setCenter(middleVBox);
        });
        slot5Button.setOnAction(e -> {
            classTextField.setText("Class 5");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 5;
            mainPane.setCenter(middleVBox);
        });
        slot6Button.setOnAction(e -> {
            classTextField.setText("Class 6");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 6;
            mainPane.setCenter(middleVBox);
        });
        figureOut.setOnAction(e -> {
            String classs = classTextField.getText();
            if (classs.length() < 1)
                classs = "Class " + slot;
            classLabel.setText(classs);
            mainPane.setLeft(null);
            mainPane.setCenter(figureOutVBox);
        });
        enterPoints.setOnAction(e -> {
            String classs = classTextField.getText();
            if (classs.length() < 1)
                classs = "Class " + slot;
            classLabel2.setText(classs);
            mainPane.setLeft(null);
            mainPane.setCenter(enterPointsVBox);
        });

        finishButton.setOnAction(e -> {
            mainPane.setLeft(null);
            mainPane.setCenter(averageBox);
            percentLabel.setText(getAverage()+"%");
        });

        continueButton.setOnAction(e -> {
            mainPane.setCenter(percentAimingBox);
        });

        // continueButton2.setOnAction(e -> {
        //     mainPane.setCenter(futureAverageBox);
        // });

        addButton.setOnAction(e -> {
            if (earnedIsValid(earnedTextField) && posIsValid(possibleTextField)) {
                instructions1.setText("Enter your score for each assignment, click finish when done.");
                    addValues(Double.parseDouble(earnedTextField.getText()), Double.parseDouble(possibleTextField.getText()));
                    printGrades();
                    mainPane.setLeft(gradesText);
                    possibleTextField.clear();
                    earnedTextField.clear();
                }
            else if (!earnedIsValid(earnedTextField) || !posIsValid(possibleTextField)) {
                instructions1.setText("Invalid values.");
                if (earnedPointsArrayList.size() == 0)
                    instructions1.setText("Enter your score for each assignment, click finish when done.");
            }
        });
    }

    private boolean earnedIsValid(TextField input) {
        try {
            double num = Double.parseDouble(input.getText());
            if (num < 0) 
                return false;
            else 
                return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }

    private boolean posIsValid(TextField input) {
        try {
            double num = Double.parseDouble(input.getText());
            if (num < 1) 
                return false;
            else 
                return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }

    ArrayList<Double> earnedPointsArrayList = new ArrayList<Double>();
    ArrayList<Double> possiblePointsArrayList = new ArrayList<Double>();
    ArrayList<String> gradesArrayList = new ArrayList<String>();
    // string array list
    // use for loop to add it to a string and then make the set text the string

    private void addValues(double earned, double possible) {
        earnedPointsArrayList.add(earned);
        possiblePointsArrayList.add(possible);
    }

    private void showPrevious(TextField possibleField, TextField earnedField, int previousPos) {
        possibleField.setText("" + possiblePointsArrayList.get(previousPos));
        earnedField.setText("" + earnedPointsArrayList.get(previousPos));
    }

    private void showNext(TextField possibleField, TextField earnedField, int nextPos) {
        possibleField.setText("" + possiblePointsArrayList.get(nextPos));
        earnedField.setText("" + earnedPointsArrayList.get(nextPos));
    }

    private void printGrades() {
        gradesArrayList.clear();
        String s = "";
        for (int i = 0; i < possiblePointsArrayList.size(); i++) {
            gradesArrayList.add(earnedPointsArrayList.get(i) + "/" + possiblePointsArrayList.get(i) + " = " + (Math.round((earnedPointsArrayList.get(i)/possiblePointsArrayList.get(i))*100 * 100.0) / 100.0) + "%");
        }
        for (int i = 0; i < gradesArrayList.size(); i++) {
            s += gradesArrayList.get(i) + "\n";
        }
        gradesText.setStyle("-fx-font-size: 24");
        gradesText.setText(s);
    }

    private double getAverage() {
        double possiblePointsTotal = 0;
        double earnedPointsTotal = 0;
        for (int i = 0; i < possiblePointsArrayList.size(); i++) {
            possiblePointsTotal+=possiblePointsArrayList.get(i);
            earnedPointsTotal+=earnedPointsArrayList.get(i);
        }
        return (Math.round((earnedPointsTotal/possiblePointsTotal)*100 * 100.0) / 100.0);
    }
    
}