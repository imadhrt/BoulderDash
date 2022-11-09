package g58132.atlg3.ascii.Model;

public class ChangeColorCommand implements  Command{
    private char newColor;
    private char oldColor;
    private Shape shape;

    public ChangeColorCommand(char newColor, char oldColor, Shape shape) {
        this.newColor = newColor;
        this.oldColor = oldColor;
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
