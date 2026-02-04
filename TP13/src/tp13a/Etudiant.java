package tp13a;

public class Etudiant {
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String dateInscription;

    public Etudiant(int id, String prenom, String nom, String email, String dateInscription) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateInscription = dateInscription;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

    
}

