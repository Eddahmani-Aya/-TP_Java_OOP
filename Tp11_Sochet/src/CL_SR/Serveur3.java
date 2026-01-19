package CL_SR;

import java.io.IOException;
import java.net.ServerSocket;

public class Serveur3 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ServerSocket s;
		try{
			s = new ServerSocket(2025);
			System.out.println(" Serveur concurrent prêt :");
			int numClient =1;
			while(true){
				/*sock = so.accept();
				System.out.println("Le client numéro "+nbrclient+ " est connecté !");
				Thread t = new Thread(new AccepterClients(s));
				t.start();
				nbrclient++;
				sock.close();
				System.out.println("Vous: ");
				br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
				br.readLine();
				PrintWriter out =new PrintWriter(sock.getOutputStream());
				out.println();
				out.flush();*/
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}

