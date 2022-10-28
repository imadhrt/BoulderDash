package bmr.viewController;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Person {
    private int height;
    private int weight;
    private int age;
    private boolean isWoman;
    private LifeStyle lifeStyle ;

    public Person(int height, int weight, int age, boolean isWoman, LifeStyle lifeStyle) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.isWoman = isWoman;
        this.lifeStyle = lifeStyle;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }
}


