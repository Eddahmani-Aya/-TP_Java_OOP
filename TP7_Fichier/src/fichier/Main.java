package fichier;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File workspace=new File("workspace.");
		File data=new File(workspace, "data");
		File stock=new File(data, "stock_initial.ser");
		File ventes=new File(data, "ventes.txt");
		//File produits=new File(data, "produits.ser");
		//File photos=new File(workspace, "photos");
		//File index=new File(photos, "index.dat");
		//File logs=new File("logs");
		//File tmp=new File( "tmp");
		
		workspace.mkdirs();
		stock.createNewFile();
		
		if(!ventes.exists()) {
			
		}
		


	}

}
