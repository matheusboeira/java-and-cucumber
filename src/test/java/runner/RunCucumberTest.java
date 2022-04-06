package runner;

import environment.Browser;
import environment.Property;
import environment.Repository;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@UC01"
)
public class RunCucumberTest {
    @BeforeClass
    public static void beforeClass() {
        try {
            Property.loadProperties();
            Repository.loadRepository();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @AfterClass
    public static void afterClass() {
        try {
            Runtime.getRuntime().exec(Browser.getDriverToKill());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
