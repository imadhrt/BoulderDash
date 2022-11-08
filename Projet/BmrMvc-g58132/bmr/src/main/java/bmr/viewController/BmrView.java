package bmr.viewController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BmrView extends Application {
    private BmrImput data;
    private BmrOutput result;


    public static void main(String[] args) {
      launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calcul du BMR");
//       BorderPane borderPane=new BorderPane();
        VBox vbox=new VBox();
        HBox hbox=new HBox();
        data = new BmrImput();
         result=new BmrOutput();
    


//        gridPane2.setHgap(10);
//        gridPane2.setVgap(5);

//       borderPane.getChildren().add(vbox);
        vbox.getChildren().add(hbox);
        hbox.getChildren().addAll(data,result);




        Scene scene = new Scene(vbox);
        Button bouton=new Button("Calcul du BMR");
        bouton.setPrefWidth(2000);

        vbox.getChildren().add(bouton);

        Button bouton2=new Button("Clear");
        bouton2.setPrefWidth(2000);
        vbox.getChildren().add(bouton2);



//        bouton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                String taille=textField.getText();
//                String poid=textField2.getText();
//                String age=textField3.getText();
//                if(taille.length()==0||poid.length()==0||age.length()==0 ){
//                    textFieldBmr.setText("FAILED");
//                    textFieldBmr.setStyle("-fx-text-fill: red;");
//                    textFieldCal.setText("FAILED");
//                    textFieldCal.setStyle("-fx-text-fill: red;");
//                    return;
//
//                }
////                if(Double.parseDouble(poid)==0 ||Double.parseDouble(taille)==0
////                ||Integer.parseInt(age)==0){
////
////                    Alert alert = new Alert(Alert.AlertType.ERROR);
////                    alert.setTitle("Error d'encodage");
////                    alert.setHeaderText("Valeur de la taille erronée");
////                    alert.setContentText("Vous devez encoder une valeur strictement supérieur à zéro.");
////                    alert.show();
////
////
////                    return;
////                }
//                double bmr=0;
//                double calories=0;
//                if (group.getSelectedToggle() != null) {
//                    RadioButton button = (RadioButton) group.getSelectedToggle();
//                    if(button.getText().equals("Homme")){
//                        bmr=(13.7*(Double.parseDouble(poid))+ 5*(Double.parseDouble(taille))-6.8*(Integer.parseInt(age)) + 66) ;
//
//                    }else{
//                        bmr=(9.6*(Double.parseDouble(poid))+ 1.8*(Double.parseDouble(taille))-4.7*(Integer.parseInt(age)) + 655) ;
//                    }
//
//                }
//                double a=0;
//                switch (cb.getSelectionModel().selectedIndexProperty().get()){
//                    case 0:
//                        a=1.2;
//                        break;
//                    case 1:
//                        a=1.375;
//                        break;
//                    case 2:
//                        a=1.55;
//                        break;
//                    case 3:
//                        a=1.725;
//                        break;
//                    case 4:
//                        a=1.9;
//                        break;
//                }
//                calories=bmr*a;
//
//                textFieldBmr.setStyle("-fx-text-fill: Black;");
//                textFieldCal.setStyle("-fx-text-fill: Black;");
//                textFieldBmr.setText(""+bmr);
//                textFieldCal.setText(""+calories);
//
//
//
//
//
//
//
//
//            }
//        });
//        bouton2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                textField.clear();
//                textField2.clear();
//                textField3.clear();
//                textFieldBmr.clear();
//                textFieldCal.clear();
//                cb.getSelectionModel().clearSelection();
//            }
//        });







        primaryStage.setScene(scene);
        primaryStage.show();
    }

    }

