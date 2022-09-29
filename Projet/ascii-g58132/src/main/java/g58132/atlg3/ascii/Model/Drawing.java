package g58132.atlg3.ascii.Model;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<Shape> shapes;
    private int height;
    private int width;

    public Drawing(){
        this(50,50);

    }

    public Drawing(int width,int height) {
        this.width = width;
        this.height = height;
        shapes=new ArrayList<>();

    }
    public void addShape(Shape shape){
        shapes.add(shape);

    }
    public Shape getShapeAt(Point p){
        for (int i=0;i<shapes.size();i++){
            if(shapes.get(i).inside(p)){
                return shapes.get(i);

            }
        }

        return null;
    }
    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }
}
