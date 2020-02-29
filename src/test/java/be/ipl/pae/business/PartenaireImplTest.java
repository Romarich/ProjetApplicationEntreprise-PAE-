package be.ipl.pae.business;

import be.ipl.pae.business.impl.Departement;
import be.ipl.pae.business.impl.PartenaireImpl;
import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.business.impl.TypeOrganisation;
import be.ipl.pae.business.interfaces.Partenaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PartenaireImplTest {

  private Partenaire partenaire;

  private Pays pays;
  private String region;
  private String codePostal;
  private String ville;
  private String email;
  private String siteWeb;
  private String telephone;
  private String logo;

  @BeforeEach
  void setUp() {
    this.partenaire = new PartenaireImpl();
  }

  @Test
  void idTest() {
    int id = 1;
    assertEquals(partenaire.getId(), 0);
    partenaire.setId(id);
    assertEquals(id, partenaire.getId());
  }

  @Test
  void nomLegalTest() {
    assertNull(partenaire.getNomLegal());
    partenaire.setNomLegal("nomLegal");
    assertEquals(partenaire.getNomLegal(), "nomLegal");
  }

  @Test
  void nomAffaireTest() {
    assertNull(partenaire.getNomAffaire());
    partenaire.setNomAffaire("nomAffaire");
    assertEquals(partenaire.getNomAffaire(), "nomAffaire");
  }

  @Test
  void nomCompletTest() {
    assertNull(partenaire.getNomComplet());
    partenaire.setNomComplet("nomComplet");
    assertEquals(partenaire.getNomComplet(), "nomComplet");
  }

  @Test
  void departementTest() {
    Departement depart = new Departement();
    assertNull(partenaire.getDepartement());
    partenaire.setDepartement(depart);
    assertEquals(partenaire.getDepartement(), depart);
  }

  @Test
  void typeOrganisationTest() {
    TypeOrganisation type = TypeOrganisation.PME;
    assertNull(partenaire.getTypeOrga());
    partenaire.setTypeOrga(TypeOrganisation.ETI);
    assertEquals(partenaire.getTypeOrga(), TypeOrganisation.ETI);
  }

  @Test
  void nbEmployeTest() {
    assertEquals(partenaire.getNbEmployes(), 0);
    partenaire.setNbEmployes(45);
    assertEquals(partenaire.getNbEmployes(), 45);
  }

  @Test
  void adresseTest() {
    assertNull(partenaire.getAdresse());
    partenaire.setAdresse("Rue Du champs de pierre 45");
    assertEquals(partenaire.getAdresse(), "Rue Du champs de pierre 45");
  }
}
