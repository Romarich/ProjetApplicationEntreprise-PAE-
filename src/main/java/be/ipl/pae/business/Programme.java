package be.ipl.pae.business;

public enum Programme {
  ERASMUS("Erasmus+"),
  ERABEL("Erabel"),
  FAME("FAME"),
  SUISSE("Suisse");

  private String nom;

  Programme(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
}
