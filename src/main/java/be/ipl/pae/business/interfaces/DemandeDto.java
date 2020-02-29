package be.ipl.pae.business.interfaces;

import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.business.impl.Programme;
import be.ipl.pae.business.impl.TypeErasmus;

import java.time.LocalDateTime;

public interface DemandeDto {

  int getNoCandidature();

  void setNoCandidature(int noCandidature);

  UtilisateurDto getEtudiant();

  void setEtudiant(UtilisateurDto etudiant);

  int getNoPreference();

  void setNoPreference(int noPreference);

  Programme getProgramme();

  void setProgramme(Programme programme);

  TypeErasmus getTypeDemande();

  void setTypeDemande(TypeErasmus typeDemande);

  int getQuadrimestre();

  void setQuadrimestre(int quadrimestre);

  int getAnneeAcademique();

  void setAnneeAcademique(int anneeAcademique);

  PartenaireDto getPartenaire();

  void setPartenaire(PartenaireDto partenaire);

  Pays getPays();

  void setPays(Pays pays);

  LocalDateTime getDateIntroductionDemande();

  void setDateIntroductionDemande(LocalDateTime dateIntroductionDemande);
}
