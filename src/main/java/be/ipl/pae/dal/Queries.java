package be.ipl.pae.dal;

public interface Queries {

  /* USERS */

  String INSERT_UTILISATEUR =
      "INSERT INTO projetPAE.utilisateurs (pseudo,mdp,nom,prenom,email,date_inscription,role) "
          + "VALUES (?,?,?,?,?,?,?)";

  String CONNEXION_UTILISATEUR = "SELECT * FROM projetPAE.utilisateurs WHERE pseudo = ?";

  String FIND_USER_BY_EMAIL = "SELECT * FROM projetPAE.utilisateurs WHERE email = ?";

  String LIST_USERS = "SELECT * FROM projetPAE.utilisateurs";

  String LIST_USERS_BY_ROLE = "SELECT * FROM projetPAE.utilisateurs WHERE role = ?";

  /* Etudiant */

  String INSERT_ETUDIANT =
      "INSERT INTO projetPAE.etudiants "
          + "(departement, date_naissance, pays, adresse, sexe, annee_etud_sup, iban_banque,"
          + " titulaire_bancaire, nom_banque, code_BIC) "
          + "VALUES (?,?,?,?,?,?,?,?,?,?)";

  String GET_ETUDIANT = "SELECT * FROM projetPAE.etudiants WHERE id_etudiant = ?";

  String INFO_MOBILITE_ETUDIANT =
      "SELECT p.nom_legal, m.quadri, m.annee_academique FROM partenaires p, mobilites m "
          + "WHERE p.id_partenaire = m.partenaire"
          + " UNION "
          + "SELECT p.nom_legal, dm.quadri, dm.annee_academique FROM partenaires p, mobilites dm "
          + "WHERE p.id_partenaire = dm.partenaire";

  /* Professeur */
  // Pour sa page d'accueil
  String PROFESSEUR_MOBILITE =
      "SELECT * FROM projetPAE.demandes_mobilite dm, projetPAE.mobilites m "
          + "WHERE dm.no_candidature = m.no_candidature";

  String PROFESSEUR_DEMANDE = "SELECT * FROM projetPAE.demandes_mobilite";

  String PROFESSEUR_DEMANDE_MOBILITE = "";

  /* PARTENAIRE */

  String INSERT_PARTENAIRE =
      "INSERT INTO projetPAE.partenaires "
          + "(nom_legal, nom_affaires, nom_complet, departement, type_orga, type_partenaire,"
          + " nb_employes, adresse, pays, region, code_postal, ville,"
          + " email, site_web, telephone, logo) "
          + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  String ALL_PARTENAIRE = "SELECT * FROM projetPAE.partenaires";

  /* DEMANDE MOBILITE */

  String INSERT_DEMANDE_MOBILITE =
      "INSERT INTO projetPAE.demandes_mobilite "
          + "(etudiant, no_preference, programme, type_demande, quadri, annee_academique, "
          + "partenaires, pays, date_introduction_demande) "
          + "VALUES (?,?,?,?,?,?,?,?,?)";

  /* MOBILITE */
  String INSERT_MOBILITE =
      "INSERT INTO projetPAE.mobilites "
          + "(no_candidature, etat, date_creation, annulation, encodage_proEco, encodage_mobi,"
          + " contrat_bourse, convention, "
          + "charte_etudiant, passage_test_linguistiques, doc_engagement, attestation_sejour,"
          + " releve_note, certificat, "
          + "rapport_final, passage_test_linguistiques_retour, nb_demande_paiement_HE_envoye,"
          + " bourse_paye) "
          + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  String UPDATE_ETAT_MOBILITE = "UPDATE projetPAE.mobilites SET etat = ? WHERE no_candidature = ?";

  String UPDATE_BOURSE_MOBILTE =
      "UPDATE projetPAE.mobilites SET bourse_paye = ? WHERE no_candidature = ?";

  String UPDATE_FILE_MOBILITE_CREEE =
      "UPDATE projetPAE.mobilites "
          + "SET contrat_bourse = ?, convention = ?, charte_etudiant = ?,"
          + " passage_test_linguistiques = ?,"
          + " doc_engagement = ? "
          + "WHERE no_candidature = ?";

  String UPDATE_NB_DEMANDE_PAIEMENT =
      "UPDATE projetPAE.mobilites SET nb_demande_paiement_HE_envoye = ? WHERE no_candidature = ?";

  String UPDATE_CONFIRMATION_ENCODAGE_EXTERNE =
      "UPDATE projetPAE.mobilites "
          + "SET encodage_proEco = ?, encodage_mobi = ? WHERE no_candidature = ?";

  String UPDATE_FILE_MOBILITE_A_PAYER =
      "UPDATE projetPAE.mobilites "
          + "SET etat = ?, attestation_sejour = ?, releve_note = ?, certificat = ?, "
          + "rapport_final = ?, passage_test_linguistiques_retour = ? "
          + "WHERE no_candidature = ?";

  String UPDATE_ANNULER_MOBILITE_BY_ETUDIANT =
      "UPDATE projetPAE.mobilites SET ann_raison_etud = ? " + "WHERE no_candidature = ?";

  String UPDATE_ANNULER_MOBILITE_BY_PROFESSEUR =
      "UPDATE projetPAE.mobilites SET annulation = true, ann_raison_prof = ? "
          + "WHERE no_candidature = ?";

  // Raisons Annulations Prof
  String INSERT_RAISON_ANNULATION = "INSERT INTO projetPAE.raisons_annulations (texte_raison) (?)";

  String GET_ALL_RAISONS_ANNULATIONS = "SELECT * FROM projetPAE.raisons_annulations";
  /* Recherche */

  String RECHERCHE_USER_NOM = "SELECT * FROM projetPAE.utilisateurs WHERE nom = ?";

  String RECHERCHE_USER_PRENOM = "SELECT * FROM projetPAE.utilisateurs WHERE prenom = ?";

  String RECHERCHE_USER_NOM_PRENOM =
      "SELECT * FROM projetPAE.utilisateurs WHERE nom = ? AND prenom = ?";

  String RECHERCHE_PARTENAIRE_NOM = "SELECT * FROM projetPAE.partenaires WHERE nom_legal = ?";

  String RECHERCHE_PARTENAIRE_PAYS = "SELECT * FROM projetPAE.partenaires WHERE pays = ?";

  String RECHERCHE_PARTENAIRE_VILLE = "SELECT * FROM projetPAE.partenaires WHERE ville = ?";

  String RECHERCHE_MOBILITE_ANNEE_ACA =
      "SELECT * FROM projetPAE.demandes_mobilite dm, projetPAE.mobilites m "
          + "WHERE dm.no_candidature = m.no_candidature AND  dm.annee_academique = ?";

  String RECHERCHE_MOBILITE_ETAT =
      "SELECT * FROM projetPAE.demandes_mobilite dm, projetPAE.mobilites m "
          + "WHERE dm.no_candidature = m.no_candidature AND  m.etat = ?";

  /* PAYS */

  String ALL_PAYS = "SELECT * FROM projetPAE.pays";

  String GET_PAYS = "SELECT * FROM projetPAE.pays WHERE code_iso = ?";
}
