package be.ipl.pae.dal.dalservice;

public interface DalService {

  /** Permet de démarrer une transaction avec la DB. */
  void startTransaction();

  /** Commit la transaction en cours. */
  void commitTransaction();

  /** Annul la transaction en cours. */
  void rollBackTransaction();
}
