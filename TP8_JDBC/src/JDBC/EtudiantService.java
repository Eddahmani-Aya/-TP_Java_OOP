package JDBC;

import dao.*;
import java.util.*;

public class EtudiantService {

    private IEtudiantDao dao = new EtudiantDaoImpl();

    public Etudiant ajouterEtudiant(Etudiant e) {
        if (e.getNom().isEmpty()) return null;
        return dao.save(e);
    }

    public Etudiant modifierEtudiant(Etudiant e) {
        return dao.update(e);
    }

    public boolean supprimerEtudiant(int id) {
        return dao.delete(id);
    }

    public List<Etudiant> listerEtudiants() {
        return dao.findAll();
    }

    public List<Etudiant> chercherParNom(String mc) {
        return dao.findByNom(mc);
    }
}
