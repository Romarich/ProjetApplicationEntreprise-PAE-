package be.ipl.pae.config;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InjectionManager {

  private Map<Class, Object> cacheSingletons = new HashMap<>();
  private PropertiesManager pm;

  public InjectionManager(PropertiesManager propertiesManager) {
    cacheSingletons.put(propertiesManager.getClass(), propertiesManager);
    this.pm = propertiesManager;
  }

  /**
   * Permet de faire l'injection de dépendance d'une classe.
   *
   * @param interfaceDeInstance - La classe sur laquelle faire l'injection de dépendance.
   * @return Instance de la classe.
   */
  public Object getImplementingInstance(final Class interfaceDeInstance) {
    if (cacheSingletons.containsKey(interfaceDeInstance)) {
      return cacheSingletons.get(interfaceDeInstance);
    }
    String implNom = pm.getValeur(interfaceDeInstance.getSimpleName());

    try {
      Class.forName(implNom);
      Constructor<?> constructeur = Class.forName(implNom).getDeclaredConstructors()[0];
      constructeur.setAccessible(true);
      Class<?>[] parametreList = constructeur.getParameterTypes();
      List<Object> parametreInstancier = new ArrayList<>();

      for (Class<?> classeCourant : parametreList) {
        parametreInstancier.add(getImplementingInstance(classeCourant));
      }

      Object instance = constructeur.newInstance(parametreInstancier.toArray());
      cacheSingletons.put(interfaceDeInstance, instance);
      return instance;
    } catch (Throwable exc) {
      exc.printStackTrace();
      throw new RuntimeException(exc);
    }
  }
}
