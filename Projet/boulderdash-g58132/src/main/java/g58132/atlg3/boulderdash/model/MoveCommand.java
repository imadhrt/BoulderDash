package g58132.atlg3.boulderdash.model;

import java.util.ArrayList;
import java.util.List;

public class MoveCommand implements Command {
    private Element[][] element;
    private Direction direction;
    private BoulderDash boulderDash;
    private int nbDiamond;

    /**
     * Constructor of the moveCommand
     *
     * @param direction   is a direction in which the player wants to move
     * @param boulderDash is a facade of the game
     */
    public MoveCommand(Direction direction, BoulderDash boulderDash) {
        this.element = copyDefensiveBoard(boulderDash.getLevel().getLevel().getBoard().getBoard());
        this.direction = direction;
        this.boulderDash = boulderDash;
      var rockFord=boulderDash.getLevel().getLevel().getBoard().getRockford();
      if(rockFord!=null) {
          nbDiamond =rockFord.getNbDiamand();
      }
    }

    /**
     * Allows to copy the board by value and not by reference
     *
     * @param element is an array of element
     * @return a new array of element
     */
    private Element[][] copyDefensiveBoard(Element[][] element) {
        Element[][] copyElement = new Element[element.length][element[0].length];
        List<Element> list = new ArrayList<>();
        List<Element> listeCopy;
        for (var e : element) {
            for (var i : e) {
                list.add(i);
            }

        }

        listeCopy = (ArrayList<Element>) ((ArrayList<Element>) list).clone();
        for (int i = 0; i < copyElement.length; i++) {
            for (int j = 0; j < copyElement[0].length; j++) {
                copyElement[i][j] = listeCopy.get(j);

            }
            for (int v = copyElement[0].length - 1; v >= 0; v--) {
                listeCopy.remove(v);
            }
        }


        return copyElement;
    }

    @Override
    public void execute() {

        var board = boulderDash.getLevel().getLevel().getBoard();
        board.movePlayer(direction);
        boulderDash.createExit();
        board.moveDiamondOrRock();
        boulderDash.winOrLoselevel();
        boulderDash.lose();
        boulderDash.winAllLevel();
    }

    @Override
    public void unexecute() {

        for (int i = 0; i < element.length; i++) {
            for (int j = 0; j < element[0].length; j++) {
                boulderDash.getLevel().getLevel().getBoard().setElement(element[i][j].getElement(), new Position(i, j));
            }
        }
        var rockford=boulderDash.getLevel().getLevel().getBoard().getRockford();
        if(rockford!=null){
            rockford.setNbDiamand(nbDiamond);
        }
    }

}
