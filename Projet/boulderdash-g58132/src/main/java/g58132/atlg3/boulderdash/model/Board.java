package g58132.atlg3.boulderdash.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * Allows access to an element of the board
     *
     * @param position is a position
     * @return an element du board
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

    private boolean isValideMove(Position pos) {
        if (!containsBoard(pos)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        return !(getElement(pos) instanceof Wall) && !(getElement(pos) instanceof Rock );
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
     *
     * @return the position of the player if he found otherwhise null
     */
    public Position getPositionOfPlayer() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (getElement(new Position(i, j)) instanceof Rockford) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    /**
     * Get RockFord
     *
     * @return the RockFord from the board
     */
    public Rockford getRockford() {
        if(getPositionOfPlayer()==null){
           return null;
        }
        return (Rockford) getElement(getPositionOfPlayer());
    }

    /**
     * Allows to check if the player can push a rock
     *
     * @param position  is a position where there are the rock
     * @param position2 is a position where there are empty
     * @return true if the player can push the rock otherwhise false
     * @throw pos if the position is not on the board
     */
    private boolean isPushRock(Position position, Position position2) {
        if (!containsBoard(position) || !containsBoard(position2)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        return getElement(position) instanceof Rock && getElement(position2) == null;
    }
    /**
     * Get all diamonds and rocks of the level
     *
     * @return all diamond and rocks positions of a board
     */
    private List<Position> getAllRockOrDiamond(){
        List<Position> liste = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((getElement(new Position(i, j)) instanceof Rock)||(getElement(new Position(i, j)) instanceof Diamond)) {
                    liste.add(new Position(i, j));
                }
            }
        }
        return liste;
    }

    /**
     * Allows to check if the element can fall
     *
     * @param position is a position
     * @return true if an element at a given position is empty
     * @throw pos if the position is not on the board
     */
    private boolean isCheckFallDown(Position position) {
        if (!containsBoard(position) || !containsBoard(position.next(Direction.DOWN))) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        return getElement(position.next(Direction.DOWN)) == null;
    }

    /**
     * Allows to move the player,increase the number of
     * diamonds collected
     *
     * @param direction is a direction in which the player wants to move
     */
    public void movePlayer(Direction direction) {

        var oldpos = getPositionOfPlayer();
        if (!containsBoard(oldpos)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        var newPos = oldpos.next(direction);
        if (!containsBoard(newPos)) {
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }

        // la logique dans Board ?
        if (getElement(newPos) instanceof Diamond) {
            getRockford().setNbDiamand(getRockford().getNbDiamand() + 1);

        }

        if (isValideMove(newPos)) {
            dropElement(newPos);
            setElement(getElement(oldpos), newPos);
            dropElement(oldpos);

        } else if ((direction==Direction.RIGHT || direction==Direction.LEFT)&&isPushRock(newPos, newPos.next(direction))) {
            setElement(getElement(newPos), newPos.next(direction));
            dropElement(newPos);
            setElement(getElement(oldpos), newPos);
            dropElement(oldpos);
        }
    }

    /**
     * Allows to fall the diamonds or rocks
     */
    public void moveDiamondOrRock(){
        for (int i = getAllRockOrDiamond().size() - 1; i >= 0; i--) {
            var pos = getAllRockOrDiamond().get(i);
            while (isCheckFallDown(pos)) {
                setElement(getElement(pos), pos.next(Direction.DOWN));
                dropElement(pos);
                pos = pos.next(Direction.DOWN);
                if (getElement(pos.next(Direction.DOWN)) instanceof Rockford) {
                    setElement(null, pos.next(Direction.DOWN));

                }
            }
            while ((getElement(pos.next(Direction.RIGHT)) == null && getElement(pos.next(Direction.DOWN)) instanceof Rock && getElement(pos.next(Direction.RIGHT).next(Direction.DOWN)) == null) ||
                    (getElement(pos.next(Direction.LEFT)) == null && getElement(pos.next(Direction.DOWN)) instanceof Rock && getElement(pos.next(Direction.LEFT).next(Direction.DOWN)) == null)) {
                if (getElement(pos.next(Direction.RIGHT)) == null && getElement(pos.next(Direction.DOWN)) instanceof Rock && getElement(pos.next(Direction.RIGHT).next(Direction.DOWN)) == null) {
                    setElement(getElement(pos), pos.next(Direction.RIGHT));
                    dropElement(pos);
                    pos = pos.next(Direction.RIGHT);
                }
                else if (getElement(pos.next(Direction.LEFT)) == null && getElement(pos.next(Direction.DOWN)) instanceof Rock && getElement(pos.next(Direction.LEFT).next(Direction.DOWN)) == null) {
                    setElement(getElement(pos), pos.next(Direction.LEFT));
                    dropElement(pos);
                    pos = pos.next(Direction.LEFT);
                }
                while (isCheckFallDown(pos)) {
                    setElement(getElement(pos), pos.next(Direction.DOWN));
                    dropElement(pos);
                    pos = pos.next(Direction.DOWN);
                if (getElement(pos.next(Direction.DOWN)) instanceof Rockford) {
                    setElement(null, pos.next(Direction.DOWN));

                }
                }
            }
        }

    }


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
