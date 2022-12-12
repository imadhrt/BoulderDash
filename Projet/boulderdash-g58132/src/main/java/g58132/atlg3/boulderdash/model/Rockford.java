package g58132.atlg3.boulderdash.model;

public class Rockford extends Mobile {
    private int nbDiamand;

    /**
     * Constructor of the rockFord
     */
    public Rockford() {
        super();
        nbDiamand = 0;
    }


    /**
     * Accessor of the diamond
     *
     * @return the number of the diamond collected by player
     */
    public int getNbDiamand() {
        return nbDiamand;
    }

    /**
     * Mutator of the number of the diamond
     *
     * @param nbDiamand is a number of the diamond
     */
    public void setNbDiamand(int nbDiamand) {
        this.nbDiamand = nbDiamand;
    }

    @Override
    public String toString() {
        return "Rockford";
    }
}
