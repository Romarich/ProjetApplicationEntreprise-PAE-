DROP SCHEMA IF EXISTS projetPAE CASCADE;
CREATE SCHEMA projetPAE;
CREATE TABLE projetPAE.raisons_annulations (
  id_raison SERIAL PRIMARY KEY,
  texte_raison VARCHAR(50) NOT NULL
);

CREATE TABLE projetPAE.departements (
  tag CHAR(3) PRIMARY KEY,
  nom VARCHAR(50) NOT NULL
);

CREATE TABLE projetPAE.pays (
  codeIso CHAR(3) PRIMARY KEY,
  nom VARCHAR(20) NOT NULL,
  programme VARCHAR(10)
);

CREATE TABLE projetPAE.partenaires (
  id_partenaire SERIAL PRIMARY KEY,
  nom_legal VARCHAR(50) NOT NULL,
  nom_affaires VARCHAR(50) NOT NULL,
  nom_complet VARCHAR(100) NOT NULL,
  departement CHAR(3) NOT NULL,
  type_orga CHAR(3),
  type_partenaire CHAR(3),
  nb_employes INTEGER NOT NULL,
  adresse VARCHAR(100) NOT NULL,
  pays CHAR(3) REFERENCES projetPAE.pays (codeIso) NOT NULL,
  region VARCHAR(50) NOT NULL,
  code_postal INTEGER NOT NULL,
  ville VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  site_web VARCHAR(100) NOT NULL,
  telephone VARCHAR(20) NOT NULL,
  logo VARCHAR(100) NOT NULL
);

CREATE TABLE projetPAE.etudiants (
  id_etudiant SERIAL PRIMARY KEY,
  departement CHAR(3) REFERENCES projetPAE.departements(tag) NOT NULL,
  date_naissance TIMESTAMP NOT NULL,
  pays CHAR(3) REFERENCES projetPAE.pays (codeIso) NULL,
  adresse VARCHAR(100) NOT NULL,
  sexe CHAR(1),
  annee_etud_sup INTEGER NOT NULL,
  iban_banque VARCHAR(20) NOT NULL,
  titulaire_bancaire VARCHAR(30) NOT NULL,
  nom_banque VARCHAR(20) NOT NULL,
  code_BIC VARCHAR(20) NOT NULL
);

CREATE TABLE projetPAE.demandes_mobilite (
  no_candidature SERIAL PRIMARY KEY,
  etudiant INTEGER REFERENCES projetPAE.etudiants(id_etudiant),
  no_preference INTEGER NOT NULL,
  programme VARCHAR(10),
  type_demande CHAR(3),
  quadri INTEGER NOT NULL,
  annee_academique INTEGER NOT NULL,
  partenaire INTEGER REFERENCES projetPAE.partenaires(id_partenaire) NULL,
  pays CHAR(3) REFERENCES projetPAE.pays (codeIso) NULL,
  date_introduction_demande TIMESTAMP NOT NULL
);

CREATE TABLE projetPAE.utilisateurs (
  id_utilisateur SERIAL PRIMARY KEY,
  pseudo VARCHAR(30) NOT NULL,
  mdp VARCHAR(60) NOT NULL,
  nom VARCHAR(30) NOT NULL,
  prenom VARCHAR(30) NOT NULL,
  email VARCHAR(50) NOT NULL,
  date_inscription TIMESTAMP NOT NULL,
  role VARCHAR(20) NOT NULL,
  etudiant INTEGER REFERENCES projetPAE.etudiants(id_etudiant) NULL,
  photo_profil VARCHAR(30) NULL
);

CREATE TABLE projetPAE.mobilites (
  no_candidature SERIAL PRIMARY KEY,
  etat VARCHAR(20),
  date_creation TIMESTAMP NOT NULL,
  annulation BOOLEAN NOT NULL,
  ann_raison_etud VARCHAR(200) NULL,
  ann_raison_prof INTEGER REFERENCES projetPAE.raisons_annulations(id_raison) NULL,
  encodage_proEco BOOLEAN NOT NULL,
  encodage_mobi BOOLEAN NOT NULL,
  contrat_bourse BOOLEAN NOT NULL,
  convention BOOLEAN NOT NULL,
  charte_etudiant BOOLEAN NOT NULL,
  passage_test_linguistiques BOOLEAN NULL,
  doc_engagement BOOLEAN NOT NULL,
  attestation_sejour BOOLEAN NOT NULL,
  releve_note BOOLEAN NULL,
  certificat BOOLEAN NULL,
  rapport_final BOOLEAN NOT NULL,
  passage_test_linguistiques_retour BOOLEAN NULL,
  nb_demande_paiement_HE_envoye INTEGER NOT NULL,
  bourse_paye VARCHAR(10)
);