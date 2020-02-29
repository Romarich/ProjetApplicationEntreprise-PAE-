package be.ipl.pae.ucc.users;

import be.ipl.pae.business.factory.Factory;
import be.ipl.pae.business.factory.FactoryImpl;
import be.ipl.pae.dal.dalservice.DalServiceImpl;
import be.ipl.pae.dal.users.UserDao;
import be.ipl.pae.dal.users.UserDaoImpl;
import be.ipl.pae.main.PropertiesManager;

public class UccRegister {

  private UserUcc userUcc;

  public UccRegister(PropertiesManager pm) {
    register(pm);
  }

  /** Enregistre tout les Ucc du plugin. */
  private void register(PropertiesManager pm) {
    Factory factory = new FactoryImpl();
    DalServiceImpl dalService = new DalServiceImpl(pm);
    UserDao userDao = new UserDaoImpl(factory, dalService);
    userUcc = new UserUccImpl(userDao, dalService);
  }

  public UserUcc getUserUcc() {
    return userUcc;
  }
}
