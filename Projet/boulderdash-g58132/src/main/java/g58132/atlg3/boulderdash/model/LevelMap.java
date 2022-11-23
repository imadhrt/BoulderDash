package g58132.atlg3.boulderdash.model;

public class LevelMap {
    private String name;
    private int height;
    private int width;
    private int nombreDiamont;
    private int temps;

    public LevelMap(String name, int height, int width, int nombreDiamont, int temps) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.nombreDiamont = nombreDiamont;
        this.temps = temps;
    }
}
