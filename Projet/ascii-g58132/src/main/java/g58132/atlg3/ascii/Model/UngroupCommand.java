package g58132.atlg3.ascii.Model;

import java.util.Collections;
import java.util.List;

public class UngroupCommand implements  Command {

    private Group group;
    private Drawing drawing;
    private List<Integer> indexShape;
            ;
    private List<Shape> shape;
    private int pos;
    private Shape shapeGroup;
    public UngroupCommand(Group group, Drawing drawing,int pos,List<Integer> indexShape){
        this.group = group;
        this.drawing = drawing;
        this.pos=pos;
         this.shapeGroup=drawing.getShapeAtIndex(pos);
        this.shape =group.getShapes();
        this.indexShape=indexShape;

    }

    @Override
    public void execute() {
      drawing.remove(pos);
        for (int i=0;i<indexShape.size();i++){
            drawing.addShape(shape.get(i), indexShape.get(i));
        }


    }

    @Override
    public void unexecute() {
        Collections.sort(indexShape);
        for (int i= indexShape.size()-1;i>=0;i--){
            drawing.remove(indexShape.get(i));
        }

        drawing.addShape(shapeGroup,pos);


    }
}
