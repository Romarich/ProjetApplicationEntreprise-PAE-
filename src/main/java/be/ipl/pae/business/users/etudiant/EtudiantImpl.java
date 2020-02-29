package be.ipl.pae.business.users.etudiant;

import be.ipl.pae.business.Pays;
import be.ipl.pae.business.partenaires.Departement;

import java.time.LocalDate;

public class EtudiantImpl implements Etudiant {

  private Departement departement;
  private LocalDate dateNaissance;
  private Pays pays;
  private String adresse;
  private char sexe;
  private int anneeEtudSup;
  private String ibanBanque;
  private String titulaireBancaire;
  private String nomBanque;
  private String codeBic;

  public Departement getDepartement() {
    return departement;
  }

  public void setDepartement(Departement departement) {
    this.departement = departement;
  }

  public LocalDate getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(LocalDate dateNaissance) {
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

  public char getSexe() {
    return sexe;
  }

  public void setSexe(char sexe) {
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
