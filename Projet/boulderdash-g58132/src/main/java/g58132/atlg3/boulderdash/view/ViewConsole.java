package g58132.atlg3.boulderdash.view;

import g58132.atlg3.boulderdash.model.*;

import java.util.Scanner;

public class ViewConsole {
    /**
     * Displays the game board
     *
     * @param board is an element of the board
     */
    public void displayBoard(Element[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getElement() instanceof Wall) {
                    System.out.print("\u001B[32m" + "w" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Soil) {
                    System.out.print("\u001B[33m" + "s" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Diamond) {
                    System.out.print("\u001B[34m" + "d" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Rockford) {
                    System.out.print("\u001B[31m" + "i" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Rock) {
                    System.out.print("\u001B[38m" + "r" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Exit) {
                    System.out.print("\033[0;35m" + "e" + "\u001B[0m");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    /**
     * Displays the winning of level.
     */

    public void displayWinLevel() {
        System.out.println("\u001B[32m" + "Good luck, you are to pass the level!!!!" + "\u001B[0m");
    }

    /**
     * Displays the winning of player.
     */

    public void displayWinEndGame() {
        System.out.println("\u001B[32m" + "End of the game, You are finish the all level!!!" + "\u001B[0m");
    }

    /**
     * Displays the loose of level.
     */

    public void displayLose() {
        System.out.println("\u001B[31m" + "You are lose the level" + "\u001B[0m");
    }

    /**
     * Display the give up of the player
     */
    public void displayDiscontinued() {
        System.out.println("\u001B[31m" + "You are give up" + "\u001B[0m");
    }

    /**
     * Display end of game
     */
    public void displayEnd() {
        System.out.println("\u001B[31m" + "*****End of game*****" + "\u001B[0m");
    }

    /**
     * Display Start of game
     */
    public void displayStart() {
        System.out.println("\033[4;37m" + "*****Welcome to the Boulder Dash game****" + "\u001B[0m");
    }

    /**
     * Display the number of the diamond collected by the player and
     * number of diamonds to be collected
     *
     * @param game is a facade of the game
     */
    public void displayTheDiamondCollected(BoulderDash game) {
        System.out.println("nombre de diamant à recolté :" + game.getLevel().getLevel().getnumberDiamondcollect());
        if (game.getLevel().getLevel().getBoard().getRockford() != null) {
            System.out.println("nombre de diamant récolté :" + game.getLevel().getLevel().getBoard().getRockford().getNbDiamand());
        }

    }

    /**
     * Displays ask direction
     */
    public void displayMessageDirection() {
        System.out.println("Entrez direction(up,down,right,left):");
    }

    /**
     * Robust reading of an integer.
     * As long as the user input is not an integer the method requests a new
     * input the method requests a new input
     *
     * @return the integer entered by the user
     */
    private static int LectutreRobusteEntier() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Enter the level (0 à 9): ");
        while (!clavier.hasNextInt()) {
            System.out.println("this is not an integer!");
            System.out.println("Veuillez saisir un nombre entier:");
            System.out.println("Please enter an integer number:");
            clavier.next();
        }
        return clavier.nextInt();
    }

    /**
     * Robust reading of a bounded integer.
     * As long as the user does not enter an integer between min and max the
     * method requests a new input.
     *
     * @param min is the minimum bound of an integer
     * @param max is the maximum bound of an integer
     * @return an integer between minimum and maximum
     */
    public int LectureRobusteEntreMinEtMax(int min, int max) {
        int ligne = LectutreRobusteEntier();

        while (ligne < min || ligne > max) {
            System.out.println("La valeur n'est pas comprise entre 0 et 9 !");
            System.out.println("Veuillez saisir un nombre compris entre 0 et 9 :");
            ligne = LectutreRobusteEntier();
        }
        return ligne;

    }


}

