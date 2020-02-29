package be.ipl.pae.business.impl;

import be.ipl.pae.business.interfaces.Demande;
import be.ipl.pae.business.interfaces.PartenaireDto;
import be.ipl.pae.business.interfaces.UtilisateurDto;

import java.time.LocalDateTime;

public class DemandeImpl implements Demande {

  private int noCandidature;
  private UtilisateurDto etudiant;
  private int noPreference;
  private Programme programme;
  private TypeErasmus typeDemande;
  private int quadrimestre;
  private int anneeAcademique;
  private PartenaireDto partenaire;
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

  public UtilisateurDto getEtudiant() {
    return etudiant;
  }

  public void setEtudiant(UtilisateurDto etudiant) {
    this.etudiant = etudiant;
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

  public PartenaireDto getPartenaire() {
    return partenaire;
  }

  public void setPartenaire(PartenaireDto partenaire) {
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
