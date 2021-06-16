import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class gradecalculator extends Application {
    int slot;
    int counter = 0;
    Label gradesText = new Label("");
    Label gradesText2 = new Label("");
    TextField aimingTextField = new TextField();
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

        Button backButton = new Button("Back to Start");
        backButton.setAlignment(Pos.TOP_LEFT);
        backButton.setPadding(new Insets(10,10,10,10));
        backButton.setPrefHeight(20);

        Button backButton2 = new Button("Back to Start");
        backButton2.setAlignment(Pos.TOP_LEFT);
        backButton2.setPadding(new Insets(10,10,10,10));
        backButton2.setPrefHeight(20);

        Button resetButton = new Button("Info");
        resetButton.setAlignment(Pos.TOP_LEFT);
        resetButton.setPadding(new Insets(10,10,10,10));
        resetButton.setPrefHeight(20);
        
        BorderPane infoPane = new BorderPane();
        BorderPane.setMargin(backButton, new Insets(10, 10, 10, 10));
        infoPane.setTop(backButton);
        BorderPane.setMargin(infoImage, new Insets(10, 10, 10, 10));
        infoPane.setCenter(infoImage);  

        HBox topHBox = new HBox();
        topHBox.setSpacing(440);
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
        
        VBox futureAverageBox = new VBox();
        HBox pPossibleBox = new HBox();
        Label classLabel3 = new Label("");
        classLabel3.setPadding(new Insets(10,10,10,10));
        classLabel3.setStyle("-fx-font-size: 28");
        Label instructions3 = new Label("Enter the points possible for each assignment, click finish when done.");
        instructions3.setStyle("-fx-font-size: 20");
        instructions3.setPadding(new Insets(0,10,10,10));
        TextField possibleTextField3 = new TextField();
        possibleTextField3.setStyle("-fx-font-size: 16");
        possibleTextField3.setPrefSize(60, 40);
        pPossibleBox.getChildren().add(possibleTextField3);
        pPossibleBox.setAlignment(Pos.CENTER);
        Button addButton2 = new Button("Add");
        addButton2.setStyle("-fx-font-size: 18");
        Button finishButton3 = new Button("Finish");
        finishButton3.setStyle("-fx-font-size: 18");
        futureAverageBox.getChildren().addAll(classLabel3, instructions3, pPossibleBox, addButton2, finishButton3);
        futureAverageBox.setSpacing(25);
        futureAverageBox.setAlignment(Pos.CENTER);

        
        VBox averageBox = new VBox();
        Label averageLabel = new Label("Average:");
        averageLabel.setStyle("-fx-font-size: 40");
        Label percentLabel = new Label("");
        percentLabel.setStyle("-fx-font-size: 70");
        Button continueButton = new Button("Continue");
        continueButton.setStyle("-fx-font-size: 20");
        averageBox.getChildren().addAll(averageLabel, percentLabel, continueButton);
        averageBox.setAlignment(Pos.CENTER);

        VBox finalBox = new VBox();
        Label finalBoxLabel = new Label("In order to achieve a - % average in - ,\nyou need to earn - points out of - the points possible.");
        finalBoxLabel.setStyle("-fx-font-size: 45");
        Button completeButton = new Button("Done");
        completeButton.setStyle("-fx-font-size: 20");
        finalBox.getChildren().addAll(finalBoxLabel, completeButton);
        finalBox.setSpacing(10);
        finalBox.setAlignment(Pos.CENTER);

        HBox aimingHBox = new HBox();
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

        VBox editVBox = new VBox();
        Label averageLabel2 = new Label("Average:");
        averageLabel2.setStyle("-fx-font-size: 40");
        Label percentLabel2 = new Label("");
        percentLabel2.setStyle("-fx-font-size: 70");
        Button clearButton = new Button("Reset");
        clearButton.setStyle("-fx-font-size: 20");
        editVBox.getChildren().addAll(averageLabel2, percentLabel2, clearButton);
        editVBox.setAlignment(Pos.CENTER);
        editVBox.setSpacing(10);

        Label select = new Label("Select a slot.\nTE = Total Points Earned\nTP = Total Points Possible");
        select.setStyle("-fx-font-size: 28");
        select.setAlignment(Pos.CENTER);
        
        BorderPane mainPane = new BorderPane();
        BorderPane.setMargin(topHBox, new Insets(10, 10, 10, 10));
        mainPane.setTop(topHBox);  
        BorderPane.setMargin(slotsVBox, new Insets(10, 10, 20, 40));
        BorderPane.setMargin(figureOutVBox, new Insets(10, 100, 10, 10));
        BorderPane.setMargin(gradesText, new Insets(10, 0, 20, 20));
        BorderPane.setMargin(gradesText2, new Insets(10, 0, 20, 20));
        BorderPane.setMargin(averageBox, new Insets(10, 10, 10, 10));
        BorderPane.setMargin(finalBox, new Insets(10, 10, 10, 10));
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
        resetButton.setOnAction(e -> {
            window.setScene(infoScene);
        });
        backButton.setOnAction(e -> {
            window.setScene(scene);
            mainPane.setLeft(slotsVBox);  
            mainPane.setCenter(select);
            earnedPointsArrayList.clear();
            possiblePointsArrayList.clear();
            gradesArrayList.clear();
            possibleArrayList.clear();
            realPossiblePointsArrayList.clear();
        });
        backButton2.setOnAction(e -> {
            window.setScene(scene);
            mainPane.setLeft(slotsVBox);  
            mainPane.setCenter(select);
            earnedPointsArrayList.clear();
            possiblePointsArrayList.clear();
            gradesArrayList.clear();
            possibleArrayList.clear();
            realPossiblePointsArrayList.clear();
        });
        beginButton.setOnAction(e -> {
            window.setScene(mainScene);
        });
        slot1Button.setOnAction(e -> {
            possibleTextField.clear();
            earnedTextField.clear();
            classTextField.setText("Class Name");
            slot = 1;
            mainPane.setCenter(middleVBox);
            if (slot1Button.getText() != "Class 1")
                mainPane.setCenter(editVBox);
        });
        slot2Button.setOnAction(e -> {
            classTextField.setText("Class Name");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 2;
            mainPane.setCenter(middleVBox);
            if (slot2Button.getText() != "Class 2")
                mainPane.setCenter(editVBox);
        });
        slot3Button.setOnAction(e -> {
            classTextField.setText("Class Name");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 3;
            mainPane.setCenter(middleVBox);
            if (slot3Button.getText() != "Class 3")
                mainPane.setCenter(editVBox);
        });
        slot4Button.setOnAction(e -> {
            classTextField.setText("Class Name");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 4;
            mainPane.setCenter(middleVBox);
            if (slot4Button.getText() != "Class 4")
                mainPane.setCenter(editVBox);
        });
        slot5Button.setOnAction(e -> {
            classTextField.setText("Class Name");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 5;
            mainPane.setCenter(middleVBox);
            if (slot5Button.getText() != "Class 5")
                mainPane.setCenter(editVBox);
        });
        slot6Button.setOnAction(e -> {
            classTextField.setText("Class Name");
            possibleTextField.clear();
            earnedTextField.clear();
            slot = 6;
            mainPane.setCenter(middleVBox);
            if (slot6Button.getText() != "Class 6")
                mainPane.setCenter(editVBox);
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

        finishButton2.setOnAction(e -> {
            mainPane.setLeft(null);
            mainPane.setCenter(averageBox);
            double earned = Double.parseDouble(earnedTextField2.getText());
            double possible = Double.parseDouble(possibleTextField2.getText());
            double x = (earned/possible)*100;
            double num = Math.round(x * 100.0) / 100.0;
            percentLabel.setText(num + "%");
        });

        continueButton.setOnAction(e -> {
            mainPane.setCenter(percentAimingBox);
        });

        continueButton2.setOnAction(e -> {
            percent = Double.parseDouble(aimingTextField.getText());
            String classs = classTextField.getText();
            classLabel3.setText(classs);
            if (slot == 1) 
                slot1Button.setText(classs);
            else if (slot == 2)
                slot2Button.setText(classs);
            else if (slot == 3)
                slot3Button.setText(classs);
            else if (slot == 4)
                slot4Button.setText(classs);
            else if (slot == 5)
                slot5Button.setText(classs);
            else 
                slot6Button.setText(classs);
            mainPane.setCenter(futureAverageBox);
        });
        
        clearButton.setOnAction(e -> {
            mainPane.setCenter(middleVBox);
            if (slot == 1) 
                slot1Button.setText("Class 1");
            else if (slot == 2)
                slot2Button.setText("Class 2");
            else if (slot == 3)
                slot3Button.setText("Class 3");
            else if (slot == 4)
                slot4Button.setText("Class 4");
            else if (slot == 5)
                slot5Button.setText("Class 5");
            else 
                slot6Button.setText("Class 6");
        });
        addButton2.setOnAction(e -> {
            mainPane.setLeft(gradesText2);
            addPossibleValues(Double.parseDouble(possibleTextField3.getText()));
            printPossible();
            possibleTextField3.clear();
        });
        finishButton3.setOnAction(e -> {
            mainPane.setLeft(null);
            double total = getTotal();
            double needed = (percent/100)*total;
            double neededRounded = Math.round(needed * 100.0) / 100.0;
            finalBoxLabel.setText("In order to achieve a " + percent + "% average in " + classTextField.getText() + ",\nyou need to earn " + neededRounded + " points out of the " + total + " points possible.");
            mainPane.setCenter(finalBox);
        });
        completeButton.setOnAction(e -> {
            percentLabel2.setText(percentLabel.getText());
            mainPane.setLeft(slotsVBox);
            mainPane.setCenter(select);
            aimingTextField.setText("");
            earnedPointsArrayList.clear();
            possiblePointsArrayList.clear();
            gradesArrayList.clear();
            possibleArrayList.clear();
            realPossiblePointsArrayList.clear();
        });
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
    ArrayList<String> possibleArrayList = new ArrayList<String>();
    ArrayList<Double> realPossiblePointsArrayList = new ArrayList<Double>();
    double percent;
    private void addValues(double earned, double possible) {
        earnedPointsArrayList.add(earned);
        possiblePointsArrayList.add(possible);
    }
    private void addPossibleValues(double parseDouble) {
        realPossiblePointsArrayList.add(parseDouble);
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

    private void printPossible() {
        possibleArrayList.clear();
        String s = "";
        for (int i = 0; i < realPossiblePointsArrayList.size(); i++) {
            possibleArrayList.add("--" + " / " + realPossiblePointsArrayList.get(i));
        }
        for (int i = 0; i < possibleArrayList.size(); i++) {
            s += possibleArrayList.get(i) + "\n";
        }
        gradesText2.setStyle("-fx-font-size: 24");
        gradesText2.setText(s);
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

    private double getTotal() {
        double total = 0;
        for (int i = 0; i < realPossiblePointsArrayList.size(); i++) {
            total += realPossiblePointsArrayList.get(i);
        }
        return total;
    }
    
}