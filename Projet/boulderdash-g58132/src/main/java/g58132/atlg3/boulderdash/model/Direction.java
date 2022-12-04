package g58132.atlg3.boulderdash.model;

/**
 * Represents the direction of a player on the board.
 *
 * @author elhar
 */

public enum Direction {
    UP(-1, 0), DOWN(1, 0), RIGHT(0, 1), LEFT(0, -1);
    private int deltaRow;
    private int deltaColumn;

    /**
     * Constructor of Direction
     * <p>
     * Allows to initialize the deltadeltaRow and deltadeltaColumn attributes to values.
     *
     * @param deltaRow    is a deltaRow in the board
     * @param deltaColumn is a deltaColumn in the board
     */

    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }


    /**
     * Accessory of deltaRow
     * <p>
     * Allows access to the value of the deltaRow attribute.
     *
     * @return the value of the deltaRow attribute
     */


    public int getdeltaRow() {
        return deltaRow;
    }

    /**
     * Accessory of deltaColumn
     * <p>
     * Allows access to the value of the deltaColumn attribute.
     *
     * @return the value of the deltaColumn attribute
     */
    public int getdeltaColumn() {
        return deltaColumn;
    }
}
