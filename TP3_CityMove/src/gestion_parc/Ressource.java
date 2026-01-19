package gestion_parc;

public abstract class Ressource {
    private static int COMPTEUR = 0;
    private final int id;
    private String modele;
    private boolean disponible = true;

    protected Ressource(String modele) {
        if (modele == null || modele.isBlank()) {
            throw new IllegalArgumentException("Modèle vide");
        }
        this.id = ++COMPTEUR;
        this.modele = modele;
    }

    public int getId() { 
    	return id; 
    }
    public String getModele() { 
    	return modele; 
    	}
    public void setModele(String m) {
        if (m == null || m.isBlank()) throw new IllegalArgumentException("Modèle vide");
        this.modele = m;
    }
    public boolean estDisponible() { 
    	return disponible; 
    	}
    protected void setDisponible(boolean d) { 
    	this.disponible = d; 
    	}
    public static int getTotalCree() {
    	return COMPTEUR; 
    	}

    protected abstract String categorie();
    public abstract double getTarifJournalier();

    @Override
    public String toString() {
        return "[" + categorie() + " #" + id + " \"" + modele + "\" dispo=" + disponible + "]";
    }

}
