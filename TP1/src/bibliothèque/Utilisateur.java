package bibliothèque;

	//TODO 3.1 : Classe parent Utilisateur
	public abstract class Utilisateur {
	protected String nom;
	protected String prenom;
	protected String numeroId;
	protected Livre[] livresEmpruntes;
	protected int nombreEmprunts;
	// TODO : Constructeur, getters, setters
	public Utilisateur(String nom, String prenom, String numeroId, Livre[] livresEmpruntes, int nombreEmprunts) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroId = numeroId;
		this.livresEmpruntes = livresEmpruntes;
		this.nombreEmprunts = nombreEmprunts;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}

	public Livre[] getLivresEmpruntes() {
		return livresEmpruntes;
	}

	public void setLivresEmpruntes(Livre[] livresEmpruntes) {
		this.livresEmpruntes = livresEmpruntes;
	}

	public int getNombreEmprunts() {
		return nombreEmprunts;
	}

	public void setNombreEmprunts(int nombreEmprunts) {
		this.nombreEmprunts = nombreEmprunts;
	}
	public abstract boolean peutEmprunter();
	 public abstract int getLimiteEmprunt();
	 
}
