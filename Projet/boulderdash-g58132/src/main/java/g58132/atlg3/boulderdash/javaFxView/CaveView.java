package g58132.atlg3.boulderdash.javaFxView;

import g58132.atlg3.boulderdash.model.*;
import g58132.atlg3.boulderdash.util.Observer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CaveView extends GridPane implements Observer {
    private BoulderDash boulderDash;
    private Stage stage;
    private final Image wall=new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/wall.png");
    private final  Image ground=new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/ground.png");
    private final  Image diamond=new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/diamond.png");
    private final  Image pDown=new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/pDown.png");
    private final  Image rock=new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/boulder.png");
    private final  Image door=new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/door.png");
    private final  Image background=new Image("file:src/main/resources/g58132/atlg3/boulderdash/sprite/background.png");

    /**
     * Constructor of the CaveView
     *
     * @param boulderDash is a facade of the game
     * @param nbLevel     is a number of the level
     * @param stage       is a scene of the theatre, this is
     *                    the physical location where your application will be displayed
     */
    public CaveView(BoulderDash boulderDash, int nbLevel, Stage stage) {
        this.boulderDash = boulderDash;
        this.stage=stage;
        boulderDash.start(nbLevel);
        displayBoard();
    }

    private void score() {
     BorderPane borderPane = new BorderPane();
        HBox hbox=new HBox();
        Text text=new Text();
        text.setText("Diamant à récupérer: "+boulderDash.getLevel().getLevel().getnumberDiamondcollect());
        text.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text.setFill(Color.WHITE);
        hbox.getChildren().add(text);
        Text text2=new Text();
        if(boulderDash.getLevel().getLevel().getBoard().getRockford()!=null) {
            text2.setText("nombre de diamant récolté: " + boulderDash.getLevel().getLevel().getBoard().getRockford().getNbDiamand());
        }
        text2.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text2.setFill(Color.RED);
        hbox.getChildren().add(text2);
        hbox.setSpacing(20);
        Text text3=new Text("Exit:Space");
        text3.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text3.setFill(Color.ORANGE);
        hbox.getChildren().add(text3);

        Text text4=new Text("Undo:Z");
        text4.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text4.setFill(Color.ORANGE);
        hbox.getChildren().add(text4);
        Text text5=new Text("Redo:Y");
        text5.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text5.setFill(Color.ORANGE);
        hbox.getChildren().add(text5);
        borderPane.getChildren().add(hbox);

        this.getChildren().add(borderPane);
    }

    /**
     * Display the game of the board in javaFX
     */
    private void displayBoard() {
       this.getChildren().clear();
        this.setStyle("-fx-background-color:black");
        Element[][] board = boulderDash.getLevel().getLevel().getBoard().getBoard();
        ImageView image = null;
        for (int i = boulderDash.beginRow(); i < boulderDash.endRow(); i++) {
            for (int j = boulderDash.beginColumn(); j < boulderDash.endColumn(); j++) {
                if (board[i][j].getElement() instanceof Wall) {
                    image = new ImageView();
                    image.setImage(wall);
                    this.add(image, j, i);
                } else if (board[i][j].getElement() instanceof Soil) {
                    image = new ImageView();
                    image.setImage(ground);
                    this.add(image, j, i);
                } else if (board[i][j].getElement() instanceof Diamond) {
                    image = new ImageView();
                    image.setImage(diamond);
                    this.add(image, j, i);
                } else if (board[i][j].getElement() instanceof Rockford) {
                    image = new ImageView();
                    image.setImage(pDown);
                    this.add(image, j, i);
                } else if (board[i][j].getElement() instanceof Rock) {
                    image = new ImageView();
                    image.setImage(rock);
                    this.add(image, j, i);
                } else if (board[i][j].getElement() instanceof Exit) {
                    image = new ImageView();
                    image.setImage(door);
                    this.add(image, j, i);
                } else {
                    image = new ImageView();
                    image.setImage(background);
                    this.add(image, j, i);
                }
                image.setFitHeight(50);
                image.setFitWidth(50);
            }
        }
        score();
      this.setAlignment(Pos.CENTER);
    }

    /**
     * Allows to play of the game
     *
     * @param scene it is all the nodes and component
     */
    public void startMove(Scene scene) {
        scene = new Scene(this, 1000, 1000);
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
                case SPACE:
                    stage.close();
                    break;

            }
            if (direction != null) {
                boulderDash.playMove(direction);
            }
            boulderDash.addObserver(this);
            if (boulderDash.getState() == GameState.ALLWIN) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Gagner le jeu");
                alert.setHeaderText("Vous avez gagnez tout les niveaux du jeu");
                alert.setContentText("Félicitation, vous êtes l'euro gagnant du jeu");
                alert.showAndWait();
                stage.close();
            } else if (boulderDash.getState() == GameState.WIN) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Gagner le niveau");
                alert.setHeaderText("vous avez gagné le niveau de jeu");
                alert.setContentText("Vous passer au niveau suivant, Bonne chance");
                alert.showAndWait();
                boulderDash.setNumberLevel();
                boulderDash.start(boulderDash.getNumberLevel());
            } else if (boulderDash.getState() == GameState.LOSE) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Vous avez perdu!");
                alert.setHeaderText("Votre joueur est mort");
                alert.setContentText("Vous ne devez pas vous faire manger par le rocher et le diamant.");
                alert.showAndWait();
                boulderDash.start(boulderDash.getNumberLevel());
            } else if (boulderDash.getState() == GameState.EXIT) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Vous avez abandonné!!!!!!");
                alert.setHeaderText("J'espère que vous allez revenir jouer à notre jeu");
                alert.setContentText("Dommage,Au revoir");
                alert.showAndWait();
                stage.close();

            }


        });
    }

    @Override
    public void update() {

        displayBoard();
    }
}
