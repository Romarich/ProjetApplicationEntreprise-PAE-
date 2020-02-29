package be.ipl.pae.ihm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private ConnexionControlleur connexionControlleur;

  public ClientServlet(ConnexionControlleur connexionControlleur) {
    super();
    this.connexionControlleur = connexionControlleur;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    if("/client".equals(req.getRequestURI())) {
      File aRenvoyeHeader = new File("www/html/header.html");
      Files.copy(aRenvoyeHeader.toPath(), resp.getOutputStream());
      for(File f : new File("www/html/contenu").listFiles()) {
        Files.copy(f.toPath(), resp.getOutputStream());
      }
      File aRenvoyeFooter = new File("www/html/footer.html");
      Files.copy(aRenvoyeFooter.toPath(), resp.getOutputStream());
      //juste rajouter le footer si on en a un
      
      
      
      
//      
//        Files.copy(new File("www/inc/header.html").toPath(), resp.getOutputStream());
//        File fi = new File("www/inc");
//        File[] files = fi.listFiles();
//        for (File f : files) {
//          if (f.getName().startsWith("_") && f.getName().endsWith(".html")) {
//            System.out.println(f.getName());µ 
//            Files.copy(f.toPath(), resp.getOutputStream());
//          }
//        }
//        Files.copy(new File("www/inc/prefooter.html").toPath(), resp.getOutputStream());
//        fi = new File("www/js");
//        files = fi.listFiles();
//        for (File f : files) {
//          if (f.getName().endsWith(".js")) {
//            String string =
//                "<script type=\"application/javascript\" src=\"js/" + f.getName() + "\"></script>";
//            System.out.println(string);
//            resp.getOutputStream().write(string.getBytes(Charset.forName("UTF-8")));
//          }
//    
    /*
     * if / == req
     * 
     * File f.copy(new File("".toPath(),resp.getOutputStream()))
     * 
     * for Gile g : new file www/inc.listFile if f.name().startWith("_"){ File.copy(new
     * File("".path,resp.getOutputStream())) }
     */
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    switch (req.getParameter("action")) {
      case "connexion":
        try {
          String token = connexionControlleur.connexionUtilisateur(req.getParameter("json"));
          envoiElementVersFrontEnd(token, 200, resp);
        } catch (Exception exc) {
          envoiElementVersFrontEnd(exc.getMessage(), 400, resp);
        }
        break;
      case "inscription":
        try {
          connexionControlleur.inscriptionUtilisateur(req.getParameter("json"));
        } catch (Exception exc) {
          envoiElementVersFrontEnd(exc.getMessage(), 400, resp);
        }
        break;
      case "verif":
        Cookie[] cookies = req.getCookies();
        String token = null;
        for (Cookie c : cookies) {
          if ("token".equals(c.getName())) {
            token = c.getValue();
          }
        }
        connexionControlleur.verificationJwt(token);
        break;
      default:
        resp.setStatus(404);
        break;
    }
  }

  private void envoiElementVersFrontEnd(String elementAEnvoye, int status,
      HttpServletResponse resp) {
    PrintWriter pw;
    try {
      pw = resp.getWriter();
      pw.println(elementAEnvoye);
      resp.setStatus(status);
    } catch (IOException exc) {
      exc.printStackTrace();
    }
  }
}
