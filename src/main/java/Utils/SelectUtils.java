package Utils;

import BrowserFactory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static BrowserFactory.DriverFactory.getDriver;

public class SelectUtils {

    public static void selectByNameValue(String name, String value) {
        WebDriverWait wait = DriverFactory.getWebDriverWait();

        WebElement element = wait.until(
                ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(By.name(name))
                )
        );
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

}
