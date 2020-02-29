package be.ipl.pae.persistance.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DalBackendService {

  /**
   * Renvoie un PreparedStatement près à être exécuté avec la query envoyé en paramètre.
   *
   * @param query String d'une query.
   * @return PreparedStatement qui contient la query.
   * @throws SQLException si une erreur s'est produit en SQL.
   */
  PreparedStatement getPreparedStatement(String query) throws SQLException;

  /**
   * Renvoie un PreparedStatement près à être exécuté avec la query envoyé en paramètre. Et qui
   * renvoie la clée générée.
   *
   * @param query String d'une query.
   * @return PreparedStatement qui contient la query.
   * @throws SQLException si une erreur s'est produit en SQL.
   */
  PreparedStatement getPreparedStatementAvecCleRetour(String query) throws SQLException;
}
