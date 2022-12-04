package g58132.atlg3.boulderdash.controller;

import g58132.atlg3.boulderdash.model.LevelReader;
import g58132.atlg3.boulderdash.view.ViewConsole;

public class Controller {
    private ViewConsole view;
    private LevelReader level;

    public Controller(ViewConsole view, LevelReader level) {
        this.view = view;
        this.level = level;
    }
    /**
     * allows to control the game
     */
    public void play(){

    }

}
