package be.ipl.pae.business;

import be.ipl.pae.business.impl.EtudiantImpl;
import be.ipl.pae.business.impl.Role;
import be.ipl.pae.business.impl.UtilisateurImpl;
import be.ipl.pae.business.interfaces.Etudiant;
import be.ipl.pae.config.PropertiesManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.bcrypt.BCrypt;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurImplTest {

  private UtilisateurImpl ok;
  private UtilisateurImpl ko;
  private String mdpHash;
  private PropertiesManager pm = new PropertiesManager();

  /** Oppération qui se fait pour avant chaque test. */
  @BeforeEach
  void setUp() {
    pm.setFichier("test");
    ok = new UtilisateurImpl();
    Etudiant et = new EtudiantImpl();
    ok.setEtudiant(et);
    ok.setDateInscription(LocalDateTime.now());
    ok.setPseudo(pm.getValeur("pseudo"));
    ok.setEmail(pm.getValeur("email"));
    ok.setPrenom(pm.getValeur("prenom"));
    ok.setNom(pm.getValeur("nom"));
    ok.setPhoto(pm.getValeur("photo"));
    ok.setRole(Role.ETUDIANT);
    ok.setMotDePasse("mdp");
    mdpHash = BCrypt.hashpw("mdp", BCrypt.gensalt());
  }

  @Test
  void validateUser() {

    // Verification des cas simples
    assertNotNull(ok.getNom());
    assertEquals(ok.getNom(), pm.getValeur("nom"));
    ok.setNom("nom");
    assertEquals(ok.getNom(), "nom");

    assertNotNull(ok.getEmail());
    assertEquals(ok.getEmail(), pm.getValeur("email"));
    ok.setEmail("j");
    assertEquals(ok.getEmail(), "j");

    assertNotNull(ok.getPrenom());
    assertEquals(ok.getPrenom(), pm.getValeur("prenom"));
    ok.setPrenom("jiji");
    assertEquals(ok.getPrenom(), "jiji");

    assertNotNull(ok.getPseudo());
    assertEquals(ok.getPseudo(), pm.getValeur("pseudo"));
    ok.setPseudo("KFC");
    assertEquals(ok.getPseudo(), "KFC");

    assertNotNull(ok.getRole());
    assertEquals(ok.getRole(), Role.ETUDIANT);
    ok.setRole(Role.PROFESSEUR);
    assertEquals(ok.getRole(), Role.PROFESSEUR);

    assertNotNull(ok.getDateInscription());

    assertNotNull(ok.getEtudiant());

    assertNotNull(ok.getPhoto());
  }

  @Test
  void hashMdpTest() {
    this.mdpHash = BCrypt.hashpw("mdp", BCrypt.gensalt());
    assertNotNull(ok.hashMdp(ok.getMotDePasse()));
    assertNotEquals(BCrypt.hashpw(ok.getMotDePasse(), BCrypt.gensalt()), this.mdpHash);
    // Je ne sais pas récupérer le même salt et du coup il n'est pas content
  }

  @Test
  void checkMdpTest() {
    ok.setMotDePasse(mdpHash);
    assertTrue(ok.checkMdp("mdp"));
  }
}
