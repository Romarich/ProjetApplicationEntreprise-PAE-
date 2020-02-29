package be.ipl.pae.business.interfaces;

import be.ipl.pae.business.impl.Departement;
import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.business.impl.TypeErasmus;
import be.ipl.pae.business.impl.TypeOrganisation;

public interface PartenaireDto {

  int getId();

  void setId(int id);

  String getNomLegal();

  void setNomLegal(String nomLegal);

  String getNomAffaire();

  void setNomAffaire(String nomAffaire);

  String getNomComplet();

  void setNomComplet(String nomComplet);

  Departement getDepartement();

  void setDepartement(Departement departement);

  TypeOrganisation getTypeOrga();

  void setTypeOrga(TypeOrganisation typeOrga);

  TypeErasmus getTypePartenaire();

  void setTypePartenaire(TypeErasmus typePartenaire);

  int getNbEmployes();

  void setNbEmployes(int nbEmployes);

  String getAdresse();

  void setAdresse(String adresse);

  Pays getPays();

  void setPays(Pays pays);

  String getRegion();

  void setRegion(String region);

  String getCodePostal();

  void setCodePostal(String codePostal);

  String getVille();

  void setVille(String ville);

  String getEmail();

  void setEmail(String email);

  String getSiteWeb();

  void setSiteWeb(String siteWeb);

  String getTelephone();

  void setTelephone(String telephone);

  String getLogo();

  void setLogo(String logo);
}
