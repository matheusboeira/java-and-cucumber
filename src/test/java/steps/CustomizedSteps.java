package steps;

import environment.Browser;
import environment.Property;
import environment.Repository;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CustomizedSteps {
    private static WebDriver driver;
    private static final long millis = 500;

    @Before
    public static synchronized void setUp() {
        try {
            driver = Browser.setDriver();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    @AfterStep
    public static synchronized void afterStep() throws InterruptedException {
        Thread.sleep(millis);
    }

    /**
     * Method responsible to maximize, set an implicit wait
     * and navigate to the value of 'url' in repository file.
     */
    @Given("^that browser is open")
    public static synchronized void open() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to(Property.get("url"));
    }

    /**
     * Method responsible for placing, in order to minimize lines, the user's
     * credentials located in the repository file.
     */
    @When("^the user puts his credentials")
    public static synchronized void credentials() {
        putIn(Property.get("user"), "LoginPage.txtEmail");
        putIn(Property.get("password"), "LoginPage.txtPassword");
    }

    /**
     * Method responsible to click in a button already mapped
     * on repository file.
     *
     * @param element the element already registered in your
     *                repository
     */
    @And("^the user clicks on \"(.*)\"$")
    public static synchronized void clickOn(String element) {
        try {
            driver.findElement(By.xpath(Repository.getElement(element))).click();
        } catch (Exception e) {
            System.err.println("Impossible to find the element. Please, check it out. Error: " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method responsible to put something (text or file) in an element already
     * mapped on repository file.
     *
     * @param element the element already registered in your repository
     * @param text    the text to send keys
     */
    @And("^the user puts \"(.*)?\" on \"(.*)?\"$")
    public static synchronized void putIn(String text, String element) {
        driver.findElement(By.xpath(Repository.getElement(element))).clear();
        driver.findElement(By.xpath(Repository.getElement(element))).sendKeys(text);
    }

    /**
     * Method responsible to close the instance of browser. This will
     * only close the actual 'tab' in browser. To close everything,
     * use 'the user quits the browser' instead.
     */
    @And("^the user closes the browser")
    public static synchronized void closes() {
        driver.close();
    }

    /**
     * Method responsible to quit the instance of browser. This will
     * close all current 'tabs' in browser. To close only one tab,
     * use 'the user closes the browser' instead.
     */
    @And("^the user quits the browser")
    public static synchronized void quits() {
        driver.quit();
    }
}
