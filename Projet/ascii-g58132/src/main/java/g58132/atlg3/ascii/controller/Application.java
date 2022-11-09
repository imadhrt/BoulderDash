package g58132.atlg3.ascii.controller;

import g58132.atlg3.ascii.Model.AsciiPaint;
import g58132.atlg3.ascii.View.AsciiView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

private  AsciiPaint paint;
private  AsciiView view;
    /**
     * Constructor of Application
     *
     * Allows to initialise the attributes to values.
     * @param paint is a view of the shape
     * @param view is a view
     */
    public Application(AsciiPaint paint, AsciiView view) {
        this.paint = paint;
        this.view = view;
    }


    public static void main(String[] args) {
        /** Faire une boucle tant que le joueur veut continuer,je demande lequel il veut (add show,help) si il veut
         * arreter console exit  **/
        AsciiPaint paint=new AsciiPaint(100,100);
        AsciiView view=new AsciiView(paint);

        Application controller=new Application(paint,view);
        controller.start();



    }

    /**
     * Start the game
     */
    public void start() {
        Scanner keyboard=new Scanner(System.in);
        view.displayStartGame();
        String command;
        boolean isGameOver=false;


        while(!isGameOver){
            try{
            view.enterCommand();
            command=keyboard.nextLine().toLowerCase();
            String [] tab=command.trim().split("\\s+");


             if (command.equals("exit")) {
                isGameOver=true;
            }
            else if (tab.length==6&&tab[0].equals("add")&&tab[1].equals("circle")&& tab[2].matches("-?\\d+")
           && tab[3].matches("-?\\d+") && tab[4].matches("-?\\d+") && tab[5].matches("[a-z]")) {


                     paint.newCircle(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]), tab[5].charAt(0));

                 }
            else if (tab.length == 6 && tab[0].equals("add") && tab[1].equals("square") && tab[2].matches("-?\\d+")
                         && tab[3].matches("-?\\d+") && tab[4].matches("-?\\d+") && tab[5].matches("[a-z]")) {

                     paint.newSquare(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]), tab[5].charAt(0));

                 } else if (tab.length == 7 && tab[0].equals("add") && tab[1].equals("rectangle") && tab[2].matches("-?\\d+")
                         && tab[3].matches("-?\\d+") && tab[4].matches("-?\\d+") && tab[5].matches("-?\\d+") && tab[6].matches("[a-z]")) {
                     paint.newRectangle(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]), Integer.parseInt(tab[5]), tab[6].charAt(0));
                 } else if (command.matches("move\\s*[0-9]\\s*\\d\\s*\\d\\s*")) {
                 paint.newMove(Integer.parseInt(tab[1]),Integer.parseInt(tab[2]),Integer.parseInt(tab[3]));

             }



            else if(tab.length==7 && tab[0].equals("add") && tab[1].equals("line") && tab[2].matches("-?\\d+")
                     && tab[3].matches("-?\\d+") && tab[4].matches("-?\\d+") && tab[5].matches("-?\\d+")&& tab[6].matches("[a-z]")){
                paint.newLine(Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),Integer.parseInt(tab[5]),tab[6].charAt(0));



             }





            else if ( tab.length>3&&tab[0].equals("group") && tab[1].matches("[a-z]")){
                List<Integer> liste=new ArrayList<>();
                      boolean isDigit=true;
                     for (int i=2;i< tab.length && isDigit;i++){

                         if(!tab[i].matches("\\d*")){

                             isDigit=false;
                         }else{
                             liste.add(Integer.parseInt(tab[i]));
                         }
                     }
                     if(isDigit){
                         paint.newGroup(tab[1].charAt(0),liste);
                     }
             }
             else if (command.equals("list")) {
                 paint.newList();

             }
            else if (command.equals("show")) {
                     view.display(paint.getDrawing());

                 } else if (command.matches("delete\\s*[0-9]\\s*")) {
                 paint.newDelete(Integer.parseInt(tab[1]));

             } else if (command.matches("color\\s*[0-9]\\s*[a-z]\\s*")) {
                paint.newColor(Integer.parseInt(tab[1]),tab[2].charAt(0));
                 
             } else if (command.equals("undo")) {
                paint.undo();

             } else if (command.equals("redo")) {
                 paint.redo();
             } else{
                view.displayHelp();

            }
        }catch(IllegalArgumentException e){
           e.getMessage();
           view.displayHelp();

       }

        }
        view.displayEnd();


        }






    }

