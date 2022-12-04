package g58132.atlg3.boulderdash.model;

import g58132.atlg3.boulderdash.view.ViewConsole;

import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class LevelReader {

private Level level=new Level();

    /**
     * Accessor of the level
     *
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Allows of the browse the file and retrieve data
     *
     * @param file the name of the file which there are the level
     */
    public void browseLevel(String file){
        int width = 0;
        int height=0;
        int numberDiamond=0;
        int time;
        Board board;
        try (var in = new FileInputStream("src/main/java/g58132/atlg3/boulderdash/level/"+file)){
            var isr = new InputStreamReader(in);
            var br = new BufferedReader(isr);
            int c=0;
            int v=0;//recoit  un entier ascii


            numberDiamond = Integer.valueOf(br.readLine());
            time = Integer.valueOf(br.readLine());

            while(( v=br.read()) != -1){
                boolean b = (char)(v) == '\n';
                boolean r= (char)(v) == '\r';
                if(b) {
                    c++;
                }
                else {
                    if(!r){
                        width++;
                    }
                }



            }
            width=width/c;

            height = c;
            System.out.println(height);
            System.out.println(width);
            board = new Board(height, width);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (var begin = new FileInputStream("src/main/java/g58132/atlg3/boulderdash/level/"+file)){

            var inputStreamReader = new InputStreamReader(begin);
            var bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            bufferedReader.readLine();
            for (int i = 0; i < height; i++) {
                String line = bufferedReader.readLine();
                for (int j = 0; j < width; j++) {

                    char ch = line.charAt(j);//recupere caractère par caractère d'une ligne
                    switch (ch) {
                        case 'w':
                            board.setElement(new Wall(),new Position(i,j));
                            break;
                        case 's':
                            board.setElement(new Soil(),new Position(i,j));
                            break;
                        case 'd':
                            board.setElement(new Diamond(),new Position(i,j));
                            break;
                        case ' ':
                            board.setElement(null,new Position(i,j));
                            break;
                        case 'i':
                            board.setElement(new Rockford(),new Position(i,j));
                            break;
                        case 'r':
                            board.setElement(new Rock(),new Position(i,j));
                            break;


                    }}
                level.setnumberDiamondcollect(numberDiamond);
                level.setTime(time);
                level.setBoard(board);



            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        Scanner clavier=new Scanner(System.in);
        LevelReader level=new LevelReader();
        level.browseLevel("level1");
        ViewConsole view=new ViewConsole();

        boolean a=true;
        String entre;

        while(a){
            view.displayBoard(level.getLevel().getBoard().getBoard());
            System.out.println("Entrez direction:");
            entre=clavier.nextLine();
            Direction pos=null;
            switch (entre){
                case "up":
                    pos=Direction.UP;
                    break;
                case "down":
                    pos=Direction.DOWN;
                    break;
                case "left":
                    pos=Direction.LEFT;
                    break;
                case "right":
                    pos=Direction.RIGHT;
                    break;
                case "exit":
                    a=false;
            }
            level.getLevel().getBoard().movePlayer(pos);

        }


        }
        }






