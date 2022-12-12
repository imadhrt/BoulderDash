package g58132.atlg3.boulderdash.view;

import g58132.atlg3.boulderdash.model.*;
import javafx.scene.paint.Color;

public class ViewConsole {
    public void displayBoard(Element[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getElement() instanceof Wall) {
                    System.out.print("\u001B[32m" + "w" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Soil) {
                    System.out.print("\u001B[33m" + "s" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Diamond) {
                    System.out.print("\u001B[34m" + "d" + "\u001B[0m");
                } else if (board[i][j].getElement() == null) {
                    System.out.print(" ");
                } else if (board[i][j].getElement() instanceof Rockford) {
                    System.out.print("\u001B[31m" + "i" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Rock) {
                    System.out.print("\u001B[38m" + "r" + "\u001B[0m");
                } else if (board[i][j].getElement() instanceof Exit) {
                    System.out.print("\033[0;35m"+"e"+"\u001B[0m");
                }
            }
            System.out.println();
        }

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

}

