package g58132.atlg3.ascii.Model;

import g58132.atlg3.ascii.Model.Drawing;

public class AsciiPaint {
    private Drawing drawing;

    public AsciiPaint() {
        drawing=new Drawing();
    }

    public AsciiPaint(int width,int height){
        drawing=new Drawing(width,height);

    }
    public void newCircle(int x,int y,double radius,char color){
       drawing.addShape(new Circle(new Point(x,y),radius,color));
    }
}

