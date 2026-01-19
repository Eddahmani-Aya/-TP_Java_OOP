package gestion_parc;

public class Velo extends Ressource {
    private double tarifJour;
    
    public Velo(String modele, double tarifJour) {
        super(modele);
        if (tarifJour <= 0) throw new IllegalArgumentException("Tarif invalide");
        this.tarifJour = tarifJour;
    }
    @Override protected String categorie() { 
    	return "Velo"; 
    }
    @Override public double getTarifJournalier() { 
    	return tarifJour; 
    	}
}

