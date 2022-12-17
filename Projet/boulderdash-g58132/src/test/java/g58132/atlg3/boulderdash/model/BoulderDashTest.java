package g58132.atlg3.boulderdash.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoulderDashTest {
    private BoulderDash boulderDash;

    @BeforeEach     // Exécutée avant chaque test
    public void setUp() {
        boulderDash = new BoulderDash(new LevelReader());
        boulderDash.start(1);
    }
    @Test
    void undoMovePlayer() {
        var board=boulderDash.getLevel().getLevel().getBoard();
        boulderDash.playMove(Direction.UP);
        boulderDash.undo();
        assertTrue(board.getElement(new Position(1,3))  instanceof Soil && board.getElement(new Position(2,3)) instanceof Rockford );
    }
    @Test
    void undoFallAndMove() {
        var board=boulderDash.getLevel().getLevel().getBoard();
        boulderDash.playMove(Direction.DOWN);
        boulderDash.playMove(Direction.RIGHT);
        boulderDash.playMove(Direction.RIGHT);
        boulderDash.undo();
        boulderDash.undo();
        boulderDash.undo();
        assertTrue(board.getElement(new Position(2,3)) instanceof Rockford  && board.getElement(new Position(3,3)) instanceof Soil
        && board.getElement(new Position(5,4)) == null);
    }

    @Test
    void redo() {
        var board=boulderDash.getLevel().getLevel().getBoard();
        boulderDash.playMove(Direction.UP);
        boulderDash.undo();
        boulderDash.redo();
        assertTrue(board.getElement(new Position(2,3)) == null && board.getElement(new Position(1,3)) instanceof Rockford );
    }

    @Test
    void playMove() {
        var board=boulderDash.getLevel().getLevel().getBoard();
        boulderDash.playMove(Direction.UP);
       assertTrue(board.getElement(new Position(2,3)) == null && board.getElement(new Position(1,3)) instanceof Rockford );
    }

    @Test
    void lose() {
        boulderDash.playMove(Direction.DOWN);
        boulderDash.playMove(Direction.RIGHT);
        boulderDash.playMove(Direction.DOWN);
        assertEquals(boulderDash.getState(),GameState.LOSE);
    }

    @Test
    void winOrLoselevel() {
        boulderDash.getLevel().getLevel().getBoard().getRockford().setNbDiamand(5);
        boulderDash.createExit();
        boulderDash.playMove(Direction.RIGHT);
        boulderDash.winOrLoselevel();
        assertEquals(boulderDash.getState(),GameState.WIN);
    }
    @Test
    void winAllLevel(){
        boulderDash.start(9);
        boulderDash.getLevel().getLevel().getBoard().getRockford().setNbDiamand(5);
        boulderDash.createExit();
        boulderDash.playMove(Direction.RIGHT);
        boulderDash.winAllLevel();
        assertEquals(boulderDash.getState(),GameState.ALLWIN);
    }


}