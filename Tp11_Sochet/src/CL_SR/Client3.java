package CL_SR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client3 {
	public static void main(String[] args) {
		BufferedReader br;
		Socket soc;
		try {
			soc = new Socket("localhost",2025);
			soc.close();
			System.out.println("Vous: ");
			br=new BufferedReader(new InputStreamReader(System.in));
			br.readLine();
			
			PrintWriter out =new PrintWriter(soc.getOutputStream(),true);//equales flash
			out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

