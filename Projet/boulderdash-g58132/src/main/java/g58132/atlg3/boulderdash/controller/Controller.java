package g58132.atlg3.boulderdash.controller;

import g58132.atlg3.boulderdash.model.*;
import g58132.atlg3.boulderdash.view.ViewConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private ViewConsole view;
    private BoulderDash game;

    private final String UP="\s*up\s*";
    private final String DOWN="\s*down\s*";
    private final String RIGHT="\s*right\s*";
    private final String LEFT="\s*left\s*";
    private final String UNDO="\s*undo\s*";
    private final String REDO="\s*redo\s*";
    private final String EXIT="\s*exit\s*";


    public Controller(ViewConsole view, BoulderDash game) {
        this.view = view;
        this.game = game;

    }
    /**
     * allows to control the game
     */
    public void play(){
        Scanner clavier = new Scanner(System.in);

        view.displayStart();

        String entre;

        while (!(game.getState()==GameState.EXIT) && !(game.getState()==GameState.LOSE)&&!(game.getState()==GameState.ALLWIN)) {
            if(game.getLevel().getLevel().getBoard().getRockford()!=null) {
                System.out.println("nombre de diamant récolté :" + game.getLevel().getLevel().getBoard().getRockford().getNbDiamand());
            }
            view.displayBoard(game.getLevel().getLevel().getBoard().getBoard());
            System.out.println("Entrez direction(up,down,right,left):");

            entre = clavier.nextLine().toLowerCase();
            Direction pos = null;
            if(entre.matches(UP)){
                pos=Direction.UP;
            } else if (entre.matches(DOWN)) {
                pos=Direction.DOWN;
            } else if (entre.matches(RIGHT)) {
                pos=Direction.RIGHT;
            }else if(entre.matches(LEFT)){
                pos=Direction.LEFT;
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
                if(game.getState()==GameState.ALLWIN){

                    view.displayBoard(game.getLevel().getLevel().getBoard().getBoard());
                    view.displayWinEndGame();
                }
                else if(game.getState()==GameState.WIN){
                    view.displayWinLevel();
                    game.setNumberLevel();
                    game.start(game.getNumberLevel());

                } else if (game.getState()==GameState.LOSE) {
                    view.displayBoard(game.getLevel().getLevel().getBoard().getBoard());
                    view.displayLose();
                    game.start(game.getNumberLevel());
                } else if (game.getState()==GameState.EXIT) {
                    view.displayDiscontinued();

                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        view.displayEnd();


    }






    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez le niveau(0-9)?");
        int nbLevel=clavier.nextInt();


        var level=new LevelReader();
        var boulderdash=new BoulderDash(level);
        Controller controller=new Controller(new ViewConsole(),boulderdash);
         boulderdash.start(nbLevel);
        controller.play();


    }

}
