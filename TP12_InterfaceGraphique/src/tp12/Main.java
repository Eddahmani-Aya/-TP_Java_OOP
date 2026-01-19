package tp12;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame("Importation depuis MySQL");
		fenetre.setBounds(100, 100, 600, 400);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLayout(new BorderLayout());
		String[] columnNames = {"id", "prenom", "nom", "email", "date d'inscription"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(model); JScrollPane scrollPane = new JScrollPane(table);
		JButton bouton = new JButton("Importer depuis la base");
		bouton.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		 try {
		String url = "jdbc:mysql://localhost:3306/gestionetudiants";
		String user = "root";
		String password = "AYATON223";
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id, prenom, nom, email, dateinscription FROM etudiant");
		while (rs.next()) {
		 Object[] row = { rs.getInt("id"), rs.getString("prenom"), rs.getString("nom"),
		 rs.getString("email"), rs.getDate("dateinscription") };
		 model.addRow(row);}
		 rs.close();
		 stmt.close();
		 conn.close();
		} catch (Exception ex) {
		 JOptionPane.showMessageDialog(fenetre, "Erreur: " + ex.getMessage());
		} } });
		fenetre.add(bouton, BorderLayout.NORTH); fenetre.add(scrollPane, BorderLayout.CENTER);
		fenetre.setVisible(true);
	}

	public static Connection getConnection()  {
        try {
			return DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/gestionetudiants",
			    "root",
			    "AYATON223"
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

}
