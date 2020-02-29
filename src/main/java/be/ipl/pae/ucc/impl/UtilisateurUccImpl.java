package be.ipl.pae.ucc.impl;

import be.ipl.pae.business.impl.Role;
import be.ipl.pae.business.interfaces.Utilisateur;
import be.ipl.pae.business.interfaces.UtilisateurDto;
import be.ipl.pae.exceptions.BizzException;
import be.ipl.pae.persistance.interfaces.DalService;
import be.ipl.pae.persistance.interfaces.UtilisateurDao;
import be.ipl.pae.ucc.interfaces.UtilisateurUcc;

import java.time.LocalDateTime;

public class UtilisateurUccImpl implements UtilisateurUcc {

  private UtilisateurDao utilisateurDao;
  private DalService dalService;

  public UtilisateurUccImpl(UtilisateurDao utilisateurDao, DalService dalService) {
    this.utilisateurDao = utilisateurDao;
    this.dalService = dalService;
  }

  @Override
  public UtilisateurDto connectUser(String pseudo, String mdp) {
    Utilisateur utilisateur;
    try {
      this.dalService.demarrerTransaction();
      utilisateur = (Utilisateur) utilisateurDao.trouverUtilisateurParPseudo(pseudo);
      if (utilisateur == null) {
        throw new BizzException("L'utilisateur n'existe pas.");
      }
      if (!utilisateur.checkMdp(mdp)) {
        throw new BizzException("Le mot de passe n'est pas correcte !");
      }
      // On ne garde pas le mdp pour éviter les fuites.
      utilisateur.setMotDePasse("");
    } catch (Exception exc) {
      this.dalService.annulerTransaction();
      throw exc;
    } finally {
      this.dalService.soumettreTransaction();
    }
    return utilisateur;
  }

  @Override
  public UtilisateurDto registerUser(UtilisateurDto utilisateurRegister) {
    if (utilisateurRegister == null) {
      return null;
    }
    Utilisateur utilisateur = (Utilisateur) utilisateurRegister;
    utilisateur.setMotDePasse(utilisateur.hashMdp(utilisateurRegister.getMotDePasse()));
    utilisateur.setDateInscription(LocalDateTime.now());

    try {
      this.dalService.demarrerTransaction();
      // Si il y a déjà ce pseudo dans la DB.
      if (utilisateurDao.trouverUtilisateurParPseudo(utilisateurRegister.getPseudo()) != null) {
        throw new BizzException("Le pseudo existe déjà");
      }
      // Si il y a déjà cet email dans la DB.
      if (utilisateurDao.trouverUtilisateurParEmail(utilisateurRegister.getEmail()) != null) {
        throw new BizzException("L'email existe déjà");
      }
      if (utilisateurDao.getTousUtilisateurs().isEmpty()) {
        utilisateur.setRole(Role.PROFESSEUR_RESPONSABLE);
      } else {
        utilisateur.setRole(Role.ETUDIANT);
      }
      utilisateurRegister = utilisateurDao.creerUtilisateur(utilisateur);
      utilisateurRegister.setMotDePasse("");
    } catch (Exception exc) {
      this.dalService.annulerTransaction();
      throw exc;
    } finally {
      this.dalService.soumettreTransaction();
    }
    return utilisateurRegister;
  }
}
