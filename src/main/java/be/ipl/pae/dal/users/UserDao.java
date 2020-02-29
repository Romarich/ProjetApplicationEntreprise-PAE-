package be.ipl.pae.dal.users;

import be.ipl.pae.business.users.UserDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {

  /**
   * Recherche un utilisateur d'après son pseudo et son mot de passe.
   *
   * @param pseudo - Pseudo de l'utilisateur à retrouver.
   * @return L'utilisateur vide si il n'est pas trouvé.
   */
  UserDto findUserByPseudo(String pseudo);

  /**
   * Recherche un utilisateur d'après son pseudo et son mot de passe.
   *
   * @param email - Email de l'utilisateur à retrouver.
   * @return L'utilisateur vide si il n'est pas trouvé.
   */
  UserDto findUserByEmail(String email);

  /**
   * Permet de créer un UserDto à partir d'un ResultSet.
   *
   * @param rs - Le RésultSet à lire.
   * @return Un utilisateur.
   */
  UserDto createUserWithResultSet(ResultSet rs) throws SQLException;

  /**
   * Insère un nouvel utilisateur dans la base de donnée.
   *
   * @param user - Utilisateur.
   * @return L'utilisateur insérée.
   */
  UserDto createUser(UserDto user);

  /**
   * Liste tout les utilisateurs présent dans la DB.
   *
   * @return List des utilisateurs dans la DB.
   */
  ArrayList<UserDto> getAllUsers();

  /* Recherche Use */

  /**
   * Permet de rechercher tout les utilisateurs par un nom.
   *
   * @param nom - Nom à rechercher.
   * @return Liste des utilisateurs portant ce nom. Si il n'y en a pas, retourne une liste vide.
   */
  List<UserDto> findUsersByNom(String nom);

  /**
   * Permet de rechercher tout les utilisateurs par un prénom.
   *
   * @param prenom - Prénom à rechercher.
   * @return Liste des utilisateurs portant ce prénom. Si il n'y en a pas, retourne une liste vide.
   */
  List<UserDto> findUsersByPrenom(String prenom);

  /**
   * Permet de rechercher tout les utilisateurs par un nom et un prénom.
   *
   * @param nom - Nom à rechercher.
   * @param prenom - Prenom à rechercher.
   * @return Liste des utilisateurs portant ce nom et ce prénom. Si il n'y en a pas, retourne une
   *     liste vide.
   */
  List<UserDto> findUsersByNomAndPrenom(String nom, String prenom);
}
