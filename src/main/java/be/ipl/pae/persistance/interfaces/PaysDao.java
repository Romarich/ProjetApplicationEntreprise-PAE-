package be.ipl.pae.persistance.interfaces;

import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.business.impl.Programme;
import be.ipl.pae.business.interfaces.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PaysDao {

  /**
   * Permet de créer un pays depuis un RésultSet.
   *
   * @param rs - Le résultSet.
   * @param factory - La factory.
   * @return Le pays créer.
   * @throws SQLException - Renvoie la SQLException dans la méthode appelante.
   */
  static Pays creerPaysDepuisResultSet(ResultSet rs, Factory factory) throws SQLException {
    Pays pays = factory.getPaysVide();
    pays.setCodeIso(rs.getString("p.code_iso"));
    pays.setNom(rs.getString("p.nom"));
    pays.setProgramme(Programme.valueOf(rs.getString("p.programme")));
    return pays;
  }

  /**
   * Permet de récupérer tous les pays depuis la DB.
   *
   * @return La liste des pays.
   */
  List<Pays> getTousPays();

  /**
   * Permet de récupérer tous les pays pour un certain programme depuis la DB.
   *
   * @param programme - Le programme que l'on recherche.
   * @return La liste des pays sur le programme rechercher.
   */
  List<Pays> getTousPaysParProgramme(Programme programme);
}
