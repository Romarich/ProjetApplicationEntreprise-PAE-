package be.ipl.pae.business.users;

import java.time.LocalDateTime;

public interface UserDto {
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

  LocalDateTime getDateInscritpion();

  void setDateInscritpion(LocalDateTime dateInscritpion);

  Role getRole();

  void setRole(Role role);

  String getPhoto();

  void setPhoto(String photo);
}
