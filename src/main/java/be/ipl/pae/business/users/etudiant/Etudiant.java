package be.ipl.pae.business.users.etudiant;

import be.ipl.pae.business.Pays;
import be.ipl.pae.business.partenaires.Departement;

import java.time.LocalDate;

public interface Etudiant {

  Departement getDepartement();

  void setDepartement(Departement departement);

  LocalDate getDateNaissance();

  void setDateNaissance(LocalDate dateNaissance);

  Pays getPays();

  void setPays(Pays pays);

  String getAdresse();

  void setAdresse(String adresse);

  char getSexe();

  void setSexe(char sexe);

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
