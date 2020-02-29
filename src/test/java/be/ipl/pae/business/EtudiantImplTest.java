package be.ipl.pae.business;

import be.ipl.pae.business.impl.Departement;
import be.ipl.pae.business.impl.EtudiantImpl;
import be.ipl.pae.business.interfaces.Etudiant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EtudiantImplTest {

  private Etudiant etudiant;

  @BeforeEach
  void setUp() {
    this.etudiant = new EtudiantImpl();
  }

  @Test
  void testDepartement() {
    Departement departement = new Departement();
    etudiant.setDepartement(departement);
    assertEquals(departement, etudiant.getDepartement());
  }
}
