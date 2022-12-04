package g58132.atlg3.boulderdash.model;

public class BoulderDash {
    private LevelReader level;
    private GameState state;
    private int nbDiamond;

    public BoulderDash(LevelReader level) {
        this.level = level;
        this.state = GameState.PLAY;
        nbDiamond=0;
    }

    public LevelReader getLevel() {
        return level;
    }

    public void movePosition(Direction direction) {
        var oldpos = level.getLevel().getBoard().getPositionOfPlayer();
        var newPos = oldpos.next(direction);

        if (level.getLevel().getBoard().containsBoard(oldpos)
                && level.getLevel().getBoard().containsBoard(newPos) &&
                level.getLevel().getBoard().getElement(newPos) instanceof Diamond) {
            nbDiamond++;
        }
        if (level.getLevel().getBoard().isValideMove(newPos)) {
            level.getLevel().getBoard().dropElement(newPos);
            level.getLevel().getBoard().setElement(this.level.getLevel().getBoard().getElement(oldpos), newPos);
            level.getLevel().getBoard().dropElement(oldpos);
        } else if (level.getLevel().getBoard().isPushRock(newPos, newPos.next(direction))) {
            level.getLevel().getBoard().setElement(this.level.getLevel().getBoard().getElement(newPos), newPos.next(direction));
            level.getLevel().getBoard().dropElement(newPos);
            level.getLevel().getBoard().setElement(this.level.getLevel().getBoard().getElement(oldpos), newPos);
            level.getLevel().getBoard().dropElement(oldpos);
        }
        if (nbDiamond >= level.getLevel().getnumberDiamondcollect()) {
            nbDiamond = 0;
            level.browseLevel(1);
        }

    }

    public int getNbDiamond() {
        return nbDiamond;
    }
}
