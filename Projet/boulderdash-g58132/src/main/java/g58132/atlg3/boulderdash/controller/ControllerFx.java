package g58132.atlg3.boulderdash.controller;

import g58132.atlg3.boulderdash.javaFxView.MenuView;
import g58132.atlg3.boulderdash.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFx extends Application {
    private BoulderDash game;
    private Stage stage;


    /**
     * allows to control the game on javaFx
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        game = new BoulderDash(new LevelReader());
        stage.setTitle("BoulderDash!");
        MenuView menuView = new MenuView(game, stage);
        Scene scene = new Scene(menuView, 1000, 1000);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}