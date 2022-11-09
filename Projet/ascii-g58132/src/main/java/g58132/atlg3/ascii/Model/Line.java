package g58132.atlg3.ascii.Model;

public class Line extends ColoredShape {
    private Point  point_depart;
    private Point point_arrive;

    public Line(Point point_depart,Point point_arrive,char color) {
        super(color);
        this.point_depart=point_depart;
        this.point_arrive=point_arrive;
    }

    @Override
    public boolean inside(Point p) {
        double m= ((point_arrive.getY()-point_arrive.getX())/ point_depart.getY()- point_depart.getX());
        return Math.abs((m*p.getX()-p.getY()-m* point_depart.getX()+ point_depart.getY())/Math.sqrt(Math.pow(m,2)+1))<0.1;
    }

    @Override
    public void move(double dx, double dy) {
        point_depart.move(dx,dy);

    }
    @Override
    public String toString() {
        return "Circle " + point_depart.getX() +"  "+point_depart.getY()+"  "+ point_arrive.getX() +"  "+point_arrive.getY()+ "  "+getColor();
    }
}
