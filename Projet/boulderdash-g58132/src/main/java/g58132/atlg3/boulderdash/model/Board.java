package g58132.atlg3.boulderdash.model;

public class Board {
    private Element[][] board;



    public Board(int height,int width) {

        this.board = new Element[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
               board[i][j]=new Element();
            }
        }
    }

    public Element[][] getBoard() {
        return board;
    }

    public boolean containsBoard(Position pos){
        return ((pos.getRow() >= 0 && pos.getRow() <= board.length-1) && (pos.getColumn() >= 0
                && pos.getColumn() <= board[0].length));

    }
    public void setElement(Element element,Position pos){
        if(!containsBoard(pos)){
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        this.board[pos.getRow()][pos.getColumn()]=new Element(element);
    }


    public boolean isValideMove(Position pos){
        if(!containsBoard(pos)){
            throw new IllegalArgumentException("La position n' est pas dans le board");
        }
        return !(this.board[pos.getRow()][pos.getColumn()] instanceof Wall) && !(this.board[pos.getRow()][pos.getColumn()] instanceof Rock);
    }
    public void dropElement(Position position) {
        setElement(null,position);
    }
    public Position getPositionOfPlayer(Rockford player){

        for (int i=0;i< board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(player.equals(board[i][j])){
                    return new Position(i,j);
                }
            }
        }
           return null;
    }






}
