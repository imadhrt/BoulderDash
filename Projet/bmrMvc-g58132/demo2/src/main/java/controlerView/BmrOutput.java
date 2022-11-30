package controlerView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Person;

public class BmrOutput extends GridPane {
    private TextField bmrIn;
    private TextField calorieIn;

    public BmrOutput() {


        Label labelResult = new Label("Résultat");
        labelResult.setUnderline(true);
        this.add(labelResult, 0, 20);

        Label labelBmr = new Label("BMR");
        this.add(labelBmr, 0, 22);

        bmrIn = new TextField();
        bmrIn.setPromptText("Résultat du BMR");
        bmrIn.setEditable(false);
        this.add(bmrIn, 4, 22);

        Label labelCal = new Label("Calories");
        this.add(labelCal, 0, 24);
        this.calorieIn = new TextField();
        calorieIn.setEditable(false);
        calorieIn.setPromptText("Dépense en calories");
        this.add(calorieIn, 4, 24);

        for (Node n : this.getChildren()) {
            GridPane.setMargin(n, new Insets(10));


        }
    }
    public void setBmr(double bmr){
        if(bmr==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error d'encodage");
            alert.setHeaderText("Valeur de la taille erronée");
            alert.setContentText("Vous devez encoder une valeur strictement supérieur à zéro.");
            alert.showAndWait();
        }
        if(bmr==-1){ // faire une autre méthode: setErrorMessage(..)
            bmrIn.setText("FAILED");
            bmrIn.setStyle("-fx-text-fill: red;");
            calorieIn.setText("FAILED");
            calorieIn.setStyle("-fx-text-fill: red;");
            return;
        }
        bmrIn.setStyle("-fx-text-fill: black;");
            calorieIn.setStyle("-fx-text-fill: black;");
        bmrIn.setText(String.valueOf(bmr));


    }
    public void setCal(double cal){
        if(cal==-1){
            calorieIn.setText("FAILED");
            calorieIn.setStyle("-fx-text-fill: red;");
            return;
        }
        calorieIn.setStyle("-fx-text-fill: black;");
        calorieIn.setText(String.valueOf(cal));

    }
    public void clear(){
        bmrIn.clear();
        calorieIn.clear();


    }

}
