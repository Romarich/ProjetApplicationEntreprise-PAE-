package be.ipl.pae.dal.users;

import be.ipl.pae.business.factory.Factory;
import be.ipl.pae.business.users.Role;
import be.ipl.pae.business.users.UserDto;
import be.ipl.pae.dal.Queries;
import be.ipl.pae.dal.dalservice.DalBackendService;
import be.ipl.pae.exceptions.FatalException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

  private Factory factory;
  private DalBackendService dalBackendService;

  public UserDaoImpl(Factory factory, DalBackendService dalBackendService) {
    this.factory = factory;
    this.dalBackendService = dalBackendService;
  }

  @Override
  public UserDto findUserByPseudo(String pseudo) {
    UserDto user = null;
    try (PreparedStatement searchUser =
        dalBackendService.getPreparedStatement(Queries.CONNEXION_UTILISATEUR)) {
      searchUser.setString(1, pseudo);
      try (ResultSet rs = searchUser.executeQuery()) {
        if (rs.next()) {
          user = createUserWithResultSet(rs);
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requête findUserByPseudo n'a pas aboutie correctement.");
    }
    return user;
  }

  @Override
  public UserDto findUserByEmail(String email) {
    UserDto user = null;
    try (PreparedStatement searchUser =
        dalBackendService.getPreparedStatement(Queries.FIND_USER_BY_EMAIL)) {
      searchUser.setString(1, email);
      try (ResultSet rs = searchUser.executeQuery()) {
        if (rs.next()) {
          user = createUserWithResultSet(rs);
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requête findUserByEmail n'a pas aboutie correctement.");
    }
    return user;
  }

  @Override
  public UserDto createUserWithResultSet(ResultSet rs) throws SQLException {
    UserDto user = factory.getEmptyUser();
    user.setPseudo(rs.getString("pseudo"));
    user.setMotDePasse(rs.getString("mdp"));
    user.setNom(rs.getString("nom"));
    user.setPrenom(rs.getString("prenom"));
    user.setEmail(rs.getString("email"));
    user.setDateInscritpion(rs.getTimestamp("date_inscription").toLocalDateTime());
    user.setRole(Role.valueOf(rs.getString("role")));
    user.setPhoto(rs.getString("photo_profil"));
    return user;
  }

  @Override
  public UserDto createUser(UserDto user) {
    try (PreparedStatement inscriptionUser =
        dalBackendService.getPreparedStatement(Queries.INSERT_UTILISATEUR)) {
      Timestamp timestamp = Timestamp.valueOf(user.getDateInscritpion());
      inscriptionUser.setString(1, user.getPseudo());
      inscriptionUser.setString(2, user.getMotDePasse());
      inscriptionUser.setString(3, user.getNom());
      inscriptionUser.setString(4, user.getPrenom());
      inscriptionUser.setString(5, user.getEmail());
      inscriptionUser.setTimestamp(6, timestamp);
      inscriptionUser.setString(7, user.getRole().name());
    } catch (SQLException exc) {
      throw new FatalException("Votre requête createUser n'a pas aboutie correctement.");
    }
    return user;
  }

  @Override
  public ArrayList<UserDto> getAllUsers() {
    ArrayList<UserDto> usersToReturn = new ArrayList<>();
    try (PreparedStatement searchUser =
        dalBackendService.getPreparedStatement(Queries.LIST_USERS)) {
      try (ResultSet rs = searchUser.executeQuery()) {
        while (rs.next()) {
          usersToReturn.add(createUserWithResultSet(rs));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete findUser n a pas correctement aboutie");
    }
    return usersToReturn;
  }

  @Override
  public List<UserDto> findUsersByNom(String nom) {
    ArrayList<UserDto> users = new ArrayList<>();
    try (PreparedStatement sercherNom =
        dalBackendService.getPreparedStatement(Queries.RECHERCHE_USER_NOM)) {
      sercherNom.setString(1, nom);
      try (ResultSet rs = sercherNom.executeQuery()) {
        while (rs.next()) {
          users.add(createUserWithResultSet(rs));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete findUser n a pas correctement aboutie");
    }
    return users;
  }

  @Override
  public List<UserDto> findUsersByPrenom(String prenom) {
    ArrayList<UserDto> users = new ArrayList<>();
    try (PreparedStatement sercherPrenom =
        dalBackendService.getPreparedStatement(Queries.RECHERCHE_USER_PRENOM)) {
      sercherPrenom.setString(1, prenom);
      try (ResultSet rs = sercherPrenom.executeQuery()) {
        while (rs.next()) {
          users.add(createUserWithResultSet(rs));
        }
      }

    } catch (SQLException exc) {
      throw new FatalException("Votre requete findUser n a pas correctement aboutie");
    }
    return users;
  }

  @Override
  public List<UserDto> findUsersByNomAndPrenom(String nom, String prenom) {
    ArrayList<UserDto> users = new ArrayList<>();
    try (PreparedStatement sercherUsers =
        dalBackendService.getPreparedStatement(Queries.RECHERCHE_USER_NOM_PRENOM)) {
      sercherUsers.setString(1, nom);
      sercherUsers.setString(2, prenom);
      try (ResultSet rs = sercherUsers.executeQuery()) {
        while (rs.next()) {
          users.add(createUserWithResultSet(rs));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete findUser n a pas correctement aboutie");
    }
    return users;
  }
}
