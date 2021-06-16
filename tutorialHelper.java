
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;


public class tutorialHelper extends Application {

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7;
    Button button;
    Image image;
    public static void main(String[] args) {
        launch(args);
    }

    @Override 
    public void start (Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tutorial Helper");

        button = new Button("Information");
        button.setOnAction (e -> AlertBox.display("Information", "This tutorial helper helps freshman students find\nuseful tutorials for many subjects and topics which\nthey will take freshman year. Just choose which\nsubject you need help with to find the tutorials\nwhich will help you with your classes."));

        Label label1 = new Label("Welcome to the Tutorial Helper!!");
        Button button1 = new Button("Click to start");
        button1.setOnAction (e -> window.setScene(scene2));

        Label label2 = new Label("Choose which freshman course you need help with :)");
        
        Button button2 = new Button("Go back to main screen");
        button2.setOnAction(e -> window.setScene(scene1));

        Label label3 = new Label("Health Links: \nNutrition:\n-https://www.nccih.nih.gov/health/vitamins-and-minerals#:~:text=A%20number%20of%20minerals%20are,fluoride%2C%20manganese%2C%20and\n%20selenium.\n-https://health.gov/myhealthfinder/topics/health-conditions/heart-health/keep-your-heart-healthy\n-https://www.gaplesinstitute.org/nutrition_course/eating-healthier/?gclid=CjwKCAjw2ZaGBhBoEiwA8pfP_hoW4T5Fh6d7TgM83EbiFbIpetfNb9SeU\ngQ1QxGd4CYzUeOnSgmiDRoClIoQAvD_BwE\n\nMinerals/vitamins:\n-https://www.helpguide.org/harvard/vitamins-and-minerals.htm\n-https://kidshealth.org/en/teens/vitamins-minerals.html\n\nStds:\n-https://www.healthline.com/health/sexually-transmitted-diseases#types\n-https://kidshealth.org/en/teens/std.html\n-https://www.plannedparenthood.org/learn/stds-hiv-safer-sex#:~:text=STDs%20are%20infections%20that%20are,lead%20to%20serious%20health\n%20problems.");
        Button button3 = new Button("Go back to main screen");
        button3.setOnAction(e -> window.setScene(scene1));
        

        Label label4 = new Label("Biology Links: \nCrash Course Videos:\n-https://www.youtube.com/watch?v=QnQe0xW_JY4\n-https://www.youtube.com/watch?v=H8WJ2KENlK0\n-https://www.youtube.com/watch?v=HVT3Y3_gHGg\n-https://www.youtube.com/watch?v=00jbG_cfGuQ\n-https://www.youtube.com/watch?v=H8WJ2KENlK0&list=PL3EED4C1D684D3ADF&index=4\n-https://www.youtube.com/watch?v=cj8dDTHGJBY&list=PL3EED4C1D684D3ADF&index=5\n-https://www.youtube.com/watch?v=dPKvHrD1eS4&list=PL3EED4C1D684D3ADF&index=6\n-https://www.youtube.com/watch?v=9UvlqAVCoqY&list=PL3EED4C1D684D3ADF&index=7\n-https://www.youtube.com/watch?v=sQK3Yr4Sc_k&list=PL3EED4C1D684D3ADF&index=9\n-https://www.youtube.com/watch?v=CBezq1fFUEA&list=PL3EED4C1D684D3ADF&index=10\n-https://www.youtube.com/watch?v=8kK2zwjRV0M&list=PL3EED4C1D684D3ADF&index=11\n-https://www.youtube.com/watch?v=itsb2SqR-R0&list=PL3EED4C1D684D3ADF&index=12");
        Button button4 = new Button("Go back to main screen"); 
        button4.setOnAction(e -> window.setScene(scene1));

        Label label5 = new Label(" History Links: \nRise of Islam:\n-https://www.bbc.co.uk/religion/religions/islam/history/earlyrise_1.shtml#:~:text=The%20early%20rise%20of%20Islam%20(632%2D700)&text\n =The%20military%20conquest%20was%20inspired,motivated%20by%20greed%20and%20politics.&text=But%20this%20mixture%20of%20motives,growing%20religious%20and%20political%20identity.\n-https://www.khanacademy.org/humanities/world-history/medieval-times/spread-of-islam/a/the-rise-of-islamic-empires-and-states\n\n Umayyad and Abbasid:\n-https://courses.lumenlearning.com/boundless-worldhistory/chapter/the-umayyad-and-abbasid-empires/\n-https://www.britannica.com/topic/Umayyad-dynasty-Islamic-history\n\n Ancient China/Mongolia:\n-http://afe.easia.columbia.edu/mongols/china/china.htm\n-https://www.ducksters.com/history/china/yuan_dynasty.php\n-https://www.britannica.com/place/China/The-Yuan-or-Mongol-dynasty\n\n The Renaissance:\n-https://www.sightseeingtoursitaly.com/tips-articles/what-is-the-renaissance-period-known-for/\n-https://courses.lumenlearning.com/boundless-worldhistory/chapter/the-renaissance/");
        Button button5 = new Button("Go back to main screen");
        button5.setOnAction(e -> window.setScene(scene1));

        Label label6 = new Label("Analysis 1 Links: \nGraphing polynomial:\n-https://www.educreations.com/lesson/view/graphing-polynomials-i/57449322/?ref=link\n\nRational Functions:\n-https://www.educreations.com/lesson/view/rational-functions-ii/57864915/?ref=link\n-https://www.educreations.com/lesson/view/rational-functions-ii/57864915/?ref=link\n-https://www.educreations.com/lesson/view/rational-functions-i/57817020/?ref=link\n\nFunction Composition:\n-https://www.educreations.com/lesson/view/function-composition/57387079/?ref=link\n\nFundamental Theorem of algebra: \n-https://www.educreations.com/lesson/view/fundamental-theorem-of-algebra/57773736/?ref=link\n\nRational Roots Theorem: \n-https://www.educreations.com/lesson/view/rational-roots-theorem-i/57691682/?ref=link\n\nLogarithms: \n-https://www.educreations.com/lesson/view/logs/58268874/?ref=link\n\nInverse Functions:\n-https://www.educreations.com/lesson/view/inverse-functions/58195763/?ref=link\n\nSets:\n-https://www.educreations.com/lesson/view/sets-pt-1/56019943/?ref=link\n-https://www.educreations.com/lesson/view/sets-union-and-intersection/56022425/?ref=link\n\nRules of exponents:\n-https://www.educreations.com/lesson/view/rules-of-exponents/56046171/?ref=link");
        Button button6 = new Button("Go back to main screen");
        button6.setOnAction(e -> window.setScene(scene1));

        Label label7 = new Label("Spanish Links: \nBeginning:\n-https://www.youtube.com/watch?v=hyLl_0d0EBw\n\nConjugation:\n-https://www.youtube.com/watch?v=hfWcAgihqVw\n-https://www.youtube.com/watch?v=sIv6-46yeCc\n-https://www.youtube.com/watch?v=hezvnkU5KPY\n-https://www.youtube.com/watch?v=K6SUsWizytA\n\nCommon Phrases:\n-https://www.youtube.com/watch?v=WvnBAQFsmu0\n-https://www.youtube.com/watch?v=FqCifo9GUSE\n-https://www.youtube.com/watch?v=LGMKg6MUdxI\n\nVocabulary:\n-https://www.youtube.com/watch?v=0Odnbvov9N0\n-https://www.youtube.com/watch?v=Wt6u6aicvBM\n-https://www.youtube.com/watch?v=mi7oRyDhBF0\n-https://www.youtube.com/watch?v=gOZFrwTTgok(nouns)\n-https://www.youtube.com/watch?v=6lGEo-KXIuA");
        Button button7 = new Button("Go back to main screen");
        button7.setOnAction(e -> window.setScene(scene1));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll (label1, button1, button);
        scene1 = new Scene (layout1, 800, 600);

        Label label = new Label("Select Desired Course:");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label.setFont(font);

        ComboBox<String> combo = new ComboBox<String>();

        combo.setPromptText("Select a subject");

        ObservableList<String> list = combo.getItems();
        
        list.add("Health");
        list.add("Biology");
        list.add("History");
        list.add("Analysis 1");
        list.add("Spanish 1");
        HBox hbox = new HBox(15);

        hbox.setPadding(new Insets(75, 150, 50, 60));
        hbox.getChildren().addAll(label, combo);

        Scene scene = new Scene(new Group(hbox), 400, 600, Color.WHITE);
        window.setTitle("Subject Selection");
        window.setScene(scene);
        window.show();

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll (label2,combo, button2);
        scene2 = new Scene(layout2, 800, 600);
 
        //problem here
        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll (button3,label3);
        scene3 = new Scene (layout3, 800, 600);
    
        VBox layout4 = new VBox(20);
        layout4.getChildren().addAll (button4,label4);
        scene4 = new Scene (layout4, 800, 600);

        VBox layout5 = new VBox(20);
        layout5.getChildren().addAll (button5,label5);
        scene5= new Scene (layout5, 800, 600);

        VBox layout6 = new VBox(20);
        layout6.getChildren().addAll (button6,label6);
        scene6= new Scene (layout6, 800, 600);

        VBox layout7 = new VBox(20);
        layout7.getChildren().addAll (button7,label7);
        scene7= new Scene (layout7, 800, 600);


        combo.setOnAction(e ->{
            if ((combo.getValue().equals("Health"))) 
                window.setScene(scene3);
            else if ((combo.getValue().equals("Biology"))) 
                window.setScene(scene4);
            else if ((combo.getValue().equals("History"))) 
                window.setScene(scene5);
            else if ((combo.getValue().equals("Analysis 1"))) 
                window.setScene(scene6);
            else if((combo.getValue().equals("Spanish 1"))) 
                window.setScene(scene7);
        });

        layout2.setSpacing(20);
        button3.setAlignment(Pos.BASELINE_CENTER);
        layout2.setAlignment(Pos.CENTER);
        layout1.setAlignment(Pos.CENTER);
        layout3.setAlignment(Pos.CENTER);
        layout4.setAlignment(Pos.CENTER);
        layout5.setAlignment(Pos.CENTER);
        layout6.setAlignment(Pos.CENTER);
        layout7.setAlignment(Pos.CENTER);
        
    

        window.setScene(scene1);
        window.show();
    }
}

