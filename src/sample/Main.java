package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Game game = new Game();


    @Override
    public void start(Stage primaryStage) {
        game.initWorld();
        Scene scene = new Scene(game.getWorld().getWorldUI(), Game.BOARDSIZE * (Cell.SIZE + 1),
                Game.BOARDSIZE * (Cell.SIZE + 1));

        scene.setOnMouseClicked(mouseEvent -> game.update());

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
