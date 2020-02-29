package be.ipl.pae.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import be.ipl.pae.config.InjectionManager;
import be.ipl.pae.config.PropertiesManager;
import be.ipl.pae.ihm.ClientServlet;

public class Main {

  /**
   * Main de notre application.
   *
   * @param args - Argument pour le demarrage de l'application.
   * @throws Exception - Exception.
   */
  public static void main(String[] args) throws Exception {

    PropertiesManager pm = new PropertiesManager();
    pm.setFichier("prod");

    WebAppContext context = new WebAppContext();

    context.setResourceBase("www");

    InjectionManager im = new InjectionManager(pm);
    ClientServlet servlet = (ClientServlet) im.getImplementingInstance(ClientServlet.class);

    context.addServlet(new ServletHolder(servlet), "/client");

    context.setWelcomeFiles(new String[] {"html/header.html"});

    Server server = new Server(Integer.parseInt(pm.getValeur("sr_port")));

    server.setHandler(context);
    try {
      server.start();

    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException exc) {
      exc.printStackTrace();
    }
  }
}
