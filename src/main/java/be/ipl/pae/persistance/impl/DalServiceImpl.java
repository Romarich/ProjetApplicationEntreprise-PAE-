package be.ipl.pae.persistance.impl;

import be.ipl.pae.config.PropertiesManager;
import be.ipl.pae.exceptions.FatalException;
import be.ipl.pae.persistance.interfaces.DalBackendService;
import be.ipl.pae.persistance.interfaces.DalService;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DalServiceImpl implements DalService, DalBackendService {

  private static ThreadLocal<Connection> localConnections = new ThreadLocal<>();

  private static BasicDataSource basicDataSource;

  /**
   * Permet de créer la BasicDataSource qui retient les données de connexion à la DB.
   *
   * @param pm - PropertiesManager qui contient les données de connexion.
   */
  public DalServiceImpl(PropertiesManager pm) {
    String driverName = pm.getValeur("db_driver");
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException exc) {
      throw new FatalException("Probleme Driver");
    }
    basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName(driverName);
    basicDataSource.setUsername(pm.getValeur("db_user"));
    basicDataSource.setPassword(pm.getValeur("db_pass"));
    basicDataSource.setUrl(pm.getValeur("db_url"));
  }

  @Override
  public PreparedStatement getPreparedStatement(String query) throws SQLException {
    return localConnections.get().prepareStatement(query);
  }

  @Override
  public PreparedStatement getPreparedStatementAvecCleRetour(String query) throws SQLException {
    return localConnections.get().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
  }

  @Override
  public void demarrerTransaction() {
    try {
      if (localConnections.get() == null) {
        localConnections.set(basicDataSource.getConnection());
      }
      localConnections.get().setAutoCommit(false);
    } catch (SQLException exc) {
      throw new FatalException();
    }
  }

  @Override
  public void soumettreTransaction() {
    try {
      if (localConnections.get() != null) {
        localConnections.get().commit();
        localConnections.get().setAutoCommit(true);
        localConnections.get().close();
        localConnections.remove();
      }

    } catch (SQLException exc) {
      throw new FatalException();
    }
  }

  @Override
  public synchronized void annulerTransaction() {
    try {
      if (localConnections.get() != null) {
        localConnections.get().rollback();
        localConnections.get().setAutoCommit(true);
        localConnections.get().close();
        localConnections.remove();
      }
    } catch (SQLException exc) {
      throw new FatalException();
    }
  }
}
