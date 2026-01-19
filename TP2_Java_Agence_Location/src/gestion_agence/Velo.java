package gestion_agence;

public class Velo extends Vehicule{
	private String type;
	
	public Velo(String marque, String modele, int annee, boolean disponible, String type) {
		super(marque, modele, annee, disponible);
		this.type = type;
	}
	
	public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
	
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Type : "+type);
	}
}
