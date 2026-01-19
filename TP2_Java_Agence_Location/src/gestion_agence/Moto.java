package gestion_agence;

public class Moto extends Vehicule implements Louable{
	public int cylindree;

	public Moto(String marque, String modele, int annee, boolean disponible, int cylindree) {
		super(marque, modele, annee, disponible);
		this.cylindree = cylindree;
	}

	public int getCylindree() {
		return cylindree;
	}

	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}
	
	@Override
    public void afficher() {
		super.afficher();
        System.out.println("Cylindree: " + cylindree);
    }

	@Override
	public void louer() {
		if(this.isDisponible()) {
			this.setDisponible(false);
			System.out.println("Moto "+getMarque()+" "+getModele()+" loue");
		}
		else {
			System.out.println("Moto "+getMarque()+" "+getModele()+" deja loue");
		}
	}

	@Override
	public void retourner() {
        this.setDisponible(true);
        System.out.println("Moto " + getMarque() + " " + getModele() + " retourne");
    }
	

}
