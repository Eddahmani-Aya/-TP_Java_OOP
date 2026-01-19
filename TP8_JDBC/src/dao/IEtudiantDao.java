package dao;

import java.util.List;

import JDBC.Etudiant;

public interface IEtudiantDao {
	/*• Etudiant save(Etudiant e); // ajouter un étudiant
 • Etudiant update(Etudiant e); // modifier un étudiant
 • boolean delete(int idEtud); // supprimer un étudiant par id
 • Etudiant findById(int idEtud); // chercher un étudiant par id
 • List<Etudiant> findAll(); // lister tous les étudiants
 • List<Etudiant> findByNom(String mc); // chercher par mot clé sur le no*/
	public Etudiant save(Etudiant e);
    Etudiant update(Etudiant e);
    boolean delete(int idEtud);
    Etudiant findById(int idEtud);
    List<Etudiant> findAll();
    List<Etudiant> findByNom(String mc);


}
