package be.ipl.pae.business;

import be.ipl.pae.business.impl.EtatMobilite;
import be.ipl.pae.business.impl.MobiliteImpl;
import be.ipl.pae.business.interfaces.Mobilite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MobiliteImplTest {

  private Mobilite mobilite;

  @BeforeEach
  void setUp() {
    mobilite = new MobiliteImpl();
  }

  @Test
  void testEtat() {
    EtatMobilite etat = EtatMobilite.CREER;
    mobilite.setEtat(etat);
    assertEquals(etat, mobilite.getEtat());
  }
}
