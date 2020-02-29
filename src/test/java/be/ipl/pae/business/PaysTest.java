package be.ipl.pae.business;

import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.business.impl.Programme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaysTest {

  private Pays pays;

  @BeforeEach
  void setUp() {
    this.pays = new Pays();
  }

  @Test
  void testConstructeur() {
    String codeIso = "code";
    String nom = "nom";
    Programme programme = Programme.FAME;
    this.pays = new Pays(codeIso, nom, programme);
    assertNotNull(this.pays.getCodeIso());
    assertNotNull(this.pays.getNom());
    assertNotNull(this.pays.getProgramme());
  }

  @Test
  void codeIsoTest() {
    assertNull(pays.getCodeIso());
    pays.setCodeIso("codeIso");
    assertEquals(pays.getCodeIso(), "codeIso");
  }

  @Test
  void nomTest() {
    assertNull(pays.getNom());
    pays.setNom("pays");
    assertEquals(pays.getNom(), "pays");
  }

  @Test
  void programmeTest() {
    Programme programme = Programme.SUISSE;
    assertNull(pays.getProgramme());
    pays.setProgramme(programme);
    assertEquals(pays.getProgramme(), programme);
  }
}
