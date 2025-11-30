//Cameron Mendez
//11/30/2025
//Module-7
//CircleStylesDemo.java


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStylesDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        //create circles
        Circle c1 = new Circle(50);
        c1.getStyleClass().add("plaincircle");

        Circle c2 = new Circle(50);
        c2.setId("redcircle");

        Circle c3 = new Circle(50);
        c3.setId("greencircle");

        Circle c4 = new Circle(50);
        c4.getStyleClass().add("plaincircle");
        c4.getStyleClass().add("circleborder"); //dashed border example

        //layout
        GridPane pane = new GridPane();
        pane.setHgap(20);
        pane.setVgap(20);
        pane.add(c1, 0, 0);
        pane.add(c2, 1, 0);
        pane.add(c3, 0, 1);
        pane.add(c4, 1, 1);
        pane.getStyleClass().add("border"); //add outer border

        //scene
        Scene scene = new Scene(pane, 350, 300);

        //load CSS
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("Circle Style Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
