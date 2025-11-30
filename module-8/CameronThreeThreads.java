//Cameron Mendez
//11/30/2025
//Module-8
//CameronThreeThreads.java

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CameronThreeThreads extends Application {

    private static final int COUNT = 10000;

    @Override
    public void start(Stage stage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        BorderPane pane = new BorderPane(textArea);
        Scene scene = new Scene(pane, 600, 400);

        stage.setTitle("Three Threads Output");
        stage.setScene(scene);
        stage.show();

        //start all three threads
        new Thread(new LetterThread(textArea)).start();
        new Thread(new NumberThread(textArea)).start();
        new Thread(new SpecialCharThread(textArea)).start();
    }

    /** Thread #1 – random letters a-z */
    class LetterThread implements Runnable {
        private final TextArea text;

        LetterThread(TextArea t) {
            text = t;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char c = (char) ('a' + Math.random() * 26);

                javafx.application.Platform.runLater(() ->
                    text.appendText(String.valueOf(c))
                );
            }
        }
    }

    /** Thread #2 – random digits 0–9 */
    class NumberThread implements Runnable {
        private final TextArea text;

        NumberThread(TextArea t) {
            text = t;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char c = (char) ('0' + (int)(Math.random() * 10));

                javafx.application.Platform.runLater(() ->
                    text.appendText(String.valueOf(c))
                );
            }
        }
    }

    /** Thread #3 – random special characters */
    class SpecialCharThread implements Runnable {
        private final TextArea text;
        private final char[] specials = {'!', '@', '#', '$', '%', '&', '*'};

        SpecialCharThread(TextArea t) {
            text = t;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char c = specials[(int)(Math.random() * specials.length)];

                javafx.application.Platform.runLater(() ->
                    text.appendText(String.valueOf(c))
                );
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
