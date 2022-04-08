package environment;

import environment.enums.PropertyOf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is responsible to load and get the properties
 * file that contains all information.
 *
 * @author Matheus Boeira Dias
 */
public class Property {
    private static Properties properties;
    private final static String PATH = "files\\project.properties";

    /**
     * Performs the reading of <b>project.properties</b> file
     * on folder <b>files</b> of this project and load these
     * properties into 'properties' variable of this class.
     */
    public static void loadProperties() {
        properties = new Properties();

        try (InputStream input = new FileInputStream(PATH)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param property the property to get the value
     * @return the property value
     */
    public static String get(PropertyOf property) {
        return properties.getProperty(property.toString().toLowerCase());
    }
}
