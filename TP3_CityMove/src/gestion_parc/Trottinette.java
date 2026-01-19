package gestion_parc;

public class Trottinette extends Ressource {
    private int batterie; // 0..100
    private double autonomieKm;
    private double tarifJour;

    public Trottinette(String modele, double tarifJour, int batterie, double autonomieKm) {
        super(modele);
        if (tarifJour <= 0) throw new IllegalArgumentException("Tarif invalide");
        if (batterie < 0 || batterie > 100) throw new IllegalArgumentException("Batterie 0..100");
        if (autonomieKm < 0) throw new IllegalArgumentException("Autonomie >= 0");
        this.tarifJour = tarifJour;
        this.batterie = batterie;
        this.autonomieKm = autonomieKm;
    }
    public int getBatterie() { 
    	return batterie; 
    }
    public void setBatterie(int b) { 
    	if (b<0) b=0; if (b>100) b=100; 
    	this.batterie=b; 
    }
    public double getAutonomieKm() {
    	return autonomieKm; 
    }
    public void setAutonomieKm(double a) { 
    	if (a<0) throw new IllegalArgumentException("Autonomie >= 0"); 
    	this.autonomieKm=a; 
    }
    @Override 
    protected String categorie() { 
    	return "Trottinette"; 
    }
    @Override 
    public double getTarifJournalier() { 
    	return tarifJour; 
    }
    public void recharger(int plus) { 
    	setBatterie(getBatterie() + plus); 
    }
}

