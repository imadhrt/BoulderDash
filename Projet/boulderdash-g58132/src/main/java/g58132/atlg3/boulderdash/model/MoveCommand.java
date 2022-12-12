package g58132.atlg3.boulderdash.model;

import java.util.ArrayList;
import java.util.List;

public class MoveCommand implements Command {
    private Element[][] element;
    private Direction direction;
    private BoulderDash boulderDash;

    public MoveCommand(Direction direction, BoulderDash boulderDash) {
        this.element = copyDefensiveBoard(boulderDash.getLevel().getLevel().getBoard().getBoard());
        this.direction = direction;
        this.boulderDash = boulderDash;
    }

    public Element[][] copyDefensiveBoard(Element[][] element) {
        Element[][] copyElement = new Element[element.length][element[0].length];
        List<Element> list=new ArrayList<>();
        List<Element> listeCopy;
        for (var e:element) {
            for (var i:e) {
                list.add(i);
            }

        }

        listeCopy=  (ArrayList<Element>) ((ArrayList<Element>) list).clone();
        for (int i=0;i<copyElement.length;i++) {
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
        boulderDash.playMove(direction);
    }

    @Override
    public void unexecute() {


        for (int i = 0; i < element.length; i++) {
         for (int j = 0; j < element[0].length; j++) {
        boulderDash.getLevel().getLevel().getBoard().setElement(element[i][j].getElement(),new Position(i,j));
         }
    }
           }

}
