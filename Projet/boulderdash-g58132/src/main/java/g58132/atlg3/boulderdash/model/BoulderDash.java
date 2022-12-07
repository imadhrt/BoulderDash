package g58132.atlg3.boulderdash.model;

public class BoulderDash { // Observable
    private LevelReader level;
    private GameState state;

    private Rockford rockford;
    private int nbDiamond;

    public BoulderDash(LevelReader level) {
        this.level = level;
        this.state = GameState.PLAY;
        rockford=new Rockford();
        nbDiamond=0;
    }

    public LevelReader getLevel() {
        return level;
    }

    public void movePosition(Direction direction) {
        Board board = level.getLevel().getBoard();
        var oldpos = board.getPositionOfPlayer();
        var newPos = oldpos.next(direction);

        ;
        // la logique dans Board ?
        if (board.containsBoard(oldpos)
                && board.containsBoard(newPos) &&
                board.getElement(newPos) instanceof Diamond) {
            rockford.setNbDiamand(rockford.getNbDiamand()+1);
        }

        if (board.isValideMove(newPos)) {
            board.dropElement(newPos);
            board.setElement(level.getLevel().getBoard().getElement(oldpos), newPos);
            board.dropElement(oldpos);
        } else if (board.isPushRock(newPos, newPos.next(direction))) {
            board.setElement(this.level.getLevel().getBoard().getElement(newPos), newPos.next(direction));
            board.dropElement(newPos);
            board.setElement(this.level.getLevel().getBoard().getElement(oldpos), newPos);
            board.dropElement(oldpos);
        }

        if (rockford.getNbDiamand() >= level.getLevel().getnumberDiamondcollect()) {
            rockford.setNbDiamand(0);
            level.browseLevel(1);
        }
//        boolean a=false;
//        int cpt=0;
//        while(!a)
//        for (var i = 0; i< board.getAllRock().size(); i++){
//            if(board.isCheckFallDown(board.getAllRock().get(i))){
//                board.setElement(board.getElement(board.getAllRock().get(i)), board.getAllRock().get(i).next(Direction.DOWN));
//                board.dropElement(board.getAllRock().get(i));
//                cpt++;
//            }
//            if(cpt==0){
//                a=true;
//            }
//        }

    }

    public Rockford getRockford() {
        return rockford;
    }
    //    public int getNbDiamond() {
//        return nbDiamond;
//    }
}
