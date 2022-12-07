package g58132.atlg3.boulderdash.model;

public class Rockford extends Mobile {
    private int nbDiamand;
    /**
     * Constructor of the rockFord
     */
    public Rockford() {
        super();
        nbDiamand=0;
    }

    public int getNbDiamand() {
        return nbDiamand;
    }

    public void setNbDiamand(int nbDiamand) {
        this.nbDiamand = nbDiamand;
    }

    @Override
    public String toString() {
        return "Rockford";
    }
}
