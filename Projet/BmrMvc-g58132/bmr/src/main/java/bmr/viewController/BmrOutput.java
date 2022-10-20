package bmr.viewController;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BmrOutput extends GridPane {
    private TextField bmrIn;
    private TextField calorieIn;

    public BmrOutput() {


        Label labelResult = new Label("Résultat");
        labelResult.setUnderline(true);
        this.add(labelResult, 0, 20);

        Label labelBmr = new Label("BMR");
        this.add(labelBmr, 0, 22);

        TextField textFieldBmr=new TextField();
        this.add(textFieldBmr,4,22);

        Label labelCal=new Label("Calories");
        this.add(labelCal,0,24);
        TextField textFieldCal=new TextField();

        this.add(textFieldCal,4,24);
    }
}
