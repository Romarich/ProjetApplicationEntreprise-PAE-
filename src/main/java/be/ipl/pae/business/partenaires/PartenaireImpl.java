package be.ipl.pae.business.partenaires;

import be.ipl.pae.business.Pays;
import be.ipl.pae.business.TypeErasmus;

public class PartenaireImpl implements Partenaire {
  private int id;
  private String nomLegal;
  private String nomAffaire;
  private String nomComplet;
  private Departement departement;
  private TypeOrganisation typeOrga;
  private TypeErasmus typePartenaire;
  private int nbEmployes;
  private String adresse;
  private Pays pays;
  private String region;
  private String codePostal;
  private String ville;
  private String email;
  private String siteWeb;
  private String telephone;
  private String logo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNomLegal() {
    return nomLegal;
  }

  public void setNomLegal(String nomLegal) {
    this.nomLegal = nomLegal;
  }

  public String getNomAffaire() {
    return nomAffaire;
  }

  public void setNomAffaire(String nomAffaire) {
    this.nomAffaire = nomAffaire;
  }

  public String getNomComplet() {
    return nomComplet;
  }

  public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
  }

  public Departement getDepartement() {
    return departement;
  }

  public void setDepartement(Departement departement) {
    this.departement = departement;
  }

  public TypeOrganisation getTypeOrga() {
    return typeOrga;
  }

  public void setTypeOrga(TypeOrganisation typeOrga) {
    this.typeOrga = typeOrga;
  }

  public TypeErasmus getTypePartenaire() {
    return typePartenaire;
  }

  public void setTypePartenaire(TypeErasmus typePartenaire) {
    this.typePartenaire = typePartenaire;
  }

  public int getNbEmployes() {
    return nbEmployes;
  }

  public void setNbEmployes(int nbEmployes) {
    this.nbEmployes = nbEmployes;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public Pays getPays() {
    return pays;
  }

  public void setPays(Pays pays) {
    this.pays = pays;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSiteWeb() {
    return siteWeb;
  }

  public void setSiteWeb(String siteWeb) {
    this.siteWeb = siteWeb;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }
}
