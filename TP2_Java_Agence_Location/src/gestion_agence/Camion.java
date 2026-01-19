package gestion_agence;

public class Camion extends Vehicule{
	private double capaciteChargement;
	
	public Camion(String marque, String modele, int annee, boolean disponible, double capaciteChargement) {
		super(marque,modele,annee,disponible);
		this.capaciteChargement = capaciteChargement;
	}
	
	 public double getCapaciteChargement() {
	        return capaciteChargement;
	    }
	    
	    public void setNombrePlaces(double capaciteChargement) {
	        this.capaciteChargement = capaciteChargement;
	    }
	
	@Override
    public void afficher() {
		super.afficher();
        System.out.println("Capacite de chargement: " + capaciteChargement);
    }
}
