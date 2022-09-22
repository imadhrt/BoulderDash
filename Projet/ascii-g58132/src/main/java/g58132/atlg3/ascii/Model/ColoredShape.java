package g58132.atlg3.ascii.Model;

public abstract  class ColoredShape {
    private char color;

    public ColoredShape(char color){
        this.color=color;
    }

    public char getColor() {
        return color;
    }

    private void setColor(char color) {
        this.color = color;
    }
}
