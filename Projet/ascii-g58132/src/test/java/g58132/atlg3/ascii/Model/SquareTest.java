package g58132.atlg3.ascii.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void inside() {
        Point point=new Point(5,5);
        Square square=new Square(new Point(4,4),4,'s');
        boolean result=square.inside(point);
        boolean expresult=false;
        assertEquals(expresult,result);
    }
}