package g58132.atlg3.boulderdash.view;

import g58132.atlg3.boulderdash.model.*;

public class ViewConsole {
    public void displayBoard(Element [][] board){
        for (int i=0;i< board.length;i++){
            for (int j=0;j< board[0].length;j++){
             if (board[i][j] instanceof Wall){
                 System.out.print("w");
             } else if (board[i][j] instanceof Soil) {
                 System.out.print("s");
             }else if(board[i][j] instanceof Diamond){
                 System.out.print("d");
             } else if (board[i][j]==null) {
                 System.out.print(" ");
             } else if (board[i][j] instanceof Rockford ) {
                 System.out.print("i");
             }
            }
            System.out.println();
        }

    }
}
