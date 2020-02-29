package be.ipl.pae.business.demandes;

import be.ipl.pae.business.Pays;
import be.ipl.pae.business.Programme;
import be.ipl.pae.business.TypeErasmus;
import be.ipl.pae.business.partenaires.Partenaire;

import java.time.LocalDateTime;

public interface DemandeDto {

  int getNoCandidature();

  void setNoCandidature(int noCandidature);

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

  Partenaire getPartenaire();

  void setPartenaire(Partenaire partenaire);

  Pays getPays();

  void setPays(Pays pays);

  LocalDateTime getDateIntroductionDemande();

  void setDateIntroductionDemande(LocalDateTime dateIntroductionDemande);
}
