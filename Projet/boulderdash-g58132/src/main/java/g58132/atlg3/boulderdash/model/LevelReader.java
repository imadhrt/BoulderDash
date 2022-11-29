package g58132.atlg3.boulderdash.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LevelReader {
//private Board board;
//private Level level;


    public void parcourirLevel(String texte){
        try {


            // Le fichier d'entrée
            File file = new File(texte);
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            int c = 0;
            // Lire caractère par caractère
            while ((c = br.read()) != -1) {
                // convertir l'entier en char
                char ch = (char) c;
                // Afficher le caractère
                System.out.print(ch);
            }


        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        System.out.println();
    }
    }
//    }
//        try
//        {
//            // Le fichier d'entrée
////            File file = new File("C:\\Users\\elhar\\ATLG3\\58132-El-Harrouti\\Projet\\boulderdash-g58132\\src\\main\\java\\g58132\\atlg3\\boulderdash\\level\\level1");
////            // Créer l'objet File Reader
////            FileReader fr = new FileReader(file);
////            // Créer l'objet BufferedReader
////            BufferedReader br = new BufferedReader(fr);
////            StringBuffer sb = new StringBuffer();
////            String line;
////            while((line = br.readLine()) != null)
////            {
////                // ajoute la ligne au buffer
////                sb.append(line);
////                sb.append("\n");
////            }
////            fr.close();
////            System.out.println("Contenu du fichier: ");
////            System.out.println(sb.toString());
////        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }

//    }
//}
