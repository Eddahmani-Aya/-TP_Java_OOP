package manipulation_fichiers;

import java.util.Date;


public  class Commande implements Comparable<Commande> {
	private int	NumCommande ;
	private Date DateCommande ;
	private String NomFournisseur ;
	
	public Commande(int numCommande, Date dateCommande, String nomFournisseur) {
		NumCommande = numCommande;
		DateCommande = dateCommande;
		NomFournisseur = nomFournisseur;
	}

	public int getNumCommande() {
		return NumCommande;
	}

	public void setNumCommande(int numCommande) {
		NumCommande = numCommande;
	}

	public Date getDateCommande() {
		return DateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		DateCommande = dateCommande;
	}

	public String getNomFournisseur() {
		return NomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		NomFournisseur = nomFournisseur;
	}

	
	@Override
	public String toString() {
		return "Commande [NumCommande=" + NumCommande + ", DateCommande=" + DateCommande + ", NomFournisseur="
				+ NomFournisseur + "]";
	}

	public boolean equals(Object o) {
		if (this == o) 
			return true;
        if (!(o instanceof Commande)) 
        	return false;
        Commande c = (Commande) o;
        return this.NumCommande == c.NumCommande;
	}

	 public int comparTo(Commande cmd ) {
		 if (cmd.getDateCommande().before(DateCommande)) {
			 return 1;
			 
			
		}
		 if (cmd.getDateCommande().after(DateCommande)) {
			 return -1;
			 
		}
		 else {
			 return 0;
		 }
		 
	 }

	 @Override
	 public int compareTo(Commande o) {
		// TODO Auto-generated method stub
		return 0;
	 }

}
