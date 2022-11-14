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
    public int sizeShapes(){
        return shapes.size();
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
        if(shapes.size()-1<index){
           throw new  IllegalArgumentException("the shape at the index "+index+" doesn't exist!!!!!!! ");
        }
        return shapes.get(index);
    }
   void remove(int i){
        shapes.remove(i);
   }

   public void displayDrawing(){
        for (int i=0;i<shapes.size();i++){
            System.out.println(i+")"+shapes.get(i).toString());
        }

   }
    public void addShape(Shape shape, int pos) {
        shapes.add(pos,shape);
    }
    public int shapePos(Shape shape){
        for (int i=0;i<shapes.size();i++){
            if(shapes.get(i).equals(shape)){
                return i;
            }
        }
        return -1;
    }

   public void delete(int pos){

        shapes.remove(pos);

    }

   public void moveShape(int pos,int x,int y){
       if(shapes.size()-1<pos){
           throw new  IllegalArgumentException("the shape at the index "+pos+" doesn't exist ");
       }
        shapes.get(pos).move(x,y);
   }


   public void remove(Shape shape){
        shapes.remove(shape);

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
