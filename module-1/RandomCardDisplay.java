//Cameron Mendez
//Module One
//JavaFX Random Card Display

//Troubleshooting: Compile and run using alt path to SDK location

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class RandomCardDisplay extends Application {

    private static final int NUM_CARDS = 52;  	//Total number of cards in deck
    private static final int DISPLAY_COUNT = 4; //Cards to display each time
    private final String CARD_PATH = "cards"; 	//Folder where card images are stored

    private HBox cardBox = new HBox(10); 	//Holds card images

    @Override
    public void start(Stage primaryStage) {
        cardBox.setAlignment(Pos.CENTER);

        //Initial display
        displayRandomCards();

        //Refresh button
        Button refreshButton = new Button("Refresh Cards");
        refreshButton.setOnAction(e -> displayRandomCards()); //Lambda expression

        //Layout
        BorderPane pane = new BorderPane();
        pane.setCenter(cardBox);
        pane.setBottom(refreshButton);
        BorderPane.setAlignment(refreshButton, Pos.CENTER);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        cardBox.getChildren().clear();

        //Create and shuffle deck
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= NUM_CARDS; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);

        //Select first 4 cards
        for (int i = 0; i < DISPLAY_COUNT; i++) {
            String fileName = CARD_PATH + "/" + deck.get(i) + ".png";
            File file = new File(fileName);

            if (file.exists()) {
                Image cardImage = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(cardImage);
                imageView.setFitHeight(150);
                imageView.setFitWidth(100);
                imageView.setPreserveRatio(true);
                cardBox.getChildren().add(imageView);
            } else {
                System.out.println("Missing file: " + fileName);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
