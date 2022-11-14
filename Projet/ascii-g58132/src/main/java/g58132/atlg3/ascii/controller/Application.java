package g58132.atlg3.ascii.controller;

import g58132.atlg3.ascii.Model.AsciiPaint;
import g58132.atlg3.ascii.View.AsciiView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private AsciiPaint paint;
    private AsciiView view;

    private final static String ADD_CIRCLE = "\\s*add\\s*circle\\s*\\d+\\s*\\d+\\s*\\d+\\s*[a-z]\\s*";
    private final static String ADD_SQUARE = "\\s*add\\s*square\\s*\\d+\\s*\\d+\\s*\\d+\\s*[a-z]\\s*";
    private final static String ADD_RECTANGLE = "\\s*add\\s*rectangle\\s*\\d+\\s*\\d+\\s*\\d+\\s*\\d+\\s*[a-z]\\s*";
    private final static String ADD_LINE = "\\s*add\\s*line\\s*\\d+\\s*\\d+\\s*\\d+\\s*\\d+\\s*[a-z]\\s*";

    private final static String GROUP = "\\s*group\\s*[a-z]\\s*(\\d+\\s*)*";
    private final static String UNGROUP = "\\s*ungroup\\s*\\d+\\s*";
    private final static String DELETE="\\s*delete\\s*\\d+\\s*";
    private  final  static  String COLOR="\\s*color\\s*\\d+\\s*[a-z]\\s*";
    private final static String MOVE="move\\s*\\d+\\s*\\d+\\s*\\d+\\s*";
    private  final static String EXIT="\\s*exit\\s*";
    private  final  static  String HELP="\\s*help\\s*";
    private  final  static  String SHOW="\\s*show\\s*";
    private  final  static  String LIST="\\s*list\\s*";
    private  final  static  String UNDO="\\s*undo\\s*";
    private  final  static  String REDO="\\s*redo\\s*";


    /**
     * Constructor of Application
     * <p>
     * Allows to initialise the attributes to values.
     *
     * @param paint is a view of the shape
     * @param view  is a view
     */
    public Application(AsciiPaint paint, AsciiView view) {
        this.paint = paint;
        this.view = view;
    }


    public static void main(String[] args) {
        /** Faire une boucle tant que le joueur veut continuer,je demande lequel il veut (add show,help) si il veut
         * arreter console exit  **/
        AsciiPaint paint = new AsciiPaint(100, 100);
        AsciiView view = new AsciiView(paint);

        Application controller = new Application(paint, view);
        controller.start();


    }

    /**
     * Start the game
     */
    public void start() {
        Scanner keyboard = new Scanner(System.in);
        view.displayStartGame();
        String command;
        boolean isGameOver = false;


        while (!isGameOver) {
            try {
                view.enterCommand();
                command = keyboard.nextLine().toLowerCase();
                String[] tab = command.trim().split("\\s+");


                if (command.matches(EXIT)) {
                    isGameOver = true;
                } else if (command.matches(ADD_CIRCLE)) {


                    paint.newCircle(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]), tab[5].charAt(0));

                } else if (command.matches(ADD_SQUARE)) {

                    paint.newSquare(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]), tab[5].charAt(0));

                } else if (command.matches(ADD_RECTANGLE)) {
                    paint.newRectangle(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]), Integer.parseInt(tab[5]), tab[6].charAt(0));
                } else if (command.matches(MOVE)) {
                    paint.newMove(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]), Integer.parseInt(tab[3]));

                } else if (command.matches(ADD_LINE)) {
                    paint.newLine(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]), Integer.parseInt(tab[5]), tab[6].charAt(0));


                } else if (tab.length > 3 && command.matches(GROUP)) {
                    List<Integer> liste = new ArrayList<>();
                    for (int i = 2; i < tab.length ; i++) {
                        liste.add(Integer.parseInt(tab[i]));

                    }

                    paint.newGroup(tab[1].charAt(0), liste);

                } else if (command.matches(UNGROUP)) {
//                    paint.newUngroup(Integer.parseInt(tab[1]));

                } else if (command.matches(LIST)) {
                    paint.newList();

                } else if (command.matches(SHOW)) {
                    view.display(paint.getDrawing());

                } else if (command.matches(DELETE)) {
                    paint.newDelete(Integer.parseInt(tab[1]));

                } else if (command.matches(COLOR)) {
                    paint.newColor(Integer.parseInt(tab[1]),tab[2].charAt(0));

                } else if (command.matches(UNDO)) {
                    paint.undo();

                } else if (command.matches(REDO)) {
                    paint.redo();

                } else if (command.matches((HELP))) {
                   view.help();

                } else {
                    view.displayError();

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                view.displayError();


            }

        }
        view.displayEnd();


    }


}

