package be.ipl.pae.config;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesManager {

  private final Properties props = new Properties();

  public PropertiesManager() {

  }

  /**
   * Permet de set le fichier de propriété pour cette instance. Si le fichier est invalide, on
   * retourne une RunTimeException.
   *
   * @param nomFichier - Nom du fichier qui dois être dans le dossier properties.
   */
  public void setFichier(String nomFichier) {
    try {
      FileInputStream file = new FileInputStream("properties/" + nomFichier + ".properties");
      props.load(file);
      file.close();
    } catch (Throwable exc) {
      throw new RuntimeException(exc);
    }
  }

  /**
   * Permet de récupérer une valeur depuis le fichier de properties.
   *
   * @param cle - Clé de la valeur que l'on recherche.
   * @return La valeur lié à la clé demandée.
   */
  public String getValeur(String cle) {
    return props.getProperty(cle);
  }
}
