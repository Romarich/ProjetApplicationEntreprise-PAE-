package be.ipl.pae.business.interfaces;

import be.ipl.pae.business.impl.Departement;
import be.ipl.pae.business.impl.Pays;

import java.time.LocalDateTime;

public interface Etudiant {

  Departement getDepartement();

  void setDepartement(Departement departement);

  LocalDateTime getDateNaissance();

  void setDateNaissance(LocalDateTime dateNaissance);

  Pays getPays();

  void setPays(Pays pays);

  String getAdresse();

  void setAdresse(String adresse);

  String getSexe();

  void setSexe(String sexe);

  int getAnneeEtudSup();

  void setAnneeEtudSup(int anneeEtudSup);

  String getIbanBanque();

  void setIbanBanque(String ibanBanque);

  String getTitulaireBancaire();

  void setTitulaireBancaire(String titulaireBancaire);

  String getNomBanque();

  void setNomBanque(String nomBanque);

  String getCodeBic();

  void setCodeBic(String codeBic);
}
