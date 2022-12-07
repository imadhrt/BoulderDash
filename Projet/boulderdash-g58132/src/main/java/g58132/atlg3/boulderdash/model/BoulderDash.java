package g58132.atlg3.boulderdash.model;

public class BoulderDash { // Observable
    private LevelReader level;
    private GameState state;


    public BoulderDash(LevelReader level) {
        this.level = level;
        this.state = GameState.PLAY;

    }

    public void start(int numerolevel) {
        if (numerolevel >= 0 && numerolevel <= 3) {
            level.browseLevel(numerolevel);
        }
    }

    public LevelReader getLevel() {
        return level;
    }

    public boolean isGameOverLevel() {
        return state == GameState.LOSE;

    }

    public boolean isWinLevel() {
        return state == GameState.WIN;
    }


}
