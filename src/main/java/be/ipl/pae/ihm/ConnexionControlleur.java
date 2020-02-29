package be.ipl.pae.ihm;

import be.ipl.pae.business.impl.UtilisateurImpl;
import be.ipl.pae.business.interfaces.UtilisateurDto;
import be.ipl.pae.config.PropertiesManager;
import be.ipl.pae.ucc.interfaces.UtilisateurUcc;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.util.HashMap;
import java.util.Map;

class ConnexionControlleur {

  private final String secret;
  private UtilisateurUcc utilisateurUcc;
  private Genson genson;

  ConnexionControlleur(UtilisateurUcc utilisateurUcc, PropertiesManager prop) {
    this.utilisateurUcc = utilisateurUcc;
    this.genson = new GensonBuilder().useRuntimeType(true).create();
    this.secret = prop.getValeur("JWTSECRET");
  }

  /**
   * Permet de connecter un utilisateur.
   *
   * @throws Exception - Renvoie la bizzException s'il en a reçu une ou alors envoie un simple
   *     exception si le mot de passe et/ou le pseudo sont vides
   */
  String connexionUtilisateur(String jsonInfo) throws Exception {
    Map<String, String> map = genson.deserialize(jsonInfo, Map.class);
    if (erreurJsonElementVide(jsonInfo)) {
      throw new Exception("Erreur le pseudo et/ou le mot de passe ne peuvent pas être vide.");
    } else {
      try {
        utilisateurUcc.connectUser(map.get("pseudo"), map.get("mdp"));
        System.out.println("Utilisateur connecté");
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
            .withClaim("pseudo", map.get("pseudo"))
            .withIssuer("auth0")
            .sign(algorithm);
      } catch (Exception exc) {
        if (exc.getClass().getSimpleName().equals("FatalException")) {
          System.out.println(
              "L'erreur est soit pas repertoire ou alors la connexion"
                  + " à la base de données n'est pas disponible");
        } else if (exc.getClass().getSimpleName().equals("BizzException")) {
          System.out.println("Erreur de business : " + exc.getMessage());
          throw exc;
        } else if (exc.getClass().getSimpleName().equals("JWTCreationException")) {
          System.out.println("Erreur sur la validation et creation du JWT");
        }
        exc.printStackTrace();
      }
    }
    return "";
  }

  /**
   * Permet d'inscrire un nouvel utilisateur.
   *
   * @param jsonInfo - Json avec les informations de l'utilisateur.
   * @throws Exception Renvoie la bizzException s'il en a reçu une ou alors une simple exception si
   *     un des champs dans le Json est vide
   */
  void inscriptionUtilisateur(String jsonInfo) throws Exception {
    if (erreurJsonElementVide(jsonInfo)) {
      throw new Exception("Tous les champs doivent être remplis.");
    } else {
      try {
        UtilisateurDto utilisateurRegister =
            genson.deserialize(jsonInfo.getBytes(), UtilisateurImpl.class);
        utilisateurUcc.registerUser(utilisateurRegister);
      } catch (Exception exc) {
        if (exc.getClass().getSimpleName().equals("FatalException")) {
          System.out.println(
              "L'erreur est soit pas repertoire ou alors la connexion"
                  + " à la base de données n'est pas disponible");
        } else if (exc.getClass().getSimpleName().equals("BizzException")) {
          System.out.println("Erreur de business : " + exc.getMessage());
          throw exc;
        }
        exc.printStackTrace();
      }
    }
  }

  /**
   * Permet de vérifier les éléments contenus dans le Json.
   *
   * @param jsonInfo - Le Json a vérifié.
   * @return true si une ou plusieurs informations sont vide. Sinon false.
   */
  private boolean erreurJsonElementVide(String jsonInfo) {
    Map<String, String> map =
        (Map<String, String>) genson.deserialize(jsonInfo.getBytes(), HashMap.class);
    for (String s : map.values()) {
      if (s.replaceAll(" ", "").equals("")) {
        return true;
      }
    }
    return false;
  }

  boolean verificationJwt(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
      verifier.verify(token);
    } catch (JWTVerificationException exception) {
      // Invalid signature/claims
      exception.printStackTrace();
      return false;
    }
    return true;
  }
}
