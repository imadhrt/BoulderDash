package g58132.atlg3.ascii.Model;

import java.util.ArrayList;
import java.util.List;


public class Drawing {
    private List<Shape> shapes;
    private int height;
    private int width;
    /**
     * Constructor of AsciiPaint without parameter
     *
     * Allows to initialise the attributes to values by default.
     */

    public Drawing(){
        this(50,50);

    }
    /**
     * Constructor of Drawing
     *
     * Allows to initialise the attributes to values.
     */

    public Drawing(int width,int height) {
        this.width = width;
        this.height = height;
        shapes=new ArrayList();

    }

    /**
     * Add a shape in the list
     * @param shape is  a shape(rectangle,square,circle)
     */
    public void addShape(Shape shape){
        shapes.add(shape);

    }

    /**
     * get shape at
     *
     * Allows to check if a given point ,there are a shape
     *
     * @param p is a point
     * @return the shape if it finds at the given position otherwise null
     */
    public Shape getShapeAt(Point p){
        for (int i=0;i<shapes.size();i++){
            if(shapes.get(i).inside(p)){
                return shapes.get(i);

            }
        }

        return null;
    }
    /**
     * Accessor of the height
     *
     * Allows access to the value of the height attribute.
     *
     * @return the value of the height
     */
    public int getHeight(){
        return this.height;
    }
    /**
     * Accessor of the width
     *
     * Allows access to the value of the width attribute.
     *
     * @return the value of the width
     */
    public int getWidth(){
        return this.width;
    }
}
