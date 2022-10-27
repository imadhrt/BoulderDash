package g58132.atlg3.ascii.Model;

import java.util.ArrayList;
import java.util.List;


public class Drawing {
    private static final int DEFAULT_HEIGHT = 50;
    private static final int DEFAULT_WIDTH = 50;
    private List<Shape> shapes;
    private int height;
    private int width;

    /**
     * Constructor of AsciiPaint without parameter
     * <p>
     * Allows to initialise the attributes to values by default.
     */

    public Drawing() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    }

    /**
     * Constructor of Drawing
     * <p>
     * Allows to initialise the attributes to values.
     */

    public Drawing(int width, int height) {
        this.width = width;
        this.height = height;
        shapes = new ArrayList();

    }

    /**
     * Add a shape in the list
     *
     * @param shape is  a shape(rectangle,square,circle)
     */
    void addShape(Shape shape) {
        shapes.add(shape);

    }

    /**
     * get shape at
     * <p>
     * Allows to check if a given point ,there are a shape
     *
     * @param p is a point
     * @return the shape if it finds at the given position otherwise null
     */
    public Shape getShapeAt(Point p) {
//        for (int i=0;i<shapes.size();i++){ // foreach
//            if(shapes.get(i).inside(p)){
//                return shapes.get(i);
//
//            }

        for (var e : shapes) {
            if (e.inside(p)) {
                return e;
            }

        }

        return null;
    }
    Shape getShapeAtIndex(int index){
        return shapes.get(index);
    }
   void remove(int i){
        shapes.remove(i);
   }
    /**
     * Accessor of the height
     * <p>
     * Allows access to the value of the height attribute.
     *
     * @return the value of the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Accessor of the width
     * <p>
     * Allows access to the value of the width attribute.
     *
     * @return the value of the width
     */
    public int getWidth() {
        return width;
    }
}
