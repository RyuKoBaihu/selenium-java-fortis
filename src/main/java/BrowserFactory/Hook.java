package BrowserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static BrowserFactory.DriverFactory.getDriver;

public class Hook {
    private static final Logger logger = LogManager.getLogger(Hook.class);
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = getDriver();
        logger.info("Browser initialized");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverFactory.quitDriver();
            logger.info("Browser closed");
        }
    }
}
