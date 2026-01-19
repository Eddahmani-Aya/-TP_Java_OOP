package CL_SR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AccepterClients implements Runnable{

	BufferedReader br;
	private ServerSocket so;
	private Socket sock;
	private int nbrclient = 1;
	public AccepterClients(ServerSocket s1){
		so = s1;
	}
	public void run() {
		try{
			while(true){
				sock = so.accept();
				System.out.println("Le client numéro "+nbrclient+ " est connecté !");
				nbrclient++;
				sock.close();
				System.out.println("Vous: ");
				br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
				br.readLine();
				PrintWriter out =new PrintWriter(sock.getOutputStream());
				out.println();
				out.flush();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
