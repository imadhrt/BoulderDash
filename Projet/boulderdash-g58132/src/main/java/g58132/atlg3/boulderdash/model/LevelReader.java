package g58132.atlg3.boulderdash.model;

import g58132.atlg3.boulderdash.view.ViewConsole;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LevelReader {

private Level level;


    public void parcourirLevel(String texte,Element[][] board){
        try {


            // Le fichier d'entrée
            File file = new File(texte);
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String shearchNumberDiamand="";
            int c = 0;
            int row=0;
            int column=0;
            // Lire caractère par caractère
            while ((c = br.read()) != -1) {
                // convertir l'entier en char
                char ch = (char) c;

                switch (ch){
                    case 'w':
                        board[row][column]=new Wall();
                        column++;
                        break;
                    case 's':
                        board[row][column]=new Soil();
                        column++;
                        break;
                    case 'd':
                        board[row][column]=new Diamond();
                        column++;
                        break;
                    case ' ':
                        board[row][column]=null;
                        column++;
                        break;
                    case 'i':
                        board[row][column]=new Rockford();
                        column++;
                        break;
                    case 'r':
                        board[row][column]=new Rock();
                        column++;
                        break;
                    case '\n':
                        if (column!=0) {
                            row++;
                            column = 0;
                        }
                        break;
                }
                if(row==0 && column==0){
                    shearchNumberDiamand+=ch;
                }

            }
//            level.setHeight(board.length);
//            level.setWidth(board[0].length);
//            level.setNombreDiamantARecolté(Integer.parseInt(shearchNumberDiamand));


        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
    Board board=new Board(100,100);
    LevelReader lvl=new LevelReader();
    lvl.parcourirLevel("Z:\\ATLG3\\58132-El-Harrouti\\Projet\\boulderdash-g58132\\src\\main\\java\\g58132\\atlg3\\boulderdash\\level\\level1",board.getBoard());
        ViewConsole view=new ViewConsole();
        view.displayBoard(board.getBoard());
    }

}
