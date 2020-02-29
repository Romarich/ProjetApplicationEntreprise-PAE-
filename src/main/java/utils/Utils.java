package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public interface Utils {

  /**
   * Permet de transformer une String en code HTML.
   *
   * @param chemin - Le chemin pour récupérer la page html.
   * @return une string contenant l'html de la page à afficher.
   */
  static StringBuilder fichierHtmlVersString(String chemin) {
    StringBuilder pageHtml = new StringBuilder();
    File file = new File(chemin);
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(file));
      String line;
      while ((line = br.readLine()) != null) {
        pageHtml.append(line).append("\n");
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    }
    return pageHtml;
  }
}
