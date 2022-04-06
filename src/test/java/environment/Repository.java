package environment;

import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible to read the {@code file}
 * that contains each {@code page-object} mapped.
 *
 * @author Matheus Boeira Dias
 */
public class Repository {
    private static HashMap<?, ?> property;
    private final static String PATH = "files\\repository.yaml";

    /**
     * This method loads the Yaml file in order to map
     * all pages with respective elements in an HashMap.
     */
    public static void loadRepository() throws IOException {
        Yaml yaml = new Yaml();

        try (var reader = new FileReader(PATH)) {
            property = yaml.load(reader);
        } catch (IOException ioe) {
            throw new IOException(
                    "The file couldn't be read. Error: " + ioe.getMessage()
            );
        }
    }

    /**
     * This method returns the requested element if it is mapped in
     * the repository file. This repository is loaded by the instance
     * of this class.
     *
     * @param page the page with an element already mapped in
     *             repository file.
     * @return the element (the 'xpath' being more specific)
     */
    public static String getElement(String page) {
        try {
            Map<?, ?> map = (Map<?, ?>) property.get(page.split("\\.")[0]);
            return map.get(page.split("\\.")[1]).toString();
        } catch (NullPointerException npe) {
            throw new NullPointerException(
                    "Element or page not found. Error: " + npe.getMessage()
            );
        }
    }
}
