package g58132.atlg3.boulderdash.controller;

import g58132.atlg3.boulderdash.model.*;
import g58132.atlg3.boulderdash.view.ViewConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private ViewConsole view;
    private BoulderDash game;

    private final String UP = "\s*up\s*";
    private final String DOWN = "\s*down\s*";
    private final String RIGHT = "\s*right\s*";
    private final String LEFT = "\s*left\s*";
    private final String UNDO = "\s*undo\s*";
    private final String REDO = "\s*redo\s*";
    private final String EXIT = "\s*exit\s*";

    /**
     * Constructor of Controller
     *
     * Allows to initialise the Controller with attribute of game and view.
     *
     * @param game
     * @param view
     */

    public Controller(ViewConsole view, BoulderDash game) {
        this.view = view;
        this.game = game;

    }

    /**
     * allows to control the game
     */
    public void play() {
        Scanner clavier = new Scanner(System.in);
        view.displayStart();
        String entre;
        while (!(game.getState() == GameState.EXIT) && !(game.getState() == GameState.LOSE) && !(game.getState() == GameState.ALLWIN)) {
            view.displayTheDiamondCollected(game);
            view.displayBoard(game.getLevel().getLevel().getBoard().getBoard());
            view.displayMessageDirection();

            entre = clavier.nextLine().toLowerCase();
            Direction pos = null;
            if (entre.matches(UP)) {
                pos = Direction.UP;
            } else if (entre.matches(DOWN)) {
                pos = Direction.DOWN;
            } else if (entre.matches(RIGHT)) {
                pos = Direction.RIGHT;
            } else if (entre.matches(LEFT)) {
                pos = Direction.LEFT;
            } else if (entre.matches(UNDO)) {
                game.undo();
            } else if (entre.matches(REDO)) {
                game.redo();
            } else if (entre.matches(EXIT)) {
                game.setdiscontinued();
            }
            try {
                if (pos != null) {
                    game.playMove(pos);
                }
                if (game.getState() == GameState.ALLWIN) {
                    view.displayBoard(game.getLevel().getLevel().getBoard().getBoard());
                    view.displayWinEndGame();
                } else if (game.getState() == GameState.WIN) {
                    view.displayWinLevel();
                    game.setNumberLevel();
                    game.start(game.getNumberLevel());

                } else if (game.getState() == GameState.LOSE) {
                    view.displayBoard(game.getLevel().getLevel().getBoard().getBoard());
                    view.displayLose();
                    game.start(game.getNumberLevel());
                } else if (game.getState() == GameState.EXIT) {
                    view.displayDiscontinued();

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        view.displayEnd();
    }


    public static void main(String[] args) {
        int nbLevel;
        var level = new LevelReader();
        var boulderdash = new BoulderDash(level);
        ViewConsole viewConsole=new ViewConsole();
        Controller controller = new Controller(viewConsole, boulderdash);
         nbLevel=viewConsole.LectureRobusteEntreMinEtMax(0,9);
        boulderdash.start(nbLevel);
        controller.play();
    }
}
