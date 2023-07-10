package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        dryRun = false
)
public class Rerunner {

    @BeforeClass
    public static void setFailure() {
        Driver.isFailure = true;
    }

    @AfterClass
    public static void resetFailure() {
        Driver.isFailure = false;
    }
}
