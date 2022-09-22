package g58132.atlg3.ascii.Model;

public class Rectangle  implements Shape{
    private  Point upperLeft;
    private double widht;
    private double height;


    public Rectangle(Point upperLeft, double widht, double height,char color) {
        this.upperLeft = upperLeft;
        this.widht = widht;
        this.height = height;
    }

    public Rectangle() {
    }

    @Override
    public boolean inside(Point p) {
        return false;
    }

    @Override
    public void move(double dx, double dy) {

    }

    @Override
    public char getColor() {
        return 0;
    }
}
