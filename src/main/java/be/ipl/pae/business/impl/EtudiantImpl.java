package be.ipl.pae.business.impl;

import be.ipl.pae.business.interfaces.Etudiant;

import java.time.LocalDateTime;

public class EtudiantImpl implements Etudiant {

  private Departement departement;
  private LocalDateTime dateNaissance;
  private Pays pays;
  private String adresse;
  private String sexe;
  private int anneeEtudSup;
  private String ibanBanque;
  private String titulaireBancaire;
  private String nomBanque;
  private String codeBic;

  public EtudiantImpl() {}

  public Departement getDepartement() {
    return departement;
  }

  public void setDepartement(Departement departement) {
    this.departement = departement;
  }

  public LocalDateTime getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(LocalDateTime dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public Pays getPays() {
    return pays;
  }

  public void setPays(Pays pays) {
    this.pays = pays;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
    this.sexe = sexe;
  }

  public int getAnneeEtudSup() {
    return anneeEtudSup;
  }

  public void setAnneeEtudSup(int anneeEtudSup) {
    this.anneeEtudSup = anneeEtudSup;
  }

  public String getIbanBanque() {
    return ibanBanque;
  }

  public void setIbanBanque(String ibanBanque) {
    this.ibanBanque = ibanBanque;
  }

  public String getTitulaireBancaire() {
    return titulaireBancaire;
  }

  public void setTitulaireBancaire(String titulaireBancaire) {
    this.titulaireBancaire = titulaireBancaire;
  }

  public String getNomBanque() {
    return nomBanque;
  }

  public void setNomBanque(String nomBanque) {
    this.nomBanque = nomBanque;
  }

  public String getCodeBic() {
    return codeBic;
  }

  public void setCodeBic(String codeBic) {
    this.codeBic = codeBic;
  }
}
