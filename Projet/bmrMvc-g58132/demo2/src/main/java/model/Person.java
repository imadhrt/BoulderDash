package model;

import controlerView.LifeStyle;
import util.Observable;
import util.Observer;

import java.util.ArrayList;
import java.util.List;

public class Person implements Observable {
    private int height;
    private int weight;
    private int age;
    private boolean isMan;
    private LifeStyle lifeStyle;

    private List<Observer> observers=new ArrayList();


    public void set(int height, int weight, int age, boolean isMan, LifeStyle lifeStyle) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.isMan = isMan;
        this.lifeStyle = lifeStyle;
         notifyObservers();
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

    public boolean isMan() {
        return isMan;
    }

    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    public double getBmr() {
        double bmr = -1;
        if(getHeight()==-1||getWeight()==-1||getAge()==-1 ){
                return bmr;
        }
        else if(getHeight()==0||getWeight()==0||getAge()==0 ){
            bmr=0;
            return  bmr;
        }


        if (isMan) {
            bmr = (13.7 * (weight) + 5 * (height) - 6.8 * (age) + 66);


        } else {

            bmr = (9.6 * (weight) + 1.8 * (height) - 4.7 * (age) + 655);

        }

        return bmr;
    }

    public double getCal() {
        double a=0;
        double calories=-1;
        if(this.getLifeStyle()==null ||getHeight()==-1||getWeight()==-1||getAge()==-1 ){
            return calories;
        }


        switch (this.getLifeStyle().getNiveau()){
            case "sédentaire":
            case "Peu actif":
            case "Actif":
            case "fort actif":
            case "extrêmement actif":
                a=this.getLifeStyle().getFacteur();
                break;
        }
        calories=getBmr()*a;



        return calories;

    }

    @Override
    public void addObserver(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }

    }

    @Override
    public void removeObserver(Observer observer) {
       observers.remove(observer);
    }

    private void notifyObservers() {
        for (var observe:observers) {
             observe.update();
        }
    }
}


