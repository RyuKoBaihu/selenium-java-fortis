package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@SuppressWarnings("DefaultAnnotationParam")
@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = {"src/test/resources/features"},
        glue = {"StepDefinitions","BrowserFactory"},
        monochrome = false,
        stepNotifications = true,
        tags ="@buy_item"
)
public class TestRunner {

}
