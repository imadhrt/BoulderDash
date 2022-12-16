package controlerView;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


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
        poidsField.setPromptText("Poids en kg");
        this.add(poidsField,4,4);

        Label labelAge=new Label("Age (années)");
        this.add(labelAge,0,6);
        ageField=new TextField();
        ageField.setPromptText("Age en années");
        this.add(ageField,4,6);

        ToggleGroup group = new ToggleGroup();
        Label labelSexe=new Label("Sexe");
        genreMan=new RadioButton("Homme");
        genreMan.setToggleGroup(group);
        genreMan.setSelected(true);

        genreWoman=new RadioButton("Femme");
        genreWoman.setToggleGroup(group);
        HBox boutSexe=new HBox();
        this.add(boutSexe,4,8);
        boutSexe.getChildren().addAll(genreMan,genreWoman);
        this.add(labelSexe,0,8);
        for (Node n : this.getChildren()) {
            GridPane.setMargin(n, new Insets(10));
            n.addEventFilter(KeyEvent.KEY_TYPED, e -> {
                if (!e.getCharacter().matches("[0-9]")) {
                    e.consume();
                }
            });

        }

        styleBox = new ChoiceBox(FXCollections.observableArrayList(LifeStyle.values())
        );
        this.add(new Label("Style de vie"),0,10);
        this.add(styleBox,4,10);



    }


    public int getPoidsField() {
        if(poidsField.getText().length()==0){
            return -1;
        }
        return Integer.parseInt(poidsField.getText());

    }

    public int getTailleField() {
        if(tailleField.getText().length()==0){
            return -1;
        }

        return Integer.parseInt(tailleField.getText());
    }

    public int getAgeField() {
        if(ageField.getText().length()==0){
            return -1;
        }
        return Integer.parseInt(ageField.getText());
    }

    public boolean getGenreMan() {
        return genreMan.isSelected();
    }
    public boolean getGenreWoman() {
        return genreWoman.isSelected();
    }

    public LifeStyle getStyleBox() {
        if(styleBox.getValue()==null){
            return null;
        }
        return (LifeStyle) styleBox.getValue();
    }

    public void clear(){
        poidsField.clear();
        tailleField.clear();
        ageField.clear();
        styleBox.getSelectionModel().clearSelection();

    }


}
