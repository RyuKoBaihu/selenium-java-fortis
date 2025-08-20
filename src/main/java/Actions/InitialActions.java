package Actions;


import org.openqa.selenium.WebDriver;

import static BrowserFactory.DriverFactory.getDriver;
import static StepDefinitions.GeneralSteps.ApplicationProperties.getUrl;

public class InitialActions {

    WebDriver driver = getDriver();
    String URL = getUrl();

    public void initialPage() {
        driver.get(URL);
        System.out.println("URL: " + URL);
    }

}
