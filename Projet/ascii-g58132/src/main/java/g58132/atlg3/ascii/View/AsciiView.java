package g58132.atlg3.ascii.View;

import g58132.atlg3.ascii.Model.Drawing;
import g58132.atlg3.ascii.Model.Point;

/**
 * displayHelp(),display(Drawing d),asAsci() pas dans asciiPaint....
 **/
public class AsciiView {
private Drawing draws;
    /**
     * Constructor of AsciiView without parameter
     *
     * Allows to initialise the attributes to values.
     * @param draws is a drawing
     */
    public AsciiView(Drawing draws) {
        this.draws=draws;
    }

    /**
     * Display help
     */

    public void displayHelp() {
        System.out.println("The command entered is not valid!!!" +
                         "the commands used are ADD, SHOW,HELP, EXIT and with their parameters");
    }


    /**
     * Display of the shape
     *
     * @param drawing is a drawing
     */
    public void display(Drawing drawing) {
        for (int i = 0; i < drawing.getHeight(); i++) {
            for (int j = 0; j < drawing.getWidth(); j++) {
                Point pointShape = new Point(i, j);
                if (drawing.getShapeAt(pointShape) != null) {
                    System.out.print(drawing.getShapeAt(pointShape).getColor());
                }


            }
            System.out.println();
        }


    }

    /**
     * Display start of game
     */
    public void displayStartGame() {
        System.out.println("Welcome to the game of ASCIIPAINT");
    }

    /**
     * Display end of game
     */
    public void displayEnd() {
        System.out.println("*****End of game*****");
    }


}

