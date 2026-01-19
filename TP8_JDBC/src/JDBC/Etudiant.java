package JDBC;

public class Etudiant {
    private int idEtud;
    private String nom;
    private String prenom;
    private String email;
    private String ville;

    // Constructeur sans paramètre
    public Etudiant() {}

    // Constructeur sans id
    public Etudiant(String nom, String prenom, String email, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ville = ville;
    }

    // Constructeur complet
    public Etudiant(int idEtud, String nom, String prenom, String email, String ville) {
        this.idEtud = idEtud;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ville = ville;
    }

    // Getters & Setters
    public int getIdEtud() { return idEtud; }
    public void setIdEtud(int idEtud) { this.idEtud = idEtud; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    @Override
    public String toString() {
        return "Etudiant [ID=" + idEtud + ", Nom=" + nom + ", Prenom=" + prenom +
                ", Email=" + email + ", Ville=" + ville + "]";
    }
}
