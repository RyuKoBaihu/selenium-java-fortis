package Utils;

import BrowserFactory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static BrowserFactory.DriverFactory.getDriver;

public class AssertsUtils {

    public static void AssertEqualsXpath(String text_expected, String xpath) {
        DriverFactory.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath))));
        String text_captured = getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(text_expected,text_captured);
    }

}
