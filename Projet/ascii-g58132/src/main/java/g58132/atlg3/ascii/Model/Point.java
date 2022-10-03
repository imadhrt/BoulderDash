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
        this(p.getX(),p.getY());

    }

    /**
     * Accessor
     *
     * Allows access to the value of the x attribute.
     *
     * @return the value of the x attribute.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Accessor
     *
     * Allows access to the value of the y attribute.
     *
     * @return the value of the y attribute.
     */
    public double getY(){
        return this.y;
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
        this.x+=dx;
        this.y+=dy;

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
        return Math.sqrt((Math.pow(point.getX()-getX(),2))+ (Math.pow(point.getY()-getY(),2)));
//        return Math.sqrt(((point.getX()-getX())*(point.getX()-getX())) + ((point.getY()-getY())*(point.getY()-getY())));
    }
}

