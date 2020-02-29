package be.ipl.pae.persistance.interfaces;

public interface DalService {

  /** Permet de démarrer une transaction avec la DB. */
  void demarrerTransaction();

  /** Commit la transaction en cours. */
  void soumettreTransaction();

  /** Annul la transaction en cours. */
  void annulerTransaction();
}
