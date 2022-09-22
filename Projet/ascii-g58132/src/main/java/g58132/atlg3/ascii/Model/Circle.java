package g58132.atlg3.ascii.Model;

public class Circle  implements Shape{

private Point center;
private double radius;

public  Circle(Point center, double radius, char color){
    this.center=center;
    this.radius=radius;

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
