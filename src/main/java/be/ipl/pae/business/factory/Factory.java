package be.ipl.pae.business.factory;

import be.ipl.pae.business.demandes.Demande;
import be.ipl.pae.business.mobilites.Mobilite;
import be.ipl.pae.business.partenaires.Partenaire;
import be.ipl.pae.business.users.User;

public interface Factory {

  /**
   * Retourne une demande vide. Une demande vide est une demande où les attributs ont leurs valeurs
   * par défaut.
   *
   * @return Une demande vide.
   */
  Demande getEmptyDemande();

  /**
   * Retourne un partenaires vide. Un partenaires vide est un partenaires où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Un partenaires vide.
   */
  Partenaire getEmptyPartenaire();

  /**
   * Retourne un utilisateur vide. Un utilisateur vide est un utilisateur où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Un utilisateur vide.
   */
  User getEmptyUser();

  /**
   * Retourne une mobilite vide. Une mobilite vide est une mobilite où les attributs ont leurs
   * valeurs par défaut.
   *
   * @return Une mobilite vide.
   */
  Mobilite getEmptyMobilite();
}
