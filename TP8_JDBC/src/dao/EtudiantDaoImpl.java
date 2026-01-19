package dao;

import java.sql.*;
import java.util.*;

import JDBC.Etudiant;

public class EtudiantDaoImpl implements IEtudiantDao {
	private Connection conn = ConnectionDB.getConnection();

	@Override
	public Etudiant save(Etudiant e) {
		try {
			String req=" INSERT INTO ETUDIANTS(Nom, Prenom, Email, Ville) VALUES(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(req); 
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getVille());
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return null;
	}

	@Override
	public Etudiant update(Etudiant e) {
		try {
			String req=" UPDATE ETUDIANTS SET Nom=?, Prenom=?, Email=?, Ville=? WHERE Id_Etud=?";
			PreparedStatement ps=conn.prepareStatement(req); 
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getVille());
			ps.setInt(5, e.getIdEtud());
			ps.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int idEtud) {
		try {
			String req="  DELETE FROM ETUDIANTS WHERE Id_Etud=?";
			PreparedStatement ps=conn.prepareStatement(req); 
			ps.setInt(1, idEtud);
			return ps.executeUpdate()>0;

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public Etudiant findById(int idEtud) {
		Etudiant e = null;
		try {
			String req="SELECT * FROM ETUDIANTS WHERE Id_Etud=?";
			PreparedStatement ps=conn.prepareStatement(req); 
			ps.setInt(1, idEtud);
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
			    e = new Etudiant(
			        rs.getInt("Id_Etud"),
			        rs.getString("Nom"),
			        rs.getString("Prenom"),
			        rs.getString("Email"),
			        rs.getString("Ville")
			    );
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> liste = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ETUDIANTS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new Etudiant(
                    rs.getInt("Id_Etud"),
                    rs.getString("Nom"),
                    rs.getString("Prenom"),
                    rs.getString("Email"),
                    rs.getString("Ville")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
	}

	@Override
	public List<Etudiant> findByNom(String mc) {
		  List<Etudiant> liste = new ArrayList<>();
	        try {
	            PreparedStatement ps = conn.prepareStatement(
	                "SELECT * FROM ETUDIANTS WHERE Nom LIKE ?"
	            );
	            ps.setString(1, "%" + mc + "%");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                liste.add(new Etudiant(
	                    rs.getInt("Id_Etud"),
	                    rs.getString("Nom"),
	                    rs.getString("Prenom"),
	                    rs.getString("Email"),
	                    rs.getString("Ville")
	                ));
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return liste;
	}

}
