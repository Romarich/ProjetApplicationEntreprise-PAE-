package be.ipl.pae.business.impl;

public enum EtatMobilite {
  CREER("Créée"),
  PREPARATION("Préparation"),
  A_PAYER("A payer"),
  A_PAYER_SOLDE("A payer Solde"),
  EN_ORDRE("En ordre"),
  TERMINER("Terminée");

  private String nom;

  EtatMobilite(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}
