package gestion_parc;

public class Voiture extends Ressource {
    private String immatriculation;
    private int places;
    private double tarifJour;

    public Voiture(String modele, String immat, int places, double tarifJour) {
        super(modele);
        if (immat == null || immat.isBlank()) throw new IllegalArgumentException("Immat invalide");
        if (places <= 0) throw new IllegalArgumentException("Places > 0");
        if (tarifJour <= 0) throw new IllegalArgumentException("Tarif invalide");
        this.immatriculation = immat;
        this.places = places;
        this.tarifJour = tarifJour;
    }
    public String getImmatriculation() { return immatriculation; }
    public int getPlaces() { return places; }
    @Override protected String categorie() { return "Voiture"; }
    @Override public double getTarifJournalier() { return tarifJour; }
}

