package g58132.atlg3.ascii.Model;

import java.util.List;

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
}
