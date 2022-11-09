package g58132.atlg3.ascii.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AsciiPaint {
    private Drawing drawing;
    private Stack<Command> undoStack=new Stack();
    private Stack<Command> redoStack=new Stack();

    /**
     * Constructor of AsciiPaint without parameter
     *
     * Allows to initialise the attributes to values.
     */
    public AsciiPaint() {
        drawing=new Drawing();
    }
    /**
     * Constructor of AsciiPaint
     *
     * Allows to initialise the attributes to values.
     */
    public AsciiPaint(int width,int height){
        drawing=new Drawing(width,height);

    }
    public void undo(){
        if(!undoStack.isEmpty()){
            Command command=undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }
    public void redo(){
        if(!redoStack.isEmpty()){
            Command command=redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }


    /**
     * Add a new circle in the list of shape
     *
     * @param x is the abscissa of a point
     * @param y is the ordinate of a point
     * @param radius is a radius of the circle
     * @param color is a color circle
     */
    public void newCircle(int x,int y,double radius,char color){
        if (radius <= 0) {
            throw new IllegalArgumentException("the radius is not negative and null: " + radius);
        }
     var circle=(new Circle(new Point(x,y),radius,color));
        var command=new AddCommand(circle,drawing);
        command.execute();
        undoStack.push(command);
        redoStack.clear();;
    }
    /**
     * Add a new rectangle in the list of shape
     *
     * @param x is the abscissa of a point
     * @param y is the ordinate of a point
     * @param width  is a width of a rectangle
     * @param height  is a height of a rectangle
     * @param color is a color rectangle
     */
    public void newRectangle(int x,int y,double width,double height,char color){
        if(width<=0 || height<=0){
            throw new  IllegalArgumentException("the height mustn't be negative or null");
        }
        var rectangle=(new Rectangle(new Point(x,y),width,height,color));
        var command=new AddCommand(rectangle,drawing);
        command.execute();
        undoStack.push(command);
        redoStack.clear();;
    }
    /**
     * Add a new Square in the list of shape
     *
     * @param x is the abscissa of a point
     * @param y is the ordinate of a point
     * @param side  is a side of a square
     * @param color is a color square
     */

    public void newSquare(int x,int y,double side,char color){
        if(side<=0 ){
            throw new  IllegalArgumentException("the height mustn't be negative or null");
        }
       var shape=(new Square(new Point(x,y),side,color));
        var command=new AddCommand(shape,drawing);
        command.execute();
        undoStack.push(command);
        redoStack.clear();;
    }

    /**
     * Add a new Group in the list of shape
     *
     * @param color is a color of Group
     */
    public void newGroup(char color, List<Integer> indexShape){

        List<Shape> groupShape=new ArrayList();
        for (int i=0;i<indexShape.size();i++){
            groupShape.add(drawing.getShapeAtIndex(indexShape.get(i)));

        }
        Group group=new Group(color,groupShape);




        while(!indexShape.isEmpty()){
            int nb = Collections.max(indexShape);
            drawing.remove(nb);
            indexShape.remove((Integer) nb);
        }
        var command=new AddCommand(group,drawing);
        command.execute();
        undoStack.push(command);
        redoStack.clear();;

    }

    public void newLine(int depart_x,int depart_y,int arrive_x,int arrive_y,char color){
       var line=(new Line(new Point(depart_x,depart_y),new Point(arrive_x,arrive_y),color));
        var command=new AddCommand(line,drawing);
        command.execute();
        undoStack.push(command);
        redoStack.clear();


    }
    public void newList(){
        drawing.displayDrawing();


    }

    public void newDelete(int pos){
        drawing.delete(pos);
    }

    public void newMove(int pos,int x,int y){
        drawing.moveShape(pos,x,y);
    }

    public void  newColor(int pos,char color){
       drawing.changeColor(pos,color);
    }








    /**
     * Accessor of the drawing
     *
     * Allows access to the value of the drawing attribute.
     *
     * @return the value of the drawing
     */
    public Drawing getDrawing() {
        return drawing;
    }
}

