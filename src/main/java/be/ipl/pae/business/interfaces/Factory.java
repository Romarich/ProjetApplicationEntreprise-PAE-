package be.ipl.pae.business.interfaces;

import be.ipl.pae.business.impl.Departement;
import be.ipl.pae.business.impl.Pays;

public interface Factory {

  /**
   * Retourne un utilisateur vide. Un utilisateur vide est un utilisateur où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Un utilisateur vide.
   */
  Utilisateur getUtilisateurVide();

  /**
   * Retourne une demande vide. Une demande vide est une demande où les attributs ont leurs valeurs
   * par défaut.
   *
   * @return Une demande vide.
   */
  Demande getDemandeVide();

  /**
   * Retourne un partenaires vide. Un partenaires vide est un partenaires où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Un partenaires vide.
   */
  Partenaire getPartenaireVide();

  /**
   * Retourne une mobilite vide. Une mobilite vide est une mobilite où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Une mobilite vide.
   */
  Mobilite getMobiliteVide();

  /**
   * Retourne un étudiant vide. Un étudiant vide est un étudiant où les attributs ont leurs valeurs
   * par défaut.
   *
   * @return Un étudiant vide.
   */
  Etudiant getEtudiantVide();

  /**
   * Retourne un département vide. Un département vide est un département où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Un département vide.
   */
  Departement getDepartementVide();

  /**
   * Retourne un pays vide. Un pays vide est un pays où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Un pays vide.
   */
  Pays getPaysVide();
}
