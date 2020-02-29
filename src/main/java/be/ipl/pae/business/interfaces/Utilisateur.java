package be.ipl.pae.business.interfaces;

public interface Utilisateur extends UtilisateurDto {

  /**
   * Permet de comparer le mot de passe de l'utilisateur avec celui en paramètre.
   *
   * @param mdp - Mot de passe à comparer.
   * @return true si ce sont les même mot de passe, false sinon.
   */
  boolean checkMdp(String mdp);

  /**
   * Permet de Hasher un mot de passe.
   *
   * @param mdp - Mot de passe à hasher.
   * @return Le mot de passe hasher.
   */
  String hashMdp(String mdp);
}
