package g58132.atlg3.ascii.Model;

public class AsciiPaint {
    private Drawing drawing;

    /**
     * Constructor of AsciiPaint without parameter
     *
     * Allows to initialise the attributes to values.
     */
    public AsciiPaint() {
        drawing=new Drawing();
    }
    /**
     * Constructor of AsciiPaint
     *
     * Allows to initialise the attributes to values.
     */
    public AsciiPaint(int width,int height){
        drawing=new Drawing(width,height);

    }

    /**
     * Add a new circle in the list of shape
     *
     * @param x is the abscissa of a point
     * @param y is the ordinate of a point
     * @param radius is a radius of the circle
     * @param color is a color circle
     */
    public void newCircle(int x,int y,double radius,char color){
       drawing.addShape(new Circle(new Point(x,y),radius,color));
    }
    /**
     * Add a new rectangle in the list of shape
     *
     * @param x is the abscissa of a point
     * @param y is the ordinate of a point
     * @param width  is a width of a rectangle
     * @param height  is a height of a rectangle
     * @param color is a color rectangle
     */
    public void newRectangle(int x,int y,double width,double height,char color){
        drawing.addShape(new Rectangle(new Point(x,y),width,height,color));
    }
    /**
     * Add a new Square in the list of shape
     *
     * @param x is the abscissa of a point
     * @param y is the ordinate of a point
     * @param side  is a side of a square
     * @param color is a color square
     */

    public void newSquare(int x,int y,double side,char color){
        drawing.addShape(new Square(new Point(x,y),side,color));
    }

    /**
     * Accessor of the drawing
     *
     * Allows access to the value of the drawing attribute.
     *
     * @return the value of the drawing
     */
    public Drawing getDrawing() {
        return drawing;
    }
}

