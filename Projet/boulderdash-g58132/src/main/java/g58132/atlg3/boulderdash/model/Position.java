package g58132.atlg3.boulderdash.model;

public class Position {

    private final int row;
    private final int column;

    /**
     * Constructor of position
     * <p>
     * Allows to initialize the row and column attributes to values.
     *
     * @param row    is a position on the board
     * @param column is a position on the board
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Accessory of row
     * <p>
     * Allows access to the value of the row attribute.
     *
     * @return the value of the row attribute
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Accessory of column
     * <p>
     * Allows access to the value of the column attribute.
     *
     * @return the value of the column attribute
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * New position of the piece
     *
     * @param direction is the direction of the piece
     * @return a new position on the board
     */
    public Position next(Direction direction) {

        return new Position(this.row + direction.getdeltaRow(), this.column + direction.getdeltaColumn());
    }


}
