package be.ipl.pae.business.users;

import be.ipl.pae.business.users.etudiant.Etudiant;
import org.mindrot.bcrypt.BCrypt;

import java.time.LocalDateTime;

public class UserImpl implements User {

  private String pseudo;
  private String motDePasse;
  private String nom;
  private String prenom;
  private String email;
  private LocalDateTime dateInscritpion;
  private Role role;
  private String photo;
  private Etudiant etudiant;

  public UserImpl() {
    super();
  }

  public boolean isEmpty() {
    return this.equals(new UserImpl());
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

  public LocalDateTime getDateInscritpion() {
    return dateInscritpion;
  }

  public void setDateInscritpion(LocalDateTime dateInscritpion) {
    this.dateInscritpion = dateInscritpion;
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
  public boolean checkPassword(String password) {
    return BCrypt.checkpw(password, this.getMotDePasse());
  }

  @Override
  public String hashPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }
}
