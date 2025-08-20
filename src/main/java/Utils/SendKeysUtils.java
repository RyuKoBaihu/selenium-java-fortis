package Utils;

import BrowserFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendKeysUtils {

    public static void sendKeysByName(String text, String name_element) {
        WebDriverWait wait = DriverFactory.getWebDriverWait();
        WebElement element = wait.until(ExpectedConditions.refreshed(
                             ExpectedConditions.presenceOfElementLocated(By.name(name_element)))
        );
        element.clear();
        element.sendKeys(text);
    }

}

