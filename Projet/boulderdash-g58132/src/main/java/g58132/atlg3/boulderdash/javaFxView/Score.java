package g58132.atlg3.boulderdash.javaFxView;

import g58132.atlg3.boulderdash.model.BoulderDash;
import g58132.atlg3.boulderdash.util.Observable;
import g58132.atlg3.boulderdash.util.Observer;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.controlsfx.tools.Borders;

public class Score extends BorderPane implements Observer {
    private BoulderDash boulderDash;

    public Score(BoulderDash boulderDash){
        this.boulderDash=boulderDash;
    }

     void scoreDisplay() {
this.getChildren().clear();
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
        this.getChildren().add(hbox);

//        this.getChildren().add(borderPane);
    }

    @Override
    public void update() {
        scoreDisplay();
    }
}
