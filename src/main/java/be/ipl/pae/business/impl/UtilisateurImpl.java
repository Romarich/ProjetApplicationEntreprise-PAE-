package be.ipl.pae.business.impl;

import be.ipl.pae.business.interfaces.Etudiant;
import be.ipl.pae.business.interfaces.Utilisateur;
import org.mindrot.bcrypt.BCrypt;

import java.time.LocalDateTime;

public class UtilisateurImpl implements Utilisateur {

  private int id;
  private String pseudo;
  private String motDePasse;
  private String nom;
  private String prenom;
  private String email;
  private LocalDateTime dateInscription;
  private Role role;
  private String photo;
  private Etudiant etudiant;

  public UtilisateurImpl() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getDateInscription() {
    return dateInscription;
  }

  public void setDateInscription(LocalDateTime dateInscription) {
    this.dateInscription = dateInscription;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Etudiant getEtudiant() {
    return etudiant;
  }

  public void setEtudiant(Etudiant etudiant) {
    this.etudiant = etudiant;
  }

  @Override
  public boolean checkMdp(String mdp) {
    return BCrypt.checkpw(mdp, this.getMotDePasse());
  }

  @Override
  public String hashMdp(String mdp) {
    return BCrypt.hashpw(mdp, BCrypt.gensalt());
  }
}
