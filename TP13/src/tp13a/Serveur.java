package tp13a;

import java.io.*;
import java.net.*;

public class Serveur {
    public static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Serveur démarré sur le port " + PORT);

            while (true) {
                Socket client = server.accept();
                new Thread(() -> traiterClient(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void traiterClient(Socket client) {
        try (BufferedReader in = new BufferedReader(
                     new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

            EtudiantDAO dao = new EtudiantDAO();
            String line;

            while ((line = in.readLine()) != null) {
                if (line.equalsIgnoreCase("QUIT")) break;

                if (line.equals("LIST")) {
                    for (Etudiant e : dao.findAll()) {
                        out.println(e.getId() + "|" + e.getPrenom() + "|" +
                                e.getNom() + "|" + e.getEmail() + "|" + e.getDateInscription());
                    }
                    out.println("END");
                }

                else if (line.startsWith("ADD")) {
                    try {
                        String[] t = line.split("\\|");
                        dao.insert(t[1], t[2], t[3], t[4]);
                        out.println("OK");
                        out.println("END");
                    } catch (Exception ex) {
                        out.println("ERREUR|" + ex.getMessage());
                        out.println("END");
                    }
                }

                else if (line.startsWith("SEARCH")) {
                    String key = line.split("\\|")[1];
                    for (Etudiant e : dao.search(key, key, key)) {
                        out.println(e.getId() + "|" + e.getPrenom() + "|" +
                                e.getNom() + "|" + e.getEmail() + "|" + e.getDateInscription());
                    }
                    out.println("END");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
