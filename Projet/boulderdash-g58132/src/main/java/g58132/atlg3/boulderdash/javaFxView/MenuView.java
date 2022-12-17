package g58132.atlg3.boulderdash.javaFxView;

import g58132.atlg3.boulderdash.model.BoulderDash;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView extends GridPane {
    private BoulderDash game;
    private Stage stage;

    /**
     * Constructor of the menuView
     *
     * @param game  is a facade of the game
     * @param stage is a scene of the theatre, this is
     *              the physical location where your application will be displayed
     */
    public MenuView(BoulderDash game, Stage stage) {
        this.game = game;
        this.stage = stage;
        menu();
    }

    private void menu() {
        BorderPane borderPane = new BorderPane();
        var image = new ImageView();
        image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/menu.png"));
        image.setFitWidth(1000);
        image.setFitHeight(800);
        HBox hboxImage = new HBox();
        hboxImage.getChildren().add(image);
        VBox hBoxTexte = new VBox();
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("MENU");
        MenuItem start = new MenuItem("start");
        menuFile.getItems().addAll(start);
        MenuItem exit = new MenuItem("exit");
        menuFile.getItems().addAll(exit);
        menuBar.getMenus().addAll(menuFile);
        hBoxTexte.getChildren().addAll(menuBar);
        hBoxTexte.setSpacing(40);
        borderPane.getChildren().addAll(hboxImage, hBoxTexte);
        borderPane.setCenter(image);
        borderPane.setTop(menuBar);

        this.getChildren().add(borderPane);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color:black");
        start.setOnAction(actionEvent -> {
            LevelView levelView = new LevelView(game, stage);
            Scene scene1 = new Scene(levelView, 1000, 1000);
            stage.setScene(scene1);
        });
        exit.setOnAction(actionEvent -> {
            stage.close();
        });


    }
}