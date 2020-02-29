package be.ipl.pae.business.partenaires;

import be.ipl.pae.business.Pays;
import be.ipl.pae.business.TypeErasmus;

public interface PartenaireDto {

  int getId();

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
