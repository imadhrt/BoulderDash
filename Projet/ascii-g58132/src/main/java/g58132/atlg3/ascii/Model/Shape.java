package g58132.atlg3.ascii.Model;

public interface Shape{
    /**
     * In side
     *
     * Allows check if a given point is inside the shape.
     *
     * @param p is a point
     *
     * @return true if the point is inside the shape otherwise false
     */
    public boolean inside(Point p);
    /**
     *moving the point
     * Allows move the shape
     *
     * @param dx is an abscissa
     * @param dy is an ordinate
     */
        public void move(double dx,double dy);

    /**
     * Display a character
     *
     * @return the character of the display
     */
    public char getColor();
}
