package manipulation_fichiers;

import java.util.Vector;

public class Client {
	private String CodeClient ; 
	private String NomClient ;
	private String AdrClient ;
	private String TelClient;
	private Vector<Commande> ListeCommandes ;
	
	public Client(String codeClient, String nomClient, String adrClient, String telClient) {
		CodeClient = codeClient;
		NomClient = nomClient;
		AdrClient = adrClient;
		TelClient = telClient;
		this.ListeCommandes = new Vector<>();
	}
	public boolean EnregistrerCommande(Commande cmd) {
		return ListeCommandes.add(cmd);
		
	}
	public boolean supprimerCommande(int numCommande) {
        for (Commande c : ListeCommandes) {
            if (c.getNumCommande() == numCommande) {
            	ListeCommandes.remove(c);
                return true;
            }
        }
        return false;
    }
	public Vector<Commande> getListeCommandes() {
        return ListeCommandes;
    }
	@Override
	public String toString() {
		return "Client [CodeClient=" + CodeClient + ", NomClient=" + NomClient + ", AdrClient=" + AdrClient
				+ ", TelClient=" + TelClient + ", ListeCommandes=" + ListeCommandes + "]";
	}
}
