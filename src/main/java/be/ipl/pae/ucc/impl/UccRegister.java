package be.ipl.pae.ucc.impl;

import be.ipl.pae.business.impl.FactoryImpl;
import be.ipl.pae.business.interfaces.Factory;
import be.ipl.pae.config.PropertiesManager;
import be.ipl.pae.persistance.impl.DalServiceImpl;
import be.ipl.pae.persistance.impl.UtilisateurDaoImpl;
import be.ipl.pae.persistance.interfaces.UtilisateurDao;
import be.ipl.pae.ucc.interfaces.UtilisateurUcc;

public class UccRegister {

  private UtilisateurUcc utilisateurUcc;

  public UccRegister(PropertiesManager pm) {
    register(pm);
  }

  /** Enregistre tout les Ucc du plugin. */
  private void register(PropertiesManager pm) {
    Factory factory = new FactoryImpl();
    DalServiceImpl dalService = new DalServiceImpl(pm);
    UtilisateurDao utilisateurDao = new UtilisateurDaoImpl(factory, dalService);
    this.utilisateurUcc = new UtilisateurUccImpl(utilisateurDao, dalService);
  }

  public UtilisateurUcc getUtilisateurUcc() {
    return utilisateurUcc;
  }
}
