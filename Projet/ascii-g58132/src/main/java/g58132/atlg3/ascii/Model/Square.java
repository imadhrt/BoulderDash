package g58132.atlg3.ascii.Model;

public class Square extends Rectangle{

    public Square(Point upperLeft,double side,char color){
        super(upperLeft,side,side,color);
    }

    @Override
    public String toString() {
        return "Square";
    }
}
