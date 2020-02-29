package be.ipl.pae.persistance.interfaces;

import be.ipl.pae.business.impl.Role;
import be.ipl.pae.business.interfaces.UtilisateurDto;

import java.util.List;

public interface UtilisateurDao {

  /**
   * Recherche un utilisateur d'après son pseudo et son mot de passe.
   *
   * @param pseudo - Pseudo de l'utilisateur à retrouver.
   * @return L'utilisateur vide si il n'est pas trouvé.
   */
  UtilisateurDto trouverUtilisateurParPseudo(String pseudo);

  /**
   * Recherche un utilisateur d'après son pseudo et son mot de passe.
   *
   * @param email - Email de l'utilisateur à retrouver.
   * @return L'utilisateur vide si il n'est pas trouvé.
   */
  UtilisateurDto trouverUtilisateurParEmail(String email);

  /**
   * Insère un nouvel utilisateur dans la base de donnée.
   *
   * @param user - Utilisateur.
   * @return L'utilisateur insérée.
   */
  UtilisateurDto creerUtilisateur(UtilisateurDto user);

  /**
   * Liste tout les utilisateurs présent dans la DB.
   *
   * @return Liste des utilisateurs dans la DB.
   */
  List<UtilisateurDto> getTousUtilisateurs();

  /**
   * Liste tout les utilisateurs présent dans la DB et qui ont le role définir.
   *
   * @param role - Role que l'on recherche.
   * @return Liste des utilisateurs portant le role dans la DB.
   */
  List<UtilisateurDto> getUtilisateurAvecRole(Role role);

  /* Recherche Use */

  /**
   * Permet de rechercher tout les utilisateurs par un nom.
   *
   * @param nom - Nom à rechercher.
   * @return Liste des utilisateurs portant ce nom. Si il n'y en a pas, retourne une liste vide.
   */
  List<UtilisateurDto> trouverUtilisateurParNom(String nom);

  /**
   * Permet de rechercher tout les utilisateurs par un prénom.
   *
   * @param prenom - Prénom à rechercher.
   * @return Liste des utilisateurs portant ce prénom. Si il n'y en a pas, retourne une liste vide.
   */
  List<UtilisateurDto> trouverUtilisateurParPrenom(String prenom);

  /**
   * Permet de rechercher tout les utilisateurs par un nom et un prénom.
   *
   * @param nom - Nom à rechercher.
   * @param prenom - Prenom à rechercher.
   * @return Liste des utilisateurs portant ce nom et ce prénom. Si il n'y en a pas, retourne une
   *     liste vide.
   */
  List<UtilisateurDto> trouverUtilisateurParNomEtPrenom(String nom, String prenom);
}
