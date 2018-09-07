/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luka
 */
public class PropertyReader {
    Properties properties;

    public PropertyReader() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("./db.config"));

        } catch (Exception ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String readForKey(String key) {
        return properties.getProperty(key);
    }
}
