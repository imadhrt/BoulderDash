package g58132.atlg3.boulderdash.javaFx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.LinkedHashSet;

public class MenuView extends GridPane {

    public MenuView() {
        menu();
    }

    public void menu() {
        BorderPane borderPane=new BorderPane();
        var image = new ImageView();
        image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/menu.png"));
        image.setFitWidth(1000);
        image.setFitHeight(800);
        HBox hboxImage=new HBox();
        hboxImage.getChildren().add(image);
        HBox hBoxTexte=new HBox();
        Text texte=new Text("Press ENTER to start of the game");
        hBoxTexte.getChildren().add(texte);
        Text text2=new Text("Press SPACE to exit the game");
        hBoxTexte.getChildren().add(text2);

        borderPane.getChildren().addAll(hboxImage,hBoxTexte);
        borderPane.setCenter(image);
        borderPane.setTop(texte);
        borderPane.setTop(text2);
        borderPane.setAlignment(texte,Pos.TOP_CENTER);
        borderPane.setAlignment(text2,Pos.TOP_CENTER);
        texte.setFill(Color.RED);
        texte.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        borderPane.setTop(texte);
        borderPane.setMargin(texte,new Insets(30));
        this.getChildren().add(borderPane);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color:black");


    }
}