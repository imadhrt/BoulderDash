package g58132.atlg3.boulderdash.model;

import g58132.atlg3.boulderdash.util.Observable;
import g58132.atlg3.boulderdash.util.Observer;

import java.util.ArrayList;
import java.util.List;

public class BoulderDash implements Observable {
    private LevelReader level;
    private GameState state;
    private int numberLevel;
    CommandManager commmandManager = new CommandManager();
    private List<Observer> observers = new ArrayList();

    /**
     * Constructor of the boulder dash
     *
     * @param level is a level loader
     */

    public BoulderDash(LevelReader level) {
        this.level = level;
        this.state = GameState.PLAY;
        this.numberLevel = 0;

    }

    public void undo() {
        commmandManager.undo();
        notifyObservers();
    }

    public void redo() {
        commmandManager.redo();
        notifyObservers();
    }

    /**
     * start the level
     */

    public void start(int numberLevel) {
        if (numberLevel >= 0 && numberLevel <= 3) {
            this.numberLevel = numberLevel;
            state = GameState.PLAY;
            level.browseLevel(this.numberLevel);
        }
    }

    public void playMove(Direction direction) {

        Command command = new MoveCommand(direction, this);
        commmandManager.addAllCommand(command);
        notifyObservers();
    }


    /**
     * get a number of the player
     *
     * @return
     */

    public int getNumberLevel() {
        return numberLevel;
    }

    /**
     * set a number of diamonds
     */
    public void setNumberLevel() {
        this.numberLevel++;
    }

    public void createExit() {
        var levelReader = level.getLevel();


        if (levelReader.getBoard().getRockford().getNbDiamand() >= levelReader.getnumberDiamondcollect() && !(levelReader.getBoard().getElement(new Position(2, 4)) instanceof Exit) && !(levelReader.getBoard().getElement(new Position(2, 4)) instanceof Rockford)) {
            levelReader.getBoard().setElement(new Exit(), new Position(2, 4));
        }

    }

    /**
     * /**
     * Check the loose the level
     */
    public void lose() {
        var board = level.getLevel().getBoard();
        if (board.getRockford() == null) {
            state = GameState.LOSE;

        }
    }

    /**
     * Check the win the level
     */
    public void winOrLoselevel() {
        var board = level.getLevel().getBoard();

        if (board.getRockford() != null && board.getRockford().getNbDiamand() >= level.getLevel().getnumberDiamondcollect() &&
                !(board.getElement(new Position(2, 4)) instanceof Exit)) {
            state = GameState.WIN;

        }
    }

    public void setdiscontinued() {
        state = GameState.EXIT;
    }

    /**
     * Check the win all the level
     */
    public void winAllLevel() {
        if (state == GameState.WIN && numberLevel == 3) {
            state = GameState.ALLWIN;
        }
    }


    /**
     * getter of the level loader
     *
     * @return the level
     */

    public LevelReader getLevel() {
        return level;
    }

    /**
     * give the states of the game
     *
     * @return a state in which the LOSE, WIN, PLAY,EXIT
     */
    public GameState getState() {
        return state;
    }

    public int startRow() {
        if(this.level.getLevel().getBoard().getRockford()!=null) {
            if (this.level.getLevel().getBoard().getPositionOfPlayer().getRow() < this.level.getLevel().getBoard().getBoard().length / 2 - 2) {
                return 0;
            }

            if (this.level.getLevel().getBoard().getPositionOfPlayer().getRow() >= this.level.getLevel().getBoard().getBoard().length / 2 - 2
                    && this.level.getLevel().getBoard().getPositionOfPlayer().getRow() < this.level.getLevel().getBoard().getBoard().length / 2 + 2) {
                return this.level.getLevel().getBoard().getBoard().length / 2 / 2;
            }
        }


        return 0;
    }

    public int rows() {
        if(this.level.getLevel().getBoard().getRockford()!=null) {
            if (this.level.getLevel().getBoard().getPositionOfPlayer().getRow() < this.level.getLevel().getBoard().getBoard().length / 2 - 2) {
                return this.level.getLevel().getBoard().getBoard().length / 2;
            }

            if (this.level.getLevel().getBoard().getPositionOfPlayer().getRow() >= this.level.getLevel().getBoard().getBoard().length / 2 - 2
                    && this.level.getLevel().getBoard().getPositionOfPlayer().getRow() < this.level.getLevel().getBoard().getBoard().length / 2 + 2) {
                return (int) ((this.level.getLevel().getBoard().getBoard().length / 2) * 1.5);
            }
        }

        return this.level.getLevel().getBoard().getBoard().length;
    }

    public int startColumn() {
        if(this.level.getLevel().getBoard().getRockford()!=null) {
            if (this.level.getLevel().getBoard().getPositionOfPlayer().getColumn() < this.level.getLevel().getBoard().getBoard()[0].length / 2 - 2) {
                return 0;
            }
            if (this.level.getLevel().getBoard().getPositionOfPlayer().getColumn() >= this.level.getLevel().getBoard().getBoard()[0].length / 2 - 2
                    && this.level.getLevel().getBoard().getPositionOfPlayer().getColumn() < this.level.getLevel().getBoard().getBoard()[0].length / 2 + 2) {
                return this.level.getLevel().getBoard().getBoard()[0].length / 2 / 2;
            }
        }

        return  0;
    }

    public int columns() {
        if(this.level.getLevel().getBoard().getRockford()!=null) {

            if (this.level.getLevel().getBoard().getPositionOfPlayer().getColumn() < this.level.getLevel().getBoard().getBoard()[0].length / 2 - 2) {
                return this.level.getLevel().getBoard().getBoard()[0].length / 2;
            }

            if (this.level.getLevel().getBoard().getPositionOfPlayer().getColumn() >= this.level.getLevel().getBoard().getBoard()[0].length / 2 - 2
                    && this.level.getLevel().getBoard().getPositionOfPlayer().getColumn() < this.level.getLevel().getBoard().getBoard()[0].length / 2 + 2) {
                return (int) ((this.level.getLevel().getBoard().getBoard()[0].length / 2) * 1.5);
            }
        }

        return this.level.getLevel().getBoard().getBoard()[0].length;
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (var observe : observers) {
            observe.update();
        }
    }

}
