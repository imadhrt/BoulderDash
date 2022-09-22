package g58132.atlg3.ascii.Model;

public interface Shape {
    public boolean inside(Point p);
        public void move(double dx,double dy);
    public char getColor();
}
