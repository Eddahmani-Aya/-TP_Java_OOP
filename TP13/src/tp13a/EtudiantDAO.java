package tp13a;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EtudiantDAO {
	public List<Etudiant> findAll() {
		List<Etudiant> list= new ArrayList<Etudiant>();
		String req="Select *from Etudiants";
		try {
			Connection conn = DriverManager.getConnection(DbConfig.URL,DbConfig.USER,DbConfig.PASSWORD);
			PreparedStatement pr=conn.prepareStatement(req);
			ResultSet rs= pr.executeQuery();
			while (rs.next()) {
                list.add(new Etudiant(
                        rs.getInt("id"),
                        rs.getString("prenom"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getDate("dateinscription").toString()
                ));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void insert(String prenom, String nom, String email, String dat) {
		String req = "INSERT INTO etudiant(prenom, nom, email, dateinscription) VALUES (?, ?, ?, ?)";
		try {
			Connection conn = DriverManager.getConnection(DbConfig.URL,DbConfig.USER,DbConfig.PASSWORD);
			PreparedStatement pr=conn.prepareStatement(req);
			pr.setString(1, prenom);
			pr.setString(2, nom);
			pr.setString(3, email);
			pr.setDate(4, Date.valueOf(dat));
			pr.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Etudiant> search(String prenom, String nom, String email) {
		List<Etudiant> list= new ArrayList<Etudiant>();
		String req="Select *from Etudiants where prenom LIKE ? OR nom LIKE ? OR email LIKE ?";
		try {
			Connection conn = DriverManager.getConnection(DbConfig.URL,DbConfig.USER,DbConfig.PASSWORD);
			PreparedStatement pr=conn.prepareStatement(req);
			pr.setString(1, prenom);
			pr.setString(2, nom);
			pr.setString(3, email);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
                list.add(new Etudiant(
                        rs.getInt("id"),
                        rs.getString("prenom"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getDate("dateinscription").toString()
                ));
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
