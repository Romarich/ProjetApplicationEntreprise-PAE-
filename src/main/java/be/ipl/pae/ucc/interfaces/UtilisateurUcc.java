package be.ipl.pae.ucc.interfaces;

import be.ipl.pae.business.interfaces.UtilisateurDto;

public interface UtilisateurUcc {

  /**
   * Permet de connecter un utilisateur.
   *
   * @param pseudo - Pseudo de l'utilisateur à connecter.
   * @param password - Mot de passe de l'utilisateur à connecter.
   * @return Le nouvel utilisateur connecter.
   */
  UtilisateurDto connectUser(String pseudo, String password);

  /**
   * Permet d'enregistrer un nouvel utilisateur.
   *
   * @param userRegister Utilisateur à enregistrer.
   * @return Le nouvel utilisateur.
   */
  UtilisateurDto registerUser(UtilisateurDto userRegister);
}
