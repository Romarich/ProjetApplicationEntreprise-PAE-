package be.ipl.pae.business;

import be.ipl.pae.business.impl.FactoryImpl;
import be.ipl.pae.business.interfaces.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FactoryImplTest {

  private Factory factory;

  @BeforeEach
  void setUp() {
    factory = new FactoryImpl();
  }

  @Test
  void testUtilisateurVide() {
    assertNotNull(factory.getUtilisateurVide());
  }

  @Test
  void testDemandeVide() {
    assertNotNull(factory.getDemandeVide());
  }

  @Test
  void testPartenaireVide() {
    assertNotNull(factory.getPartenaireVide());
  }

  @Test
  void testMobiliteVide() {
    assertNotNull(factory.getMobiliteVide());
  }
}
