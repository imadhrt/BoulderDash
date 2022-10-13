package com.example.bmr;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class Bmr extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calcul du BMR");
//        BorderPane borderPane=new BorderPane();
        GridPane root = new GridPane();
        GridPane root2=new GridPane();
//        borderPane.getChildren().addAll(root,root2);

        Scene scene = new Scene(root, 250, 100);
        Scene scene2=new Scene(root2,250,100);
        Label label = new Label("Donnée");
        label.setUnderline(true);
        root.add(label, 0, 0);

        Label label2 = new Label("Taille (en cm)");
        root.add(label2, 0, 2);

        TextField textField=new TextField();
        root.add(textField,4,2);

        Label labelPoid=new Label("Poids (kg)");
        root.add(labelPoid,0,4);
        TextField textField2=new TextField();

        root.add(textField2,4,4);

        Label labelAge=new Label("Age (années)");
        root.add(labelAge,0,6);
        TextField textField3=new TextField();

        root.add(textField3,4,6);

        ToggleGroup group = new ToggleGroup();
        Label labelSexe=new Label("Sexe");
        RadioButton radioButtonHomme=new RadioButton("Homme");
        radioButtonHomme.setToggleGroup(group);

        RadioButton radioButtonFemme=new RadioButton("Femme");
        radioButtonFemme.setToggleGroup(group);

        root.add(labelSexe,0,8);
        root.add(radioButtonHomme,4,8);
        root.add(radioButtonFemme,5,8);

        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
                "Sédentaire", "Peu actif", "Actif","Fort actif","Extrêmement actif")
        );
//        cb.setTooltip(new Tooltip("selectionne le style de vie"));
        root.add(new Label("Style de vie"),0,10);
        root.add(cb,4,10);

        Button bouton=new Button("Calcul du BMR");
         root.add(bouton,0,12);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
