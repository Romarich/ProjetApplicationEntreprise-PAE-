package be.ipl.pae.persistance.impl;

import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.business.impl.Programme;
import be.ipl.pae.business.interfaces.Factory;
import be.ipl.pae.exceptions.FatalException;
import be.ipl.pae.persistance.interfaces.DalBackendService;
import be.ipl.pae.persistance.interfaces.PaysDao;
import be.ipl.pae.persistance.interfaces.Queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaysDaoImpl implements PaysDao {

  private Factory factory;
  private DalBackendService dalBackendService;

  public PaysDaoImpl(Factory factory, DalBackendService dalBackendService) {
    this.factory = factory;
    this.dalBackendService = dalBackendService;
  }

  @Override
  public List<Pays> getTousPays() {
    ArrayList<Pays> paysList = new ArrayList<>();
    try (PreparedStatement searchPays = dalBackendService.getPreparedStatement(Queries.TOUS_PAYS)) {
      try (ResultSet rs = searchPays.executeQuery()) {
        while (rs.next()) {
          paysList.add(PaysDao.creerPaysDepuisResultSet(rs, factory));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete getTousPays n a pas correctement aboutie");
    }
    return paysList;
  }

  @Override
  public List<Pays> getTousPaysParProgramme(Programme programme) {
    ArrayList<Pays> paysList = new ArrayList<>();
    try (PreparedStatement searchPays =
        dalBackendService.getPreparedStatement(Queries.TOUS_PAYS_PAR_PROGRAMME)) {
      searchPays.setString(1, programme.name());
      try (ResultSet rs = searchPays.executeQuery()) {
        while (rs.next()) {
          paysList.add(PaysDao.creerPaysDepuisResultSet(rs, factory));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException(
          "Votre requete getTousPaysParProgramme n a pas correctement aboutie");
    }
    return paysList;
  }
}
