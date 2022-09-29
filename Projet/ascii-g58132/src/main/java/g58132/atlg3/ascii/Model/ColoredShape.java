package g58132.atlg3.ascii.Model;

public abstract class ColoredShape implements Shape {
    private char color;

    /**
     * Constructor of the colored shape
     *
     * Allows to initialize the color attribute to value.
     *
     * @param color is a color of the shape
     */
    public ColoredShape(char color){
        this.color=color;
    }

    /**
     * Accessor
     *
     * Allows access to the value of the color attribute.
     *
     * @return the value of the color
     */
    public char getColor() {
        return color;
    }

    /**
     * Mutator
     *
     * Allows set the color with the given value in parameter.
     *
     * @param color is a color of the shape
     */

    public void setColor(char color) {
        this.color = color;
    }
}
