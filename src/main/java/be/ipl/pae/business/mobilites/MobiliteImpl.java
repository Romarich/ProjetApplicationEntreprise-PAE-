package be.ipl.pae.business.mobilites;

import be.ipl.pae.business.demandes.Demande;

import java.time.LocalDateTime;

public class MobiliteImpl implements Mobilite {

  private Demande demande;
  private EtatMobilite etat;
  private LocalDateTime dateCreation;
  private boolean annulation;
  private String annRaisonEtud;
  private AnnulationProf annRaisonProf;
  private boolean encodageProEco;
  private boolean encodageMobi;
  private boolean contratBourse;
  private boolean convention;
  private boolean charteEtudiant;
  private boolean passageTestLinguistiques;
  private boolean docEngagement;
  private boolean attestationSejour;
  private boolean releveNote;
  private boolean certificat;
  private boolean rapportFinal;
  private boolean passageTestLinguistiquesRetour;
  private int nbDemandePaiementHeEnvoye;
  private Bourse boursePaye;

  /** Permet de créer une mobilité avec les paramètres par défaut. */
  public MobiliteImpl() {
    this.etat = EtatMobilite.CREER;
    this.dateCreation = LocalDateTime.now();
    this.annulation = false;
    this.encodageProEco = false;
    this.encodageMobi = false;
    this.contratBourse = false;
    this.convention = false;
    this.charteEtudiant = false;
    this.passageTestLinguistiques = false;
    this.docEngagement = false;
    this.attestationSejour = false;
    this.releveNote = false;
    this.certificat = false;
    this.rapportFinal = false;
    this.passageTestLinguistiquesRetour = false;
    // nbDemandePaiementHeEnvoye ??
    this.boursePaye = Bourse.ZERO;
  }

  public Demande getDemande() {
    return demande;
  }

  public void setDemande(Demande demande) {
    this.demande = demande;
  }

  public EtatMobilite getEtat() {
    return etat;
  }

  public void setEtat(EtatMobilite etat) {
    this.etat = etat;
  }

  public LocalDateTime getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(LocalDateTime dateCreation) {
    this.dateCreation = dateCreation;
  }

  public boolean isAnnulation() {
    return annulation;
  }

  public void setAnnulation(boolean annulation) {
    this.annulation = annulation;
  }

  public String getAnnRaisonEtud() {
    return annRaisonEtud;
  }

  public void setAnnRaisonEtud(String annRaisonEtud) {
    this.annRaisonEtud = annRaisonEtud;
  }

  public AnnulationProf getAnnRaisonProf() {
    return annRaisonProf;
  }

  public void setAnnRaisonProf(AnnulationProf annulationProf) {
    this.annRaisonProf = annulationProf;
  }

  public boolean isEncodageProEco() {
    return encodageProEco;
  }

  public void setEncodageProEco(boolean encodageProEco) {
    this.encodageProEco = encodageProEco;
  }

  public boolean isEncodageMobi() {
    return encodageMobi;
  }

  public void setEncodageMobi(boolean encodageMobi) {
    this.encodageMobi = encodageMobi;
  }

  public boolean isContratBourse() {
    return contratBourse;
  }

  public void setContratBourse(boolean contratBourse) {
    this.contratBourse = contratBourse;
  }

  public boolean isConvention() {
    return convention;
  }

  public void setConvention(boolean convention) {
    this.convention = convention;
  }

  public boolean isCharteEtudiant() {
    return charteEtudiant;
  }

  public void setCharteEtudiant(boolean charteEtudiant) {
    this.charteEtudiant = charteEtudiant;
  }

  public boolean isPassageTestLinguistiques() {
    return passageTestLinguistiques;
  }

  public void setPassageTestLinguistiques(boolean passageTestLinguistiques) {
    this.passageTestLinguistiques = passageTestLinguistiques;
  }

  public boolean isDocEngagement() {
    return docEngagement;
  }

  public void setDocEngagement(boolean docEngagement) {
    this.docEngagement = docEngagement;
  }

  public boolean isAttestationSejour() {
    return attestationSejour;
  }

  public void setAttestationSejour(boolean attestationSejour) {
    this.attestationSejour = attestationSejour;
  }

  public boolean isReleveNote() {
    return releveNote;
  }

  public void setReleveNote(boolean releveNote) {
    this.releveNote = releveNote;
  }

  public boolean isCertificat() {
    return certificat;
  }

  public void setCertificat(boolean certificat) {
    this.certificat = certificat;
  }

  public boolean isRapportFinal() {
    return rapportFinal;
  }

  public void setRapportFinal(boolean rapportFinal) {
    this.rapportFinal = rapportFinal;
  }

  public boolean isPassageTestLinguistiquesRetour() {
    return passageTestLinguistiquesRetour;
  }

  public void setPassageTestLinguistiquesRetour(boolean passageTestLinguistiquesRetour) {
    this.passageTestLinguistiquesRetour = passageTestLinguistiquesRetour;
  }

  public int getNbDemandePaiementHeEnvoye() {
    return nbDemandePaiementHeEnvoye;
  }

  public void setNbDemandePaiementHeEnvoye(int nbDemandePaiementHeEnvoye) {
    this.nbDemandePaiementHeEnvoye = nbDemandePaiementHeEnvoye;
  }

  public Bourse getBoursePaye() {
    return boursePaye;
  }

  public void setBoursePaye(Bourse boursePaye) {
    this.boursePaye = boursePaye;
  }
}
