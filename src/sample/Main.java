package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private World world = new World(25, 25);

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(world.getWorldUI(), 25 * (Cell.SIZE +  1), 25 * (Cell.SIZE + 1));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
