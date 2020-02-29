package be.ipl.pae.business;

import be.ipl.pae.business.impl.DemandeImpl;
import be.ipl.pae.business.impl.PartenaireImpl;
import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.business.impl.Programme;
import be.ipl.pae.business.impl.TypeErasmus;
import be.ipl.pae.business.interfaces.Demande;
import be.ipl.pae.business.interfaces.Partenaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DemandeImplTest {

  private Demande demande;

  @BeforeEach
  void setUp() {
    this.demande = new DemandeImpl();
  }

  @Test
  void validerNoCanditature() {
    assertEquals(demande.getNoCandidature(), 0);
    demande.setNoCandidature(2);
    assertEquals(demande.getNoCandidature(), 2);
  }

  @Test
  void validerNoPreference() {
    assertEquals(demande.getNoPreference(), 0);
    demande.setNoPreference(1);
    assertEquals(demande.getNoPreference(), 1);
  }

  @Test
  void validerTypeErasmus() {
    TypeErasmus type = TypeErasmus.SMS;
    assertNull(demande.getTypeDemande());
    demande.setTypeDemande(type);
    assertEquals(demande.getTypeDemande(), TypeErasmus.SMS);
  }

  @Test
  void testProgramme() {
    Programme programme = Programme.ERABEL;
    demande.setProgramme(programme);
    assertEquals(programme, demande.getProgramme());
  }

  @Test
  void validerQuadrimestre() {
    assertEquals(demande.getQuadrimestre(), 0);
    demande.setQuadrimestre(2);
    assertEquals(demande.getQuadrimestre(), 2);
  }

  @Test
  void validerAnneeAcademique() {
    assertEquals(demande.getAnneeAcademique(), 0);
    demande.setAnneeAcademique(1);
    assertEquals(demande.getAnneeAcademique(), 1);
  }

  @Test
  void validerPartenaire() {
    Partenaire part = new PartenaireImpl();
    assertNull(demande.getPartenaire());
    demande.setPartenaire(part);
    assertEquals(demande.getPartenaire(), part);
  }

  @Test
  void validerPays() {
    Pays pays = new Pays();
    assertNull(demande.getPays());
    demande.setPays(pays);
    assertEquals(demande.getPays(), pays);
  }

  @Test
  void validerDate() {
    LocalDateTime date = LocalDateTime.now();
    assertNotNull(demande.getDateIntroductionDemande());
    demande.setDateIntroductionDemande(date);
    assertEquals(demande.getDateIntroductionDemande(), date);
  }
}
