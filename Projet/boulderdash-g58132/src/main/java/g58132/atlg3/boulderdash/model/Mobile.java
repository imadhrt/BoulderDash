package g58132.atlg3.boulderdash.model;

/**
 * the Mobile represent all object( Rockford, Rock, Diamond) that moves
 */
public abstract class Mobile extends Element {
    private boolean isFall;

    /**
     * Constructor of the Mobile without parameter that set to attribute false
     */
    public Mobile() {
        this.isFall = false;
    }

    /**
     * Constructor of the Mobile
     *
     * @param isFall true if object to move otherwhise false
     */
    public Mobile(boolean isFall) {
        this.isFall = isFall;
    }
    public void setElement(Element element){
        super.setElement(element);
    }

    /**
     * Accessor of the isFall
     *
     * @return isFall
     */
    public boolean isFall() {
        return isFall;
    }
}
