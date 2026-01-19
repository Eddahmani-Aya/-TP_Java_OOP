package bibliothèque;

public class Catalogue {
	 private Livre[] livres;
	 private int nombreLivres;
	 private static final int TAILLE_MAX = 100;
	 // TODO 2.1 : Créer le constructeur qui initialise le tableau
	 public Catalogue() {
		 livres = new Livre[TAILLE_MAX];
		 nombreLivres=0;
	 }
	 // TODO 2.2 : Méthode pour ajouter un livre
	 public boolean ajouterLivre(Livre L) {
		 if(nombreLivres<TAILLE_MAX) {
			 livres[nombreLivres]=L;
			 nombreLivres ++;
			 return true;
		 }
		 return false;
	 }
	 // TODO 2.3 : Surcharge - Rechercher par titre
	 public Livre rechercher(String titre) {
		 for(int i=0 ;i<nombreLivres;i++ ) {
			 if(livres[i].getTitre().equalsIgnoreCase(titre)) {
				 return livres[i];
			 }
		 }
		 return null;
	 }
	 // TODO 2.4 : Surcharge - Rechercher par titre et auteur
	 public Livre rechercher(String titre, String auteur) {
		 for(int i=0 ;i<nombreLivres;i++ ) {
			 if(livres[i].getTitre().equalsIgnoreCase(titre) &&
					 livres[i].getauteur().equalsIgnoreCase(auteur)) {
				 return livres[i];
			 }
		 }
		 return null;
	 }
	 // TODO 2.5 : Surcharge - Rechercher par année
	 public Livre[] rechercher(int anneePublication) {
		 int count=0;
		 for(int i=0 ;i<nombreLivres;i++ ) {
			 if(livres[i].getAnneePublication()==anneePublication) {
				count++;
			 }
		 }
		 Livre[] res =new Livre[count];
		 int nombreres=0;
		 for(int i=0 ;i<nombreLivres;i++ ) {
			 if(livres[i].getAnneePublication()==anneePublication) {
				 res[nombreres++]=livres[i];
				
			 }
		 }
		 return res;
		 
	 }
	 // TODO 2.6 : Méthode pour lister tous les livres disponibles
	 public void afficherLivresDisponibles() {
		 for(Livre livre: livres) {
			 if(livre!=null && livre.disponible==true) {
				System.out.println(livre);
			 } 
		 }
	 
	 }
	 public void statistiquesParGenre() {
		    int fiction = 0, science = 0, histoire = 0, autre = 0;

		    for (int i = 0; i < nombreLivres; i++) {
		        String g = livres[i].getGenre().toLowerCase();
		        switch (g) {
		            case "fiction": fiction++; break;
		            case "science": science++; break;
		            case "histoire": histoire++; break;
		            default: autre++; break;
		        }
		    }

		    System.out.println("Fiction: " + fiction);
		    System.out.println("Science: " + science);
		    System.out.println("Histoire: " + histoire);
		    System.out.println("Autres genres: " + autre);
		}

	}

