package g58132.atlg3.ascii.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends ColoredShape{
    private List<Shape> shapes;

    public Group(char color,List<Shape> shapes1) {
        super(color);
        this.shapes = shapes1;

    }

    @Override
    public boolean inside(Point p) {
        for (var shape:shapes) {
            if(shape.inside(p)){
                return true;
            }

        }
        return false;
    }

    @Override
    public void move(double dx, double dy) {
        for (var shape:shapes){
             shape.move(dx,dy);
        }


    }


    @Override
    public String toString() {
        return "Group{" +
                "shapes=" + shapes.toString() +
                '}';
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public int shapePos(Shape shape){
        for (int i=0;i<shapes.size();i++){
            if(Objects.equals(shapes.get(i), shape)){
                return i;
            }
        }
        return -1;
    }
    public List<Integer> getShapeIntegerIndex(){
       List<Integer> list=new ArrayList<>();
        for (int i=0;i<getShapes().size();i++){
            list.add(shapePos(getShapes().get(i)));
        }
        return list;
    }
}
