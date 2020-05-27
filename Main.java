package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        GUI gui = new GUI();

        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(450);
        scene = new Scene(gui.getLayout(0), 450, 500);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
