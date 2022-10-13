package g58132.atlg3.ascii.Model;


public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    /**
     * Constructor of the square
     * <p>
     * Allows to initialize the attributes to values.
     *
     * @param center is a center of circle
     * @param radius is a radius of circle
     * @param color  is a color the shape
     */

    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("the radius is not negative and null: " + radius);
        }
        this.center = center;
        this.radius = radius;

    }

    public boolean inside(Point p) {
        return center.distanceTo(p) <= radius;
    }

    public void move(double dx, double dy) {
        center.move(dx, dy);
    }


}
