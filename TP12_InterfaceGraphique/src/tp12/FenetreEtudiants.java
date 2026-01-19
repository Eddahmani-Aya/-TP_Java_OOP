package tp12;

import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.*;

public class FenetreEtudiants extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField txtPrenom, txtNom, txtEmail, txtDate, txtRecherche;
	private DefaultTableModel model;
    private JTable table;

	public FenetreEtudiants() {
		setTitle("Gestion des étudiants");
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		String[] cols = {"ID", "Prénom", "Nom", "Email", "Date inscription"};
		model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        JPanel panelForm =new JPanel(new GridLayout(4,2,8,5));
        txtPrenom = new JTextField();
        txtNom = new JTextField();
        txtEmail = new JTextField();
        txtDate = new JTextField();
        
        panelForm.add(new JLabel("Prénom"));
        panelForm.add(txtPrenom);
        panelForm.add(new JLabel("Nom"));
        panelForm.add(txtNom);
        panelForm.add(new JLabel("Email"));
        panelForm.add(txtEmail);
        panelForm.add(new JLabel("Date (YYYY-MM-DD)"));
        panelForm.add(txtDate);
        
        add(panelForm, BorderLayout.NORTH);
        
        JPanel panelBtn = new JPanel(new FlowLayout());

        JButton btnImporter = new JButton("Importer");
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnRechercher = new JButton("Rechercher");
        JButton btnSupprimer = new JButton("Supprimer");
        JButton btnVider = new JButton("Vider");
        JButton btnQuitter = new JButton("Quitter");

        txtRecherche = new JTextField(10);
       
        panelBtn.add(btnImporter);
        panelBtn.add(btnAjouter);
        panelBtn.add(new JLabel("Mot clé:"));
        panelBtn.add(txtRecherche);
        panelBtn.add(btnRechercher);
        panelBtn.add(btnSupprimer);
        panelBtn.add(btnVider);
        panelBtn.add(btnQuitter);

        add(panelBtn, BorderLayout.SOUTH);
        
        btnImporter.addActionListener(e -> importer());

        btnAjouter.addActionListener(e -> ajouter());

        btnRechercher.addActionListener(e -> rechercher());

        btnSupprimer.addActionListener(e -> supprimer());

        btnVider.addActionListener(e -> model.setRowCount(0));

        btnQuitter.addActionListener(e -> System.exit(0));
		
	}
	
	private void importer() {
		 model.setRowCount(0);
        String sql = "SELECT * FROM etudiant";

        try (Connection cn = Main.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("prenom"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getDate("dateinscription")
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
	}
    private void ajouter() {
    	if (txtPrenom.getText().isEmpty() ||
            txtNom.getText().isEmpty() ||
            txtEmail.getText().isEmpty() ||
            txtDate.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires");
            return;
        }

        String sql = "INSERT INTO etudiant(prenom, nom, email, dateinscription) VALUES (?,?,?,?)";

        try (Connection cn = Main.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, txtPrenom.getText());
            ps.setString(2, txtNom.getText());
            ps.setString(3, txtEmail.getText());
            ps.setDate(4, Date.valueOf(txtDate.getText()));

            ps.executeUpdate();
            importer();
            model.setRowCount(0);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
}
    private void rechercher() {
        model.setRowCount(0);
        String sql = "SELECT * FROM etudiant WHERE nom LIKE ? OR prenom LIKE ?";

        try (Connection cn = Main.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            String key = "%" + txtRecherche.getText() + "%";
            ps.setString(1, key);
            ps.setString(2, key);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("prenom"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getDate("dateinscription")
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    private void supprimer() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        int rep = JOptionPane.showConfirmDialog(this, "Supprimer ?", "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (rep == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM etudiant WHERE id=?";

            try (Connection cn = Main.getConnection();
                 PreparedStatement ps = cn.prepareStatement(sql)) {

                ps.setInt(1, id);
                ps.executeUpdate();
                importer();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    
    
	public static void main(String[] args) {
        new FenetreEtudiants().setVisible(true);
    }


}
