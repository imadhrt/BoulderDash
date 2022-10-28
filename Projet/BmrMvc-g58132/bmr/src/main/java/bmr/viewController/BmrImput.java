package bmr.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.List;


public class BmrImput extends GridPane {
    private TextField poidsField;
    private TextField tailleField;
    private TextField ageField;
    private RadioButton genreMan;
    private RadioButton genreWoman;
    private ChoiceBox<LifeStyle> styleBox ;
    public BmrImput() {
        Label label = new Label("Donnée");
        label.setUnderline(true);
        this.add(label, 0, 0);

        Label label2 = new Label("Taille (en cm)");
        this.add(label2, 0, 2);

        tailleField=new TextField();
        tailleField.setPromptText("Taille en cm");
        this.add(tailleField,4,2);

        Label labelPoid=new Label("Poids (kg)");
        this.add(labelPoid,0,4);
        poidsField=new TextField();

        this.add(poidsField,4,4);

        Label labelAge=new Label("Age (années)");
        this.add(labelAge,0,6);
        ageField=new TextField();

        this.add(ageField,4,6);

        ToggleGroup group = new ToggleGroup();
        Label labelSexe=new Label("Sexe");
        genreMan=new RadioButton("Homme");
        genreMan.setToggleGroup(group);
        genreMan.setSelected(true);

        genreWoman=new RadioButton("Femme");
        genreWoman.setToggleGroup(group);

        this.add(labelSexe,0,8);
        this.add(genreMan,4,8);
        this.add(genreWoman,5,8);
        styleBox= new ChoiceBox(FXCollections.observableArrayList(LifeStyle.values()));






//        cb.setTooltip(new Tooltip("selectionne le style de vie"));
        this.add(new Label("Style de vie"),0,10);
        this.add(styleBox,4,10);



    }



    public int getPoidsField() {
        return Integer.parseInt(poidsField.getText());

    }

    public int getTailleField() {
        return Integer.parseInt(tailleField.getText());
    }

    public int getAgeField() {
        return Integer.parseInt(ageField.getText());
    }

    public boolean getGenreMan() {
        return genreMan.isSelected();
    }

    public boolean getGenreWoman() {
        return genreWoman.isSelected();
    }

    public LifeStyle getStyleBox() {
        return (LifeStyle) styleBox.getValue();
    }


}
