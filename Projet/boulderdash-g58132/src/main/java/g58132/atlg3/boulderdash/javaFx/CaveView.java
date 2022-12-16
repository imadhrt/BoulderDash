package g58132.atlg3.boulderdash.javaFx;

import g58132.atlg3.boulderdash.model.*;
import g58132.atlg3.boulderdash.util.Observer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class CaveView extends GridPane implements Observer {
    private BoulderDash boulderDash;


    public CaveView(BoulderDash boulderDash,int nbLevel,Stage stage) {
        this.boulderDash=boulderDash;
        boulderDash.start(nbLevel);
        displayBoard();
    }
    private void score(){
//      this.getChildren().clear();
        BorderPane borderPane=new BorderPane();
        HBox hbox=new HBox();
        Text text=new Text();
        text.setText("Diamant à récupérer: "+boulderDash.getLevel().getLevel().getnumberDiamondcollect());
        text.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text.setFill(Color.RED);
        hbox.getChildren().add(text);
        Text text2=new Text();
        if(boulderDash.getLevel().getLevel().getBoard().getRockford()!=null) {
            text2.setText("nombre de diamant récolté: " + boulderDash.getLevel().getLevel().getBoard().getRockford().getNbDiamand());
        }
        text2.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text2.setFill(Color.RED);
        hbox.getChildren().add(text2);
        hbox.setSpacing(20);
        borderPane.getChildren().add(hbox);
       borderPane.setAlignment(text,Pos.TOP_LEFT);
        borderPane.setAlignment(text2,Pos.TOP_RIGHT);
        this.getChildren().add(borderPane);


    }

    public void displayBoard(){
        this.getChildren().clear();
        this.setStyle("-fx-background-color:black");

         Element[][] board=boulderDash.getLevel().getLevel().getBoard().getBoard();
        ImageView image = null;
        for (int i = boulderDash.startRow(); i <boulderDash.rows() ; i++) {
            for (int j = boulderDash.startColumn(); j < boulderDash.columns(); j++) {
                if (board[i][j].getElement() instanceof Wall) {
                    image = new ImageView();
                    image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/wall.png"));
                    this.add(image,j,i);

                } else if (board[i][j].getElement() instanceof Soil) {
                    image = new ImageView();
                    image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/ground.png"));
                    this.add(image,j,i);
                } else if (board[i][j].getElement() instanceof Diamond) {
                    image = new ImageView();
                    image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/diamond.png"));
                    this.add(image,j,i);
                } else if (board[i][j].getElement() == null) {
                    image = new ImageView();
                    image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/background.png"));
                    this.add(image,j,i);
                } else if (board[i][j].getElement() instanceof Rockford) {
                    image = new ImageView();
                    image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/pDown.png"));
                    this.add(image,j,i);
                } else if (board[i][j].getElement() instanceof Rock) {
                    image = new ImageView();
                    image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/boulder.png"));
                    this.add(image,j,i);
                } else if (board[i][j].getElement() instanceof Exit) {
                    image = new ImageView();
                    image.setImage(new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/door.png"));
                    this.add(image,j,i);
                }
                image.setX(i);
                image.setY(j);
                image.setFitHeight(50);
                image.setFitWidth(50);
            }
        }

       this.score();
        this.setAlignment(Pos.CENTER);



    }
    public void startMove(Stage stage,Scene scene) {

         scene= new Scene(this, 1000, 1000);
        stage.setScene(scene);
        scene.setOnKeyPressed(a -> {
            Direction direction = null;

            switch (a.getCode()) {
                case DOWN:
                    direction = Direction.DOWN;

                    break;
                case UP:
                    direction = Direction.UP;



                    break;
                case RIGHT:
                    direction = Direction.RIGHT;



                    break;
                case LEFT:
                    direction = Direction.LEFT;

                    break;
                case Z:
                    boulderDash.undo();
                    break;
                case Y:
                    boulderDash.redo();
                   break;

            }
            if(direction!=null) {
                boulderDash.playMove(direction);

            }
          boulderDash.addObserver(this);
            if(boulderDash.getState()==GameState.ALLWIN){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Gagner le jeu");
                alert.setHeaderText("Vous avez gagnez tout les niveaux du jeu");
                alert.setContentText("Félicitation, vous êtes l'euro gagnant du jeu");
                alert.showAndWait();
                stage.close();
            }
            else if(boulderDash.getState()==GameState.WIN){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error d'encodage");
                alert.setHeaderText("Valeur du level erronée");
                alert.setContentText("Vous devez encoder une valeur supérieur ou égal à zéro et au maximum 9.");
                alert.showAndWait();
                boulderDash.setNumberLevel();
                boulderDash.start(boulderDash.getNumberLevel());
            } else if (boulderDash.getState()==GameState.LOSE) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Vous avez perdu!");
                alert.setHeaderText("Votre joueur est mort");
                alert.setContentText("Vous ne devez pas vous faire manger par le rocher et le diamant.");
                alert.showAndWait();
                boulderDash.start(boulderDash.getNumberLevel());
            } else if (boulderDash.getState()==GameState.EXIT) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error d'encodage");
                alert.setHeaderText("Valeur du level erronée");
                alert.setContentText("Vous devez encoder une valeur supérieur ou égal à zéro et au maximum 9.");
                alert.showAndWait();

        }



        });
    }

    @Override
    public void update() {
        displayBoard();
    }
}
