package be.ipl.pae.persistance.impl;

import be.ipl.pae.business.impl.Role;
import be.ipl.pae.business.interfaces.Factory;
import be.ipl.pae.business.interfaces.UtilisateurDto;
import be.ipl.pae.exceptions.FatalException;
import be.ipl.pae.persistance.interfaces.DalBackendService;
import be.ipl.pae.persistance.interfaces.Queries;
import be.ipl.pae.persistance.interfaces.UtilisateurDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDaoImpl implements UtilisateurDao {

  private Factory factory;
  private DalBackendService dalBackendService;

  public UtilisateurDaoImpl(Factory factory, DalBackendService dalBackendService) {
    this.factory = factory;
    this.dalBackendService = dalBackendService;
  }

  @Override
  public UtilisateurDto trouverUtilisateurParPseudo(String pseudo) {
    UtilisateurDto utilisateur = null;
    try (PreparedStatement rechercheUtilisateur =
        dalBackendService.getPreparedStatement(Queries.CONNEXION_UTILISATEUR)) {
      rechercheUtilisateur.setString(1, pseudo);
      try (ResultSet rs = rechercheUtilisateur.executeQuery()) {
        if (rs.next()) {
          utilisateur = creerUtilisateurDepuisResultSet(rs);
        }
      }
    } catch (SQLException exc) {
      throw new FatalException(
          "Votre requête trouverUtilisateurParPseudo n'a pas aboutie correctement.");
    }
    return utilisateur;
  }

  @Override
  public UtilisateurDto trouverUtilisateurParEmail(String email) {
    UtilisateurDto utilisateur = null;
    try (PreparedStatement rechercheUtilisateur =
        dalBackendService.getPreparedStatement(Queries.RECHERCHE_UTILISATEUR_PAR_EMAIL)) {
      rechercheUtilisateur.setString(1, email);
      try (ResultSet rs = rechercheUtilisateur.executeQuery()) {
        if (rs.next()) {
          utilisateur = creerUtilisateurDepuisResultSet(rs);
        }
      }
    } catch (SQLException exc) {
      throw new FatalException(
          "Votre requête trouverUtilisateurParEmail n'a pas aboutie correctement.");
    }
    return utilisateur;
  }

  /**
   * Permet de créer un UserDto à partir d'un ResultSet.
   *
   * @param rs - Le RésultSet à lire.
   * @return Un utilisateur.
   */
  private UtilisateurDto creerUtilisateurDepuisResultSet(ResultSet rs) throws SQLException {
    UtilisateurDto utilisateur = factory.getUtilisateurVide();
    utilisateur.setId(rs.getInt("id_utilisateur"));
    utilisateur.setPseudo(rs.getString("pseudo"));
    utilisateur.setMotDePasse(rs.getString("mdp"));
    utilisateur.setNom(rs.getString("nom"));
    utilisateur.setPrenom(rs.getString("prenom"));
    utilisateur.setEmail(rs.getString("email"));
    utilisateur.setDateInscription(rs.getTimestamp("date_inscription").toLocalDateTime());
    utilisateur.setRole(Role.valueOf(rs.getString("role")));
    utilisateur.setPhoto(rs.getString("photo_profil"));
    return utilisateur;
  }

  @Override
  public UtilisateurDto creerUtilisateur(UtilisateurDto user) {
    try (PreparedStatement inscriptionUtilisateur =
        dalBackendService.getPreparedStatementAvecCleRetour(Queries.INSERT_UTILISATEUR)) {
      Timestamp timestamp = Timestamp.valueOf(user.getDateInscription());
      inscriptionUtilisateur.setString(1, user.getPseudo());
      inscriptionUtilisateur.setString(2, user.getMotDePasse());
      inscriptionUtilisateur.setString(3, user.getNom());
      inscriptionUtilisateur.setString(4, user.getPrenom());
      inscriptionUtilisateur.setString(5, user.getEmail());
      inscriptionUtilisateur.setTimestamp(6, timestamp);
      inscriptionUtilisateur.setString(7, user.getRole().name());
      inscriptionUtilisateur.executeUpdate();
      try (ResultSet generatedKeys = inscriptionUtilisateur.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          user.setId(generatedKeys.getInt(1));
        } else {
          throw new FatalException("Création d'utilisateur raté, pas d'ID optenu.");
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requête creerUtilisateur n'a pas aboutie correctement.");
    }
    return user;
  }

  @Override
  public List<UtilisateurDto> getTousUtilisateurs() {
    ArrayList<UtilisateurDto> utilisateursList = new ArrayList<>();
    try (PreparedStatement searchUser =
        dalBackendService.getPreparedStatement(Queries.LIST_UTILISATEURS)) {
      try (ResultSet rs = searchUser.executeQuery()) {
        while (rs.next()) {
          utilisateursList.add(creerUtilisateurDepuisResultSet(rs));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete getTousUtilisateurs n a pas correctement aboutie");
    }
    return utilisateursList;
  }

  @Override
  public List<UtilisateurDto> getUtilisateurAvecRole(Role role) {
    ArrayList<UtilisateurDto> utilisateursList = new ArrayList<>();
    try (PreparedStatement rechercheUtilisateurRole =
                 dalBackendService.getPreparedStatement(Queries.LIST_UTILISATEUR_PAR_ROLE)) {
      rechercheUtilisateurRole.setString(1, role.name());
      try (ResultSet rs = rechercheUtilisateurRole.executeQuery()) {
        while (rs.next()) {
          utilisateursList.add(creerUtilisateurDepuisResultSet(rs));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete getUtilisateurAvecRole n a pas correctement aboutie");
    }
    return utilisateursList;
  }

  @Override
  public List<UtilisateurDto> trouverUtilisateurParNom(String nom) {
    ArrayList<UtilisateurDto> utilisateur = new ArrayList<>();
    try (PreparedStatement rechercheUtilisateurs =
        dalBackendService.getPreparedStatement(Queries.RECHERCHE_UTILISATEUR_NOM)) {
      rechercheUtilisateurs.setString(1, nom);
      try (ResultSet rs = rechercheUtilisateurs.executeQuery()) {
        while (rs.next()) {
          utilisateur.add(creerUtilisateurDepuisResultSet(rs));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete findUser n a pas correctement aboutie");
    }
    return utilisateur;
  }

  @Override
  public List<UtilisateurDto> trouverUtilisateurParPrenom(String prenom) {
    ArrayList<UtilisateurDto> utilisateur = new ArrayList<>();
    try (PreparedStatement recherchePrenom =
        dalBackendService.getPreparedStatement(Queries.RECHERCHE_UTILISATEUR_PRENOM)) {
      recherchePrenom.setString(1, prenom);
      try (ResultSet rs = recherchePrenom.executeQuery()) {
        while (rs.next()) {
          utilisateur.add(creerUtilisateurDepuisResultSet(rs));
        }
      }

    } catch (SQLException exc) {
      throw new FatalException("Votre requete findUser n a pas correctement aboutie");
    }
    return utilisateur;
  }

  @Override
  public List<UtilisateurDto> trouverUtilisateurParNomEtPrenom(String nom, String prenom) {
    ArrayList<UtilisateurDto> utilisateur = new ArrayList<>();
    try (PreparedStatement rechercheUtilisateurNomPrenom =
        dalBackendService.getPreparedStatement(Queries.RECHERCHE_UTILISATEUR_NOM_PRENOM)) {
      rechercheUtilisateurNomPrenom.setString(1, nom);
      rechercheUtilisateurNomPrenom.setString(2, prenom);
      try (ResultSet rs = rechercheUtilisateurNomPrenom.executeQuery()) {
        while (rs.next()) {
          utilisateur.add(creerUtilisateurDepuisResultSet(rs));
        }
      }
    } catch (SQLException exc) {
      throw new FatalException("Votre requete findUser n a pas correctement aboutie");
    }
    return utilisateur;
  }
}
