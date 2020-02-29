package be.ipl.pae.business.demandes;

import be.ipl.pae.business.Pays;
import be.ipl.pae.business.Programme;
import be.ipl.pae.business.TypeErasmus;
import be.ipl.pae.business.partenaires.Partenaire;

import java.time.LocalDateTime;

public class DemandeImpl implements Demande {

  private int noCandidature;
  private int noPreference;
  private Programme programme;
  private TypeErasmus typeDemande;
  private int quadrimestre;
  private int anneeAcademique;
  private Partenaire partenaire;
  private Pays pays;
  private LocalDateTime dateIntroductionDemande;

  public DemandeImpl() {
    this.dateIntroductionDemande = LocalDateTime.now();
  }

  public int getNoCandidature() {
    return noCandidature;
  }

  public void setNoCandidature(int noCandidature) {
    this.noCandidature = noCandidature;
  }

  public int getNoPreference() {
    return noPreference;
  }

  public void setNoPreference(int noPreference) {
    this.noPreference = noPreference;
  }

  public Programme getProgramme() {
    return programme;
  }

  public void setProgramme(Programme programme) {
    this.programme = programme;
  }

  public TypeErasmus getTypeDemande() {
    return typeDemande;
  }

  public void setTypeDemande(TypeErasmus typeDemande) {
    this.typeDemande = typeDemande;
  }

  public int getQuadrimestre() {
    return quadrimestre;
  }

  public void setQuadrimestre(int quadrimestre) {
    this.quadrimestre = quadrimestre;
  }

  public int getAnneeAcademique() {
    return anneeAcademique;
  }

  public void setAnneeAcademique(int anneeAcademique) {
    this.anneeAcademique = anneeAcademique;
  }

  public Partenaire getPartenaire() {
    return partenaire;
  }

  public void setPartenaire(Partenaire partenaire) {
    this.partenaire = partenaire;
  }

  public Pays getPays() {
    return pays;
  }

  public void setPays(Pays pays) {
    this.pays = pays;
  }

  public LocalDateTime getDateIntroductionDemande() {
    return dateIntroductionDemande;
  }

  public void setDateIntroductionDemande(LocalDateTime dateIntroductionDemande) {
    this.dateIntroductionDemande = dateIntroductionDemande;
  }
}
