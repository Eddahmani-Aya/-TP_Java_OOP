package presentation;

import java.util.Scanner;
import JDBC.Etudiant;
import JDBC.EtudiantService;

public class ConsoleApp {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        EtudiantService service = new EtudiantService();
        int choix;

        do {
            System.out.println("\n===== GESTION DES ETUDIANTS =====");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Modifier un étudiant");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Lister tous les étudiants");
            System.out.println("5. Rechercher par nom");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nom : ");
                    String nom = sc.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = sc.nextLine();
                    System.out.print("Email : ");
                    String email = sc.nextLine();
                    System.out.print("Ville : ");
                    String ville = sc.nextLine();
                    service.ajouterEtudiant(new Etudiant(nom, prenom, email, ville));
                    break;

                case 2:
                    System.out.print("ID de l'étudiant : ");
                    int idM = sc.nextInt(); sc.nextLine();
                    System.out.print("Nouveau nom : ");
                    String nom2 = sc.nextLine();
                    System.out.print("Nouveau prénom : ");
                    String prenom2 = sc.nextLine();
                    System.out.print("Email : ");
                    String email2 = sc.nextLine();
                    System.out.print("Ville : ");
                    String ville2 = sc.nextLine();
                    service.modifierEtudiant(new Etudiant(idM, nom2, prenom2, email2, ville2));
                    break;

                case 3:
                    System.out.print("ID à supprimer : ");
                    int idS = sc.nextInt();
                    service.supprimerEtudiant(idS);
                    break;

                case 4:
                    service.listerEtudiants().forEach(System.out::println);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Mot clé : ");
                    String mc = sc.nextLine();
                    service.chercherParNom(mc).forEach(System.out::println);
                    break;
            }

        } while (choix != 0);

        System.out.println("Au revoir !");
    }
}
