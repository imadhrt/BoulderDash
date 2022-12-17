package g58132.atlg3.boulderdash.model;

public class Level {

    private int numberDiamondcollect;

    private int time;

    private Board board;

    /**
     * Accessor of the number of the diamond to collect
     * <p>
     * Allows access to the value of the number the diamond to collect attribute.
     *
     * @return a number the diamond to collect
     */
    public int getnumberDiamondcollect() {
        return numberDiamondcollect;
    }

    /**
     * Mutator of the number of the diamond to collect
     *
     * @param numberDiamondcollect is the number of the diamond to collect to pass to the next level
     */

    public void setnumberDiamondcollect(int numberDiamondcollect) {
        this.numberDiamondcollect = numberDiamondcollect;
    }

    /**
     * Accessor of time
     * <p>
     * Allows access to the value of the time attribute.
     *
     * @return the time maximum for one level
     */
    public int getTime() {
        return time;
    }

    /**
     * Mutator of time
     *
     * @param time the time maximum for one level
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Accessor of the board
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Mutator of the board
     *
     * @param board is a new board
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}
