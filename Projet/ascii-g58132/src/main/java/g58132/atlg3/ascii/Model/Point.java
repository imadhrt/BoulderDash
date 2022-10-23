package g58132.atlg3.ascii.Model;

public class Point{
    private double x;
    private double y;

    /**
     * Constructor of Point
     *
     * Allows to initialize the x and y attributes to values.
     *
     * @param x is the abscissa of a point
     * @param y is the ordinate of a point
     */
    public Point(double x, double y) {
        if(x<0 || y<0) {
            throw new IllegalArgumentException("The point must not be negative");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor of point
     *
     * Allows to initialize the p to value.
     * By calling on the other constructor.
     *
     * @param p is a point
     */
    public Point (Point p){
        this(p.x,p.y);

    }

    /**
     * Accessor
     *
     * Allows access to the value of the x attribute.
     *
     * @return the value of the x attribute.
     */
    public double getX() {
        return x;
    }

    /**
     * Accessor
     *
     * Allows access to the value of the y attribute.
     *
     * @return the value of the y attribute.
     */
    public double getY(){
        return y;
    }

    /**
     * Moving the point
     *
     * Allows move the shape.
     *
     * @param dx is a new abscissa
     * @param dy is a new ordinate
     */
    public void move(double dx,double dy){
        x+=dx;
        y+=dy;
    }

    /**
     *Distance to
     *
     * Allows to have the distance between the current point and new point.
     * @param point is a new point.
     *
     * @return the distance between two points.
     */
    public double distanceTo(Point point ){
        return Math.sqrt((Math.pow(point.x - this.x, 2))
                + (Math.pow(point.y - this.y, 2)));
    }
}

