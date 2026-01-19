package manipulation_fichiers;


import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			 @SuppressWarnings("deprecation")
			 Commande commande1 = new Commande(1,new Date(2025, 9, 25),"marwa");
			 @SuppressWarnings("deprecation")
			 Commande commande2 = new Commande(2,new Date(2015, 9, 25),"Aya");
			 
			 
			 Client client1 = new Client("1", "habchi", "Sidi ma3rouf", "marwa.habchi02") ;
			 ClientFidel clientFidel = new ClientFidel("2", "Neeko", "Kassbat amine", "edd.aya","111",7777);
			 
			 client1.EnregistrerCommande(commande1);
			 clientFidel.EnregistrerCommande(commande2);
			 
			 ArrayList<Client> list=new ArrayList<Client>();
			 list.add(client1);
			 list.add(clientFidel);
			 
			 
			 Collections.sort(client1.getListeCommandes());
			 
			 @SuppressWarnings("unused")
			 Set<Commande> commandes = new HashSet<Commande>();
			 
			 Map<String, Client> map = new HashMap<>();
			 map.put(client1.toString(), client1);
			 map.put(clientFidel.toString(), clientFidel);
			  
	}

}
