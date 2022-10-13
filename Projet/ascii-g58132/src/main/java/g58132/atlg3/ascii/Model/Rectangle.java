package g58132.atlg3.ascii.Model;

public class Rectangle  extends ColoredShape {
    private  Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor of the rectangle
     *
     * Allows to initialize the attributes to values.
     *
     * @param upperLeft is a point upper left
     * @param width is a width rectangle
     * @param height is a height rectangle
     * @param color is a color rectangle
     */
    public Rectangle(Point upperLeft, double width, double height,char color) {
        super(color);
        // vérifier width et height
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }



    public boolean inside(Point p) {

        return p.getX()>= upperLeft.getX() &&
                p.getY()<= upperLeft.getY() &&
                p.getX()<= upperLeft.getX()+height &&
                p.getY()>= upperLeft.getY()-width ;
    }


    public void move(double dx, double dy) {
        upperLeft.move(dx,dy);
    }


}
