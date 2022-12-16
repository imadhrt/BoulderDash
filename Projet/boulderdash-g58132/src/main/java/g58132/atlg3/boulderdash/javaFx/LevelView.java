package g58132.atlg3.boulderdash.javaFx;

import g58132.atlg3.boulderdash.model.BoulderDash;
import g58132.atlg3.boulderdash.model.LevelReader;
import g58132.atlg3.boulderdash.util.Observer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LevelView extends GridPane implements Observer {
private BoulderDash boulderDash;
private int nbLevel;
    public LevelView(BoulderDash boulderDash,Stage stage) {
        this.boulderDash=boulderDash;
        nbLevel=0;
        level(stage);
    }

    public void level(Stage stage){
        HBox hbox=new HBox();
        Text text=new Text("Choose your level(0-9)");
        text.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        text.setFill(Color.RED);
        hbox.getChildren().add(text);
        TextField textField=new TextField();
        textField.setPromptText("number of the level(0-9)");
        hbox.getChildren().add(textField);
        this.setStyle("-fx-background-color:black");
        this.setAlignment(Pos.CENTER);
        textField.addEventFilter(KeyEvent.KEY_TYPED,e->{
            if(!e.getCharacter().matches("[0-9]")){
                e.consume();
            }
        });
        Button button=new Button("lancer");
        hbox.getChildren().add(button);
        hbox.setSpacing(20);
        this.getChildren().add(hbox);
        button.setOnAction(actionEvent -> {
            if(textField.getText().length()==0 || Integer.parseInt(textField.getText())<0 || Integer.parseInt(textField.getText())>9) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error d'encodage");
                alert.setHeaderText("Le numéro du level est erronée");
                alert.setContentText("Vous devez encoder une valeur supérieur ou égal à zéro et au maximum 9.");
                alert.showAndWait();
            }else{
                nbLevel= Integer.parseInt(textField.getText());

                CaveView caveView=new CaveView(boulderDash,nbLevel,stage);
                Scene scene = null;
                caveView.startMove(stage,scene);
                


            }

        });


    }

    @Override
    public void update() {


    }

    public int getNbLevel() {
        return nbLevel;
    }
}
