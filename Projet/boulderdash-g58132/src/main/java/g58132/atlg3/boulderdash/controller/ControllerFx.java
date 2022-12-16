package g58132.atlg3.boulderdash.controller;

import g58132.atlg3.boulderdash.javaFx.CaveView;
import g58132.atlg3.boulderdash.javaFx.LevelView;
import g58132.atlg3.boulderdash.javaFx.MenuView;
import g58132.atlg3.boulderdash.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFx extends Application {
    private BoulderDash game;
    private Stage stage;




    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
        game = new BoulderDash(new LevelReader());
        stage.setTitle("BoulderDash!");
        MenuView menuView = new MenuView();
        Scene scene = new Scene(menuView, 1000, 1000);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    LevelView levelView = new LevelView(game,stage);
                    Scene scene1=new Scene(levelView,1000,1000);
                    stage.setScene(scene1);

            }
        });


        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}