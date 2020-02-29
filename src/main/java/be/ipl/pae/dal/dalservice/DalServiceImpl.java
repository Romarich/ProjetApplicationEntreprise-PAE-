package be.ipl.pae.dal.dalservice;

import be.ipl.pae.exceptions.FatalException;
import be.ipl.pae.main.PropertiesManager;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DalServiceImpl implements DalService, DalBackendService {

  private static ThreadLocal<Connection> localConnections = new ThreadLocal<>();

  private static BasicDataSource basicDataSource;

  public DalServiceImpl(PropertiesManager pm) {
    String driverName = pm.getValue("db_driver");
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException exc) {
      throw new FatalException("Probleme Driver");
    }
    basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName(driverName);
    basicDataSource.setUsername(pm.getValue("db_user"));
    basicDataSource.setPassword(pm.getValue("db_pass"));
    basicDataSource.setUrl(pm.getValue("db_url"));
  }

  @Override
  public PreparedStatement getPreparedStatement(String query) throws SQLException {
    return localConnections.get().prepareStatement(query);
  }

  @Override
  public void startTransaction() {
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
  public void commitTransaction() {
    try {
      if (localConnections.get() != null) {
        localConnections.get().commit();
        localConnections.get().setAutoCommit(true);
        localConnections.get().close();
        localConnections.set(null);
      }

    } catch (SQLException exc) {
      throw new FatalException();
    }
  }

  @Override
  public synchronized void rollBackTransaction() {
    try {
      if (localConnections.get() != null) {
        localConnections.get().rollback();
        localConnections.get().setAutoCommit(true);
        localConnections.get().close();
        localConnections.set(null);
      }
    } catch (SQLException exc) {
      throw new FatalException();
    }
  }
}
