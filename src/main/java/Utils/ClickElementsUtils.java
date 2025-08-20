package Utils;
import BrowserFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static BrowserFactory.DriverFactory.getDriver;


public class ClickElementsUtils {

    public static void clickByXpath(String xpath) {
        WebDriverWait wait = DriverFactory.getWebDriverWait();
        WebElement element = wait.until(
                ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
                )
        );
        element.click();
    }



}
