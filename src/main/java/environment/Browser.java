package environment;

import environment.enums.PropertyOf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class is responsible to get or change the browser
 * automatically, according to {@code project.properties} file
 *
 * @author Matheus Boeira Dias
 */
public class Browser {
    private static final String CHROME_PATH = "src/main/resources/drivers/chromedriver.exe";
    private static final String FIREFOX_PATH = "src/main/resources/drivers/geckodriver.exe";
    private static final String BROWSER = Property.get(PropertyOf.BROWSER);

    private static String TASKKILL;

    /**
     * Return the exact instance of driver requested
     * if it exists on <b>project.properties</b> file.
     * <p>
     * The list is: {@code chrome} and {@code firefox}
     *
     * @return the instance of browser required if exists or
     * a {@code NullPointerException} will throws.
     * @throws NullPointerException if the browser is not valid
     */
    public static WebDriver setDriver() {
        switch (BROWSER.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                TASKKILL = "taskkill /im chromedriver.exe /f";
                return new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
                TASKKILL = "taskkill /im geckodriver.exe /f";
                return new FirefoxDriver();
            }
        }
        throw new NullPointerException("\nCould not initialize a valid browser. " +
                "Please, check it out the list of browsers.");
    }

    /**
     * This method returns the {@code String} of a command to 'taskkill'
     * all the instance of the actual browser opened. This is used after
     * all the tests has been executed.
     *
     * @return the string of taskkill command to execute
     */
    public static String getDriverToKill() {
        return Browser.TASKKILL;
    }
}