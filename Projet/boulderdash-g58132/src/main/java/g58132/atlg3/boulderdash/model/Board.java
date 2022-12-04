package g58132.atlg3.boulderdash.model;

import java.util.Arrays;

public class Board {
    private Element[][] board;


    /**
     * Constructor the board
     *
     * @param height is a height of the level
     * @param width  is a width of the level
     */
    public Board(int height, int width) {

        this.board = new Element[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Element();
            }
        }
    }

    /**
     * Accessor of board
     * <p>
     * Allows access to the value of the board attribute.
     *
     * @return an array of element
     */
    public Element[][] getBoard() {
        return board;
    }

    /**
     * @param position
     * @return
     */
    public Element getElement(Position position) {
        if (!containsBoard(position)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }

        return board[position.getRow()][position.getColumn()].getElement();
    }

    /**
     * Checks position on the board
     *
     * @param pos is a position
     * @return true if the position is on the board and false if the position is
     * not on the board
     */

    public boolean containsBoard(Position pos) {
        return ((pos.getRow() >= 0 && pos.getRow() <= board.length - 1) && (pos.getColumn() >= 0
                && pos.getColumn() <= board[0].length));

    }

    /**
     * Mutator element
     * <p>
     * Allows to place the element at the position on the board
     *
     * @param element is an element that we put on the board
     * @param pos     is a position
     * @throw pos if the position is not on the board
     */
    public void setElement(Element element, Position pos) {
        if (!containsBoard(pos)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        this.board[pos.getRow()][pos.getColumn()] = new Element(element);
    }

    /**
     * Allows to check if the movement du player is valid
     *
     * @param pos is a position
     * @return true if the movement is valid otherwhise false
     * @throw pos if the position is not on the board
     */

    public boolean isValideMove(Position pos) {
        if (!containsBoard(pos)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        return !(this.board[pos.getRow()][pos.getColumn()].getElement() instanceof Wall) && !(this.board[pos.getRow()][pos.getColumn()].getElement() instanceof Rock);
    }

    /**
     * Drop element
     * <p>
     * Allows remove the element at a given position and set to null.
     *
     * @param position is a position
     * @throw position if the position is not on the board
     */
    public void dropElement(Position position) {
        setElement(null, position);
    }

    /**
     * allows the player's position to be known
     * <p>
     * //     * @param player is a Rockford
     *
     * @return the position of the player if he found otherwhise null
     */
    public Position getPositionOfPlayer() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getElement() instanceof Rockford) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    public boolean isPushRock(Position position, Position position2) {
        if (!containsBoard(position) || !containsBoard(position2)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        return this.board[position.getRow()][position.getColumn()].getElement() instanceof Rock && this.board[position2.getRow()][position2.getColumn()].getElement() == null;
    }
//    public Element getPlayer() {
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j].getElement() instanceof Rockford) {
//                    return board[i][j].getElement();
//                }
//            }
//        }
//        return null;
//    }
//    public void movePlayer(Direction direction){
//        var oldpos=getPositionOfPlayer();
//        var newPos=getPositionOfPlayer().next(direction);
//
//        if(isValideMove(newPos)){
//            dropElement(newPos);
//            setElement(getPlayer(),newPos);
//            dropElement(oldpos);
//        }
//    }

    /**
     * Equals
     * Allows to compare if the two objects are equals.
     *
     * @param o is an object
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        return Arrays.deepEquals(board, board1.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
