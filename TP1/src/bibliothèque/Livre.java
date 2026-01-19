package bibliothèque;

public class Livre {
	 private String titre;
	 private String auteur;
	 private String isbn;
	 private String genre;
	 boolean disponible;
	 private int anneePublication;
	// TODO 1.1 : Créer le constructeur avec tous les paramètres
	 public Livre(String titre,String auteur,String isbn,String genre,boolean disponible,int anneePublication) {
		 this.titre=titre;
		 this.auteur=auteur;
		 this.isbn=isbn;
		 this.genre=genre;
		 this.disponible=true;
		 this.anneePublication=anneePublication;
	 }
	// TODO 1.2 : Créer les getters et setters
	 public String getTitre() {
		 return titre;
	 }
	 public void setTitre(String titre) {
		 this.titre=titre;
	 }
	 public String getauteur() {
		 return auteur;
	 }
	 public void setauteur(String auteur) {
		 this.auteur=auteur;
	 }
	 public String getIsbn() {
		 return isbn;
	 }
	 public void setIsbn(String isbn) {
		 this.isbn=isbn;
	 }
	 public String getGenre() {
		 return genre;
	 }
	 public void setGenre(String genre) {
		 this.genre=genre;
	 }
	 public int getAnneePublication() {
		 return anneePublication;
	 }
	 public void setAnneePublication(int anneePublication) {
		 this.anneePublication=anneePublication;
	 }
	 public boolean getDisponible() {
		 return disponible;
	 }
	 public void setDisponible(boolean disponible) {
		 this.disponible=disponible;
	 }
	// TODO 1.3 : Implémenter la méthode toString()
	 public String toString()
	 {
		return"Titre: "+titre+"		,Auteur: "+auteur+"		,Isbn"+isbn+"		,Genre"+genre+"		,Disponible:"+(disponible ? "ce livre est disponible":"ce livre n'est pas disponible")+"		,AnneePublication:"+anneePublication; 
	 }
	// TODO 1.4 : Créer une méthode emprunter() qui change le statut à non disponible
	 public void emprunter() {
         if(disponible) {
             disponible=false;
             System.out.println("le statut a changé à nondisponible");
         }else {
             System.out.println("le statut est déja nondisponible");
         }
	 }
    // TODO 1.5 : Créer une méthode retourner() qui remet le livre disponible
         public void retourner() {
             disponible=true;
             System.out.println("le statut a remet le livre disponible");

	 }
	 
}
