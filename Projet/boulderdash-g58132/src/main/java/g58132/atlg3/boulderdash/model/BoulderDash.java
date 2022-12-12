package g58132.atlg3.boulderdash.model;

public class BoulderDash { // Observable
    private LevelReader level;
    private GameState state;
    private int numberLevel;
//    CommandManager commmandManager=new CommandManager();

    /**
     * Constructor of the boulder dash
     *
     * @param level is a level loader
     */

    public BoulderDash(LevelReader level,int numberLevel) {
        this.level = level;
        this.state = GameState.PLAY;
        this.numberLevel=numberLevel;

    }

    /**
     * start the level
     */

    public void start() {
        if (numberLevel >= 0 && numberLevel <= 3) {
            level.browseLevel(numberLevel);
        }
    }
    public void playMove(Direction direction){
        var board=level.getLevel().getBoard();
        board.movePlayer(direction);
        createExit();
        board.moveDiamondOrRock();
        winlevel();
    }


    /**
     * get a number of the player
     * @return
     */

    public int getNumberLevel() {
        return numberLevel;
    }

    /**
     * set a number of diamonds
     * @param numberLevel is a number of diamonds
     */
    public void setNumberLevel(int numberLevel) {
        this.numberLevel = numberLevel;
    }
    public void createExit(){
        var levelReader=level.getLevel();
        if(levelReader.getBoard().getRockford().getNbDiamand() >= levelReader.getnumberDiamondcollect()){
            levelReader.getBoard().setElement(new Exit(),new Position(2,3));

        }
    }
    /**
     * Check the end of game
     *
     * @return true if all party is win
     */
    public boolean isEndOfTheGame(){
        return state==GameState.WIN && numberLevel==2;
    }


    /**
     * Check the win or lose the level
     */
    public  void winlevel() {
        var board = level.getLevel().getBoard();

        if (board.getRockford() != null && board.getRockford().getNbDiamand() >= level.getLevel().getnumberDiamondcollect() &&
                !(board.getElement(new Position(2, 3)) instanceof Exit)) {
            state = GameState.WIN;
        } else if (board.getRockford() == null) {
            state = GameState.LOSE;
        }
    }
    public  void setdiscontinued (){
        state=GameState.EXIT;
    }



    /**
     * getter of the level loader
     * @return the level
     */

    public LevelReader getLevel() {
        return level;
    }

    /**
     * give the states of the game
     * @return a state in which the LOSE, WIN, PLAY
     */
    public GameState getState() {
        return state;
    }
}
