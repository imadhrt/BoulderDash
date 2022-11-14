package g58132.atlg3.ascii.Model;

public class MoveCommande implements Command {
    private int pos;
    private int x;
    private int y;
    private Shape shape;
    private Drawing drawing;


    public MoveCommande(int pos, int x, int y,Drawing drawing) {
        this.drawing = drawing;
        this.x = x;
        this.y = y;
        this.shape= drawing.getShapeAtIndex(pos);
    }

    @Override
    public void execute() {
        drawing.moveShape(pos,x,y);
    }

    @Override
    public void unexecute() {
        drawing.moveShape(pos,-x,-y);
    }
}
