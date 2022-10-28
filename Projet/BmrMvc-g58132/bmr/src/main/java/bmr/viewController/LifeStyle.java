package bmr.viewController;

public enum LifeStyle {
    SEDENTAIRE(1.2,"sédentaire"),PEU_ACTIF(1.375,"Peu actif"),ACTIF(1.55,"Actif"),FORT_ACTIF(1.725,"fort actif"),EXTREMEMENT_ACTIF(1.9,"extrêmement actif");
    private double facteur;
    private String niveau;


    private LifeStyle(double facteur,String niveau ) {
        this.facteur=facteur;
        this.niveau=niveau;
    }

    public double getFacteur() {
        return facteur;
    }

    public String getNiveau() {
        return niveau;
    }

    @Override
    public String toString() {
        return niveau;
    }
}
