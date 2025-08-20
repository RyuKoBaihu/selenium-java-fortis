package Utils;

import BrowserFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static BrowserFactory.DriverFactory.getDriver;

public class SendKeysUtils {

    public static WebDriverWait wait;

    public static void sendKeysByID(String text, String id_element){
        DriverFactory.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.id(id_element)));
        WebElement element = getDriver().findElement(By.id(id_element));
        element.sendKeys(text);
    }

    public static void sendKeysByName(String text, String name_element) {
        WebDriverWait wait = DriverFactory.getWebDriverWait();
        WebElement element = wait.until(ExpectedConditions.refreshed(
                             ExpectedConditions.presenceOfElementLocated(By.name(name_element)))
        );
        element.clear();
        element.sendKeys(text);
    }

}

