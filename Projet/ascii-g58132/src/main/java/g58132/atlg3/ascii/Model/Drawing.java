package g58132.atlg3.ascii.Model;

import java.util.List;

public class Drawing {
    private List<Shape> shapes;
    private int height;
    private int width;

    public Drawing(){
        this(0,0);

    }

    public Drawing(int width,int height) {
        this.width = width;
        this.height = height;

    }
    public void addShape(Shape shape){

    }
    public Shape getShapeAt(Point p){

        return null;
    }
    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }
}
