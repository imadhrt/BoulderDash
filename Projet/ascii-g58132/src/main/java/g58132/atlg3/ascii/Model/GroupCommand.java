package g58132.atlg3.ascii.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupCommand implements Command{
    private Drawing drawing;
  private  List<Integer> indexShape;
  private List<Shape> groupShape=new ArrayList<>();

  
  private char color;


  public GroupCommand(Drawing drawing, List<Integer> indexShape, char color) {
    this.drawing = drawing;
    this.indexShape = indexShape;
    this.color = color;
    for (int i=0;i<indexShape.size();i++){
      groupShape.add(drawing.getShapeAtIndex(indexShape.get(i)));

    }

  }

  @Override
    public void execute() {

    Group group=new Group(color,groupShape);

//    while(!indexShape.isEmpty()){
//      int nb = Collections.max(indexShape);
//      drawing.remove(nb);
//      indexShape.remove((Integer) nb);
//    }
    Collections.sort(indexShape);//pour supprimer du plus grand au plus petit
    for (int i= indexShape.size()-1;i>=0;i--){
      drawing.remove(indexShape.get(i));
    }
    drawing.addShape(group);

    }

    @Override
    public void unexecute() {
    drawing.remove(drawing.sizeShapes()-1);
    for (int i=0;i<indexShape.size();i++){
      drawing.addShape(groupShape.get(i), indexShape.get(i));
    }

    }
}
