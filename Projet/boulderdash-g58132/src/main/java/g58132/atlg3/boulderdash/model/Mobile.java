package g58132.atlg3.boulderdash.model;

public class Mobile extends Element{
    private boolean isFall;

    public Mobile() {
        this.isFall = false;
    }

    public Mobile(boolean isFall) {
        this.isFall = isFall;
    }

    public boolean isFall() {
        return isFall;
    }
}
