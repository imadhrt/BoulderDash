package controlerView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Person;
import util.Observer;


public class BmrView extends Application  implements Observer {
    private BmrImput data;
    private BmrOutput result;

    private Person person;


    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


         /*
         initMenu();
         initMainPane();
         initButtons();


          */
        primaryStage.setTitle("Calcul du BMR");
        VBox vbox=new VBox();
        HBox hbox=new HBox();
        data = new BmrImput();
         result=new BmrOutput();
         person=new Person();
         person.addObserver(this);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");

        MenuItem exit = new MenuItem("exit");
        menuFile.getItems().addAll(exit);

        menuBar.getMenus().addAll(menuFile);
        vbox.getChildren().addAll(menuBar);

        vbox.getChildren().add(hbox);
        hbox.getChildren().addAll(data,result);



        Scene scene = new Scene(vbox);



        Button bouton=new Button("Calcul du BMR");
        Button bouton2=new Button("Clear");
        bouton.setMaxWidth(Double.MAX_VALUE);
        bouton2.setMaxWidth(Double.MAX_VALUE);

        vbox.getChildren().addAll(bouton,bouton2);



exit.setOnAction(actionEvent -> {
    person.removeObserver(this);
    primaryStage.close();});
        bouton2.setOnAction(actionEvent -> {
            data.clear();
            result.clear();
        });

      bouton.setOnAction(actionEvent -> {


            person.set(data.getTailleField(),data.getPoidsField(),data.getAgeField(),data.getGenreMan(),data.getStyleBox());

       });


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void update() {

        // if error --> errorMessage; sinon ...
        result.setBmr(person.getBmr());
        result.setCal(person.getCal());

    }
}

