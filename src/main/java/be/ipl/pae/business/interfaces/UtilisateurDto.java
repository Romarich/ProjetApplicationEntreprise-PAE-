package be.ipl.pae.business.interfaces;

import be.ipl.pae.business.impl.Role;

import java.time.LocalDateTime;

public interface UtilisateurDto {

  int getId();

  void setId(int id);

  String getPseudo();

  void setPseudo(String pseudo);

  String getMotDePasse();

  void setMotDePasse(String motDePasse);

  String getNom();

  void setNom(String nom);

  String getPrenom();

  void setPrenom(String prenom);

  String getEmail();

  void setEmail(String email);

  LocalDateTime getDateInscription();

  void setDateInscription(LocalDateTime dateInscription);

  Role getRole();

  void setRole(Role role);

  String getPhoto();

  void setPhoto(String photo);

  Etudiant getEtudiant();

  void setEtudiant(Etudiant etudiant);
}
