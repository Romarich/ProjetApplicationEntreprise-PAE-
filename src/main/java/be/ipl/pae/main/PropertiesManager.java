package be.ipl.pae.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
  private final Properties prop;
  InputStream input = null;

  PropertiesManager() {
    prop = new Properties();
    try {
      input = new FileInputStream(".properties");
      prop.load(input);
    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (final IOException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  public String getValue(String key) {
    return prop.getProperty(key);
  }
}
