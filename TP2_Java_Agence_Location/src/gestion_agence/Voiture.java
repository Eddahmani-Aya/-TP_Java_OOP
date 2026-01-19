package gestion_agence;

public class Voiture extends Vehicule implements Louable{
	public int nombrePlaces;

	public Voiture(String marque, String modele, int annee, boolean disponible, int nombrePlaces) {
		super(marque, modele, annee, disponible);
		this.nombrePlaces = nombrePlaces;
	}

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	
	@Override
    public void afficher() {
		super.afficher();
        System.out.println("Nombre de places: " + nombrePlaces);
    }
	@Override
	public void louer() {
		if(this.isDisponible()) {
			this.setDisponible(false);
			System.out.println("Voiture "+getMarque()+" "+getModele()+" louee");
		}
		else {
			System.out.println("Desole, La Voiture "+getMarque()+" "+getModele()+" deja louee");
		}
	}
	
	@Override
	public void retourner() {
        this.setDisponible(true);
        System.out.println("Voiture " + getMarque() + " " + getModele() + " retournee");
    }

}

