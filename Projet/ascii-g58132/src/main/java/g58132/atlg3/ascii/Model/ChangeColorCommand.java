package g58132.atlg3.ascii.Model;

public class ChangeColorCommand implements  Command{
    private char newColor;
    private char oldColor;

    private Shape shape;

    public ChangeColorCommand(char newColor, Shape shape) {
        this.newColor = newColor;
        this.oldColor = shape.getColor();
        this.shape = shape;
    }

    @Override
    public void execute() {

        shape.setColor(newColor);
    }

    @Override
    public void unexecute() {
        shape.setColor(oldColor);

    }
}
