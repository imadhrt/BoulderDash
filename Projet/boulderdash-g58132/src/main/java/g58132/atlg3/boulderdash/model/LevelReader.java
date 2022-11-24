package g58132.atlg3.boulderdash.model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LevelReader {
    private int height;
    private int width;
    private char [][] map;
    private  String filename;
    public LevelReader(int height, int width, String fileName){
        this.height = height;
        this.width = width;
        String filename=fileName;
        this.map = parcourirMap();}


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

//    public char[][] getMap() {
//        return map;
//    }

    public  char[][] parcourirMap() {
        char [][] tab=new char[width][height];
        try (var in = LevelReader.class.getResourceAsStream(filename)) {
            int i;
            while ( (i = in.read()) != -1 ) {
                System.out.println((char) i);
            }
        } catch (IOException e) {

        }
        return tab;
    }


    public static void main(String[] args) {
        LevelReader level=new LevelReader(79,26,"/g58132/atlg3/boulderdash/level/level1");
        level.parcourirMap();

    }




}
