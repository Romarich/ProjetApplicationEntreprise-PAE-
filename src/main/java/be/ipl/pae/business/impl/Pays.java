package be.ipl.pae.business.impl;

public class Pays {

  private String codeIso;
  private String nom;
  private Programme programme;

  public Pays() {
    super();
  }

  /**
   * Permet de créer un pays.
   *
   * @param codeIso - Code Iso du pays.
   * @param nom - Nom complet du pays.
   * @param programme - Programme accepter dans ce pays.
   */
  public Pays(String codeIso, String nom, Programme programme) {
    this.codeIso = codeIso;
    this.nom = nom;
    this.programme = programme;
  }

  public String getCodeIso() {
    return codeIso;
  }

  public void setCodeIso(String codeIso) {
    this.codeIso = codeIso;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Programme getProgramme() {
    return programme;
  }

  public void setProgramme(Programme programme) {
    this.programme = programme;
  }
}
