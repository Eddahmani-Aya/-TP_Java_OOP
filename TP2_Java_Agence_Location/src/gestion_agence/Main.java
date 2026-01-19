package gestion_agence;

public class Main {
	public static void main(String[] args) {
		 Vehicule[] parc = new Vehicule[4];
		
		 parc[0] = new Voiture("Renault", "Clio", 2020, true, 5);
	     parc[1] = new Moto("Yamaha", "MT-07", 2022, true, 689);
	     parc[2] = new Camion("Mercedes", "Actros", 2019, false, 19.0);
	     parc[3] = new Velo("Decathlon", "Riverside", 2021, true, "VTT");
	     
	     System.out.println("=== Tous Les Vehicules de Notre Parc ===");
	     for ( Vehicule v : parc ) {
	    	 v.afficher();
	    	 System.out.println("--------------------");
	     }
	     
	     
	     System.out.println("\n=== TEST DES INTERFACES ===");
	        Louable voitureLouable = (Louable) parc[0]; 
	        Louable motoLouable = (Louable) parc[1];    
	        
	        voitureLouable.louer();
	        motoLouable.louer();
	        
	        voitureLouable.retourner();
	        motoLouable.retourner();
	}
}
