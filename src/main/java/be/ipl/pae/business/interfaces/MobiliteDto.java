package be.ipl.pae.business.interfaces;

import be.ipl.pae.business.impl.AnnulationProf;
import be.ipl.pae.business.impl.Bourse;
import be.ipl.pae.business.impl.EtatMobilite;

import java.time.LocalDateTime;

public interface MobiliteDto {

  Demande getDemande();

  void setDemande(Demande demande);

  EtatMobilite getEtat();

  void setEtat(EtatMobilite etat);

  LocalDateTime getDateCreation();

  void setDateCreation(LocalDateTime dateCreation);

  boolean isAnnulation();

  void setAnnulation(boolean annulation);

  String getAnnRaisonEtud();

  void setAnnRaisonEtud(String annRaisonEtud);

  AnnulationProf getAnnRaisonProf();

  void setAnnRaisonProf(AnnulationProf annulationProf);

  boolean isEncodageProEco();

  void setEncodageProEco(boolean encodageProEco);

  boolean isEncodageMobi();

  void setEncodageMobi(boolean encodageMobi);

  boolean isContratBourse();

  void setContratBourse(boolean contratBourse);

  boolean isConvention();

  void setConvention(boolean convention);

  boolean isCharteEtudiant();

  void setCharteEtudiant(boolean charteEtudiant);

  boolean isPassageTestLinguistiques();

  void setPassageTestLinguistiques(boolean passageTestLinguistiques);

  boolean isDocEngagement();

  void setDocEngagement(boolean docEngagement);

  boolean isAttestationSejour();

  void setAttestationSejour(boolean attestationSejour);

  boolean isReleveNote();

  void setReleveNote(boolean releveNote);

  boolean isCertificat();

  void setCertificat(boolean certificat);

  boolean isRapportFinal();

  void setRapportFinal(boolean rapportFinal);

  boolean isPassageTestLinguistiquesRetour();

  void setPassageTestLinguistiquesRetour(boolean passageTestLinguistiquesRetour);

  int getNbDemandePaiementHeEnvoye();

  void setNbDemandePaiementHeEnvoye(int nbDemandePaiementHeEnvoye);

  Bourse getBoursePaye();

  void setBoursePaye(Bourse boursePaye);
}
