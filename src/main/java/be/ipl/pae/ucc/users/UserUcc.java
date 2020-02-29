package be.ipl.pae.ucc.users;

import be.ipl.pae.business.users.UserDto;

public interface UserUcc {

  /**
   * Permet de connecter un utilisateur.
   *
   * @param pseudo - Pseudo de l'utilisateur à connecter.
   * @param password - Mot de passe de l'utilisateur à connecter.
   * @return Le nouvel utilisateur connecter.
   */
  UserDto connectUser(String pseudo, String password);

  /**
   * Permet d'enregistrer un nouvel utilisateur.
   *
   * @param userRegister Utilisateur à enregistrer.
   * @param password Mot de passe de l'utilisateur.
   * @return Le nouvel utilisateur.
   */
  UserDto registerUser(UserDto userRegister, String password);
}
