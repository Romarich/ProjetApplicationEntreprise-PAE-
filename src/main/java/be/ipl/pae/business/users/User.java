package be.ipl.pae.business.users;

public interface User extends UserDto {

  /**
   * Permet de comparer le mot de passe de l'utilisateur avec celui en paramètre.
   *
   * @param password - Mot de passe à comparer.
   * @return true si ce sont les même mot de passe, false sinon.
   */
  boolean checkPassword(String password);

  /**
   * Permet de Hasher un mot de passe.
   *
   * @param password - Mot de passe à hasher.
   * @return Le mot de passe hasher.
   */
  String hashPassword(String password);
}
