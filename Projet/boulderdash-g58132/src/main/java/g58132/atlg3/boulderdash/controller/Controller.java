package g58132.atlg3.boulderdash.controller;

import g58132.atlg3.boulderdash.model.*;
import g58132.atlg3.boulderdash.view.ViewConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private ViewConsole view;
    private BoulderDash game;
    private CommandManager commandManager=new CommandManager();

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

        while (!(game.getState()==GameState.EXIT) && !(game.getState()==GameState.LOSE)) {
            if(game.getLevel().getLevel().getBoard().getRockford()!=null) {
                System.out.println("nombre de diamant récolté :" + game.getLevel().getLevel().getBoard().getRockford().getNbDiamand());
            }
            view.displayBoard(game.getLevel().getLevel().getBoard().getBoard());
            System.out.println("Entrez direction:");
            entre = clavier.nextLine();
            Direction pos = null;
            switch (entre) {
                case "up":
                    pos = Direction.UP;
                    break;
                case "down":
                    pos = Direction.DOWN;
                    break;
                case "left":
                    pos = Direction.LEFT;
                    break;
                case "right":
                    pos = Direction.RIGHT;
                    break;
                case "exit":
               game.setdiscontinued();
               break;
                case "undo":
                 commandManager.undo();
                 break;
                case "redo":
                    commandManager.redo();
                    break;
            }
            try {
                if (pos != null) {
                    var commande=new MoveCommand(pos,game);
                    commandManager.addAllCommand(commande);

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        view.displayEnd();


    }






    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez le niveau ?");
        int nbLevel=clavier.nextInt();


        var level=new LevelReader();
        var boulderdash=new BoulderDash(level,nbLevel);
        Controller controller=new Controller(new ViewConsole(),boulderdash);
         boulderdash.start();
        controller.play();


    }

}
