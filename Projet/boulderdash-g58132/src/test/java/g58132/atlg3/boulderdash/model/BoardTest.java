package g58132.atlg3.boulderdash.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    @BeforeEach     // Exécutée avant chaque test
    public void setUp() {
        board = new Board(26,78);
    }

    @Test
    void movePlayerDirectionRightIsASoil() {
     board.setElement(new Rockford(),new Position(2,3));
     board.setElement(new Soil(),new Position(2,4));
     board.movePlayer(Direction.RIGHT);
     assertTrue(board.getElement(new Position(2,4)) instanceof Rockford && board.getElement(new Position(2,3))==null);

    }
    @Test
    void movePlayerPushRockValid() {
        board.setElement(new Rockford(),new Position(2,3));
        board.setElement(new Rock(),new Position(2,4));
        board.movePlayer(Direction.RIGHT);
        assertTrue(board.getElement(new Position(2,5)) instanceof  Rock &&board.getElement(new Position(2,4)) instanceof Rockford && board.getElement(new Position(2,3))==null);
    }
    @Test
    void movePlayerPushRockNoValid() {
        board.setElement(new Rockford(),new Position(2,3));
        board.setElement(new Rock(),new Position(2,4));
        board.setElement(new Soil(),new Position(2,5));
        board.movePlayer(Direction.RIGHT);
        assertTrue(board.getElement(new Position(2,5)) instanceof  Soil &&board.getElement(new Position(2,4)) instanceof Rock && board.getElement(new Position(2,3)) instanceof Rockford);
    }

    @Test
    void moveDiamondOrRock() {
    }


    @Test
    void getElementCaseWorks() {
        board.setElement(new Rock(),new Position(2,2));
        assertTrue(board.getElement(new Position(2,2)) instanceof Rock);
    }
    @Test
    void getElementCaseDoesNotWorking() {
        board.setElement(new Wall(),new Position(7,9));
        assertFalse(board.getElement(new Position(7,9)) instanceof Rock);
    }

    @Test
    public void testcontainsBoardOnCorner() {
        // A corner of the board
        Position pos = new Position(0, 0);
        assertTrue(board.containsBoard(pos));
    }

    @Test
    public void testcontainsBoardMiddleBoard() {
        // A point on the midle of the board
        Position pos = new Position(13, 39);
        assertTrue(board.containsBoard(pos));
    }

    @Test
    public void testcontainsBoardRowOutOfRange() {
        // Row out of range
        Position pos = new Position(-1, 3);
        assertFalse(board.containsBoard(pos));
    }

    @Test
    public void testcontainsBoardColOutOfRange() {
        // Col. out of range
        Position pos = new Position(26, 78);
        assertFalse(board.containsBoard(pos));
    }

    @Test
    public void testcontainsBoardColAndRowOutOfRange() {
        // Row and col. out of range
        Position pos = new Position(30, 10);
        assertFalse(board.containsBoard(pos));
    }


    @Test
    void setElement() {
        Element element=new Rockford();
        Position position=new Position(3,7);
        board.setElement(element,position);
        assertTrue(board.getElement(position) instanceof  Rockford);
    }

    @Test
    void dropElement() {
        Element element=new Diamond();
        Position position=new Position(4,4);
        board.setElement(element,position);
        board.dropElement(position);
        assertTrue(board.getElement(position)==null);
    }

    @Test
    void getRockfordFound() {
        board.setElement(new Rockford(),new Position(2,5));
       assertTrue(board.getRockford() instanceof Rockford );
    }
    @Test
    void getRockfordNotFound() {
//getRockFord() va être à null car il ne trouvera pas le rockford sur le board
        assertFalse(board.getRockford() instanceof Rockford );
    }


}