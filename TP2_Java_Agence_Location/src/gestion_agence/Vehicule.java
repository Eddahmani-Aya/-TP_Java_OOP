package gestion_agence;

public class Vehicule {
	private String marque;
	 private String modele;
	 private int annee;
	 private boolean disponible;
	 
	 public Vehicule() {
			
	}
	 public Vehicule(String marque, String modele, int annee, boolean disponible) {
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.disponible = true;
	 }

	 public String getMarque() {
		 return marque;
	 }

	 public void setMarque(String marque) {
		 this.marque = marque;
	 }

	 public String getModele() {
		 return modele;
	 }

	 public void setModele(String modele) {
		 this.modele = modele;
	 }

	 public int getAnnee() {
		 return annee;
	 }

	 public void setAnnee(int annee) {
		 this.annee = annee;
	 }

	 public boolean isDisponible() {
		 return disponible;
	 }

	 public void setDisponible(boolean disponible) {
		 this.disponible = disponible;
	 }
	 
	 public void afficher() {
		 System.out.println("Marque: " + marque + 
                 ", Modèle: " + modele + 
                 ", Année: " + annee + 
                 ", Disponible: " + (disponible ? "Oui" : "Non"));
		 
	 }
	 
	 

}
