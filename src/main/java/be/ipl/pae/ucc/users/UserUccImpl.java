package be.ipl.pae.ucc.users;

import be.ipl.pae.business.users.User;
import be.ipl.pae.business.users.UserDto;
import be.ipl.pae.dal.dalservice.DalService;
import be.ipl.pae.dal.users.UserDao;
import be.ipl.pae.exceptions.BizException;

import java.time.LocalDateTime;

public class UserUccImpl implements UserUcc {

  private UserDao userDao;
  private DalService dalService;

  public UserUccImpl(UserDao userDao, DalService dalService) {
    this.userDao = userDao;
    this.dalService = dalService;
  }

  @Override
  public UserDto connectUser(String pseudo, String password) {
    User user;
    try {
      this.dalService.startTransaction();
      user = (User) userDao.findUserByPseudo(pseudo);
      if (user == null) {
        return null;
      }
      if (!user.checkPassword(password)) {
        throw new BizException("Le mot de passe n'est pas correcte !");
      }
      // On ne garde pas le mdp pour éviter les fuites.
      user.setMotDePasse("");
    } catch (Exception exc) {
      this.dalService.rollBackTransaction();
      throw exc;
    } finally {
      this.dalService.commitTransaction();
    }
    return user;
  }

  @Override
  public UserDto registerUser(UserDto userRegister, String password) {
    if (userRegister == null || password == null) {
      return null;
    }
    User user = (User) userRegister;
    user.setMotDePasse(user.hashPassword(password));
    user.setDateInscritpion(LocalDateTime.now());

    try {
      this.dalService.startTransaction();
      // Si il y a déjà ce pseudo dans la DB.
      if (userDao.findUserByPseudo(userRegister.getPseudo()) != null) {
        throw new BizException("Le pseudo existe déjà");
      }
      // Si il y a déjà cet email dans la DB.
      if (userDao.findUserByEmail(userRegister.getEmail()) != null) {
        throw new BizException("L'email existe déjà");
      }
      userDao.createUser(user);
      UserDto userReturn = userDao.findUserByPseudo(userRegister.getPseudo());
      userReturn.setMotDePasse("");
      return userReturn;
    } catch (Exception exc) {
      this.dalService.rollBackTransaction();
      throw exc;
    } finally {
      this.dalService.commitTransaction();
    }
  }
}
