package g58132.atlg3.ascii.controller;

import g58132.atlg3.ascii.Model.AsciiPaint;
import g58132.atlg3.ascii.Model.Drawing;
import g58132.atlg3.ascii.View.AsciiView;

import java.util.Scanner;

public class Application {

private final AsciiPaint paint;
private final AsciiView view;
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

         AsciiPaint game=new AsciiPaint();
         Drawing drawing=new Drawing();
        Application controller=new Application(game,new AsciiView(drawing));
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
            command=keyboard.nextLine().toLowerCase();
            String [] tab=command.split(" ");


             if (command.equals("exit")) {
                isGameOver=true;
            }
            else if (tab.length==6&&tab[0].equals("add")&&tab[1].equals("circle")&& tab[2].matches("-?\\d+")
           && tab[3].matches("-?\\d+") && tab[4].matches("-?\\d+") && tab[5].matches("[a-z]")){
                paint.newCircle(Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),tab[5].charAt(0));
            }
            else if (tab.length==6&&tab[0].equals("add")&&tab[1].equals("square")&& tab[2].matches("-?\\d+")
                    && tab[3].matches("-?\\d+") && tab[4].matches("-?\\d+") && tab[5].matches("[a-z]")) {
                paint.newSquare(Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),tab[5].charAt(0));
                
            }
            else if (tab.length==7&&tab[0].equals("add")&&tab[1].equals("rectangle")&& tab[2].matches("-?\\d+")
                    && tab[3].matches("-?\\d+") && tab[4].matches("-?\\d+")&&tab[5].matches("-?\\d+") && tab[6].matches("[a-z]")) {
                System.out.println("add rectangle");
                paint.newRectangle(Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),Integer.parseInt(tab[5]),tab[6].charAt(0));
            }
            else if(command.equals("show")){
                view.display(new Drawing());

            }
            else{
                view.displayHelp();

            }

        }
        view.displayEnd();


        }






    }

