package be.ipl.pae.business.impl;

import be.ipl.pae.business.interfaces.*;

public class FactoryImpl implements Factory {
  @Override
  public Demande getDemandeVide() {
    return new DemandeImpl();
  }

  @Override
  public Partenaire getPartenaireVide() {
    return new PartenaireImpl();
  }

  @Override
  public Utilisateur getUtilisateurVide() {
    return new UtilisateurImpl();
  }

  @Override
  public Mobilite getMobiliteVide() {
    return new MobiliteImpl();
  }

  @Override
  public Etudiant getEtudiantVide() {
    return new EtudiantImpl();
  }

  @Override
  public Departement getDepartementVide() {
    return new Departement();
  }

  @Override
  public Pays getPaysVide() {
    return new Pays();
  }
}
