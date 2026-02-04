package tp13a;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientSwingEtudiants extends JFrame { 
    
    private final DefaultTableModel model; 
    private final JTable table; 
 
    private final JTextField txtPrenom = new JTextField(12); 
    private final JTextField txtNom = new JTextField(12); 
    private final JTextField txtEmail = new JTextField(18); 
    private final JTextField txtDate = new JTextField(10); 
    private final JTextField txtRecherche = new JTextField(14); 
 
    public ClientSwingEtudiants() { 
        super("Gestion des etudiants - Client Swing"); 
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] cols = {"id", "prenom", "nom", "email", "date inscription"};
        model = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panelNorth = new JPanel(new GridLayout(2, 4));

        panelNorth.add(new JLabel("Prénom"));
        panelNorth.add(txtPrenom);
        panelNorth.add(new JLabel("Nom"));
        panelNorth.add(txtNom);
        panelNorth.add(new JLabel("Email"));
        panelNorth.add(txtEmail);
        panelNorth.add(new JLabel("Date (yyyy-MM-dd)"));
        panelNorth.add(txtDate);

        add(panelNorth, BorderLayout.NORTH);

        JPanel panelSouth = new JPanel(new FlowLayout());

        JButton btnImporter = new JButton("Importer");
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnRechercher = new JButton("Rechercher");
        JButton btnVider = new JButton("Vider");
        JButton btnQuitter = new JButton("Quitter");

        panelSouth.add(btnImporter);
        panelSouth.add(btnAjouter);
        panelSouth.add(new JLabel("Recherche"));
        panelSouth.add(txtRecherche);
        panelSouth.add(btnRechercher);
        panelSouth.add(btnVider);
        panelSouth.add(btnQuitter);

        add(panelSouth, BorderLayout.SOUTH);
        
        btnImporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<String[]> res = envoyerCommande("selection");
                    model.setRowCount(0); 
                    for (String[] ligne : res) {
                        model.addRow(ligne);
                    }
                    JOptionPane.showMessageDialog(null, "Donnees importees avec succes !");
                } catch (Exception ex) { 
                    JOptionPane.showMessageDialog(null, "Erreur lors de l'importation : " + ex.getMessage()); 
                    ex.printStackTrace();
                }
            }
        });
       
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prenom = txtPrenom.getText();
                String nom = txtNom.getText();
                String email = txtEmail.getText();
                String date = txtDate.getText();

                if (prenom.isEmpty() || nom.isEmpty() || email.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
                    return; 
                } else {
                    try {
                        envoyerCommande("ajouter|" + prenom + "|" + nom + "|" + email + "|" + date);
                        
                        txtPrenom.setText("");
                        txtNom.setText("");
                        txtEmail.setText("");
                        txtDate.setText("");

                        List<String[]> res = envoyerCommande("selection");
                        model.setRowCount(0);
                        for (String[] ligne : res) {
                            model.addRow(ligne);
                        }
                        
                        JOptionPane.showMessageDialog(null, "Étudiant ajouté et liste mise à jour !");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout : " + e1.getMessage());
                    }
                }
            }
        });
	        
        btnRechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String motCle = txtRecherche.getText();
                
                if (motCle.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez saisir un nom ou un email à rechercher !");
                    return;
                }

                try {
                    List<String[]> res = envoyerCommande("chercher|" + motCle);
                    
                    model.setRowCount(0); 
                    
                    if (res.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé pour : " + motCle);
                    } else {
                        for (String[] ligne : res) {
                            model.addRow(ligne);
                        }
                    }

                    txtRecherche.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur lors de la recherche : " + ex.getMessage());
                }
            }
        });
	        
        btnVider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, 
                    "Voulez-vous vider tout le tableau ?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
                
                if (option == JOptionPane.YES_OPTION) {
                    model.setRowCount(0);
                }
            }
        });
	        
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, 
                    "Voulez-vous vraiment quitter l'application ?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
                
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        setVisible(true); 
    } 
 
    // Communication avec le serveur 
    private List<String[]> envoyerCommande(String commande) throws Exception { 
        try (Socket s = new Socket("localhost", 5000); 
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) { 
 
            out.println(commande); 
 
            List<String[]> lignes = new ArrayList<>(); 
            String line; 
            while ((line = in.readLine()) != null) { 
                if (line.equals("END")) break; 
                lignes.add(line.split("\\|")); 
            } 
            return lignes; 
        } 
    } 
    
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientSwingEtudiants();
            }
        });
    } 
}