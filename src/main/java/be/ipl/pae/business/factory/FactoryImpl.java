package be.ipl.pae.business.factory;

import be.ipl.pae.business.demandes.Demande;
import be.ipl.pae.business.demandes.DemandeImpl;
import be.ipl.pae.business.mobilites.Mobilite;
import be.ipl.pae.business.mobilites.MobiliteImpl;
import be.ipl.pae.business.partenaires.Partenaire;
import be.ipl.pae.business.partenaires.PartenaireImpl;
import be.ipl.pae.business.users.User;
import be.ipl.pae.business.users.UserImpl;

public class FactoryImpl implements Factory {
  @Override
  public Demande getEmptyDemande() {
    return new DemandeImpl();
  }

  @Override
  public Partenaire getEmptyPartenaire() {
    return new PartenaireImpl();
  }

  @Override
  public User getEmptyUser() {
    return new UserImpl();
  }

  @Override
  public Mobilite getEmptyMobilite() {
    return new MobiliteImpl();
  }
}
