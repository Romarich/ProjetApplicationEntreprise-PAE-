package be.ipl.pae.business.mobilites;

public enum EtatMobilite {
  CREER("Créée"),
  PREPARATION("Préparation"),
  A_PAYER("A payer"),
  A_PAYER_SOLDE("A payer Solde"),
  TERMINER("Terminée");

  private String nom;

  EtatMobilite(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}
