package g58132.atlg3.ascii.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void inside() {
        Circle circle=new Circle(new Point(0,0),5,'r');
        Point point=new Point(5,-1);
        boolean expresult=false;
        boolean result=circle.inside(point);
        assertEquals(expresult,result);
    }
}