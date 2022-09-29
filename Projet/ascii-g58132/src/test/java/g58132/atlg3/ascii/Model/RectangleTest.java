package g58132.atlg3.ascii.Model;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @org.junit.jupiter.api.Test
    void inside() {
        Rectangle r=new Rectangle(new Point(4,4),5,5,'c');
        boolean expResult=false;
        Point point=new Point(1,-1);
        boolean result=r.inside(point);
        assertEquals(expResult,result);
    }
}