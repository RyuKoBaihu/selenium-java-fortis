package Actions;

import Pages.RandomDatePage;
import Pages.ResultDatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static BrowserFactory.DriverFactory.getDriver;
import static Utils.ClickElementsUtils.clickByXpath;
import static Utils.SelectUtils.selectByNameValue;
import static Utils.SendKeysUtils.sendKeysByName;

public class CriteriaDatesActions extends RandomDatePage {

    ResultDatePage resultDatePage = new ResultDatePage();
    WebDriver driver = getDriver();
    String STRING_VALUE_NUMBER_OF_DATES = "4";
    String STRING_VALUE_START_DAY = "15";
    String STRING_VALUE_START_MONTH = "1";
    String STRING_VALUE_START_YEAR = "2024";
    String STRING_VALUE_END_DAY = "24";
    String STRING_VALUE_END_MONTH = "11";
    String STRING_VALUE_END_YEAR = "2025";


    public void executeDateCriteria() throws InterruptedException {
        sendKeysByName(STRING_VALUE_NUMBER_OF_DATES,INPUT_PICK_A_TOTAL_NAME);
        selectByNameValue(SELECT_START_DAY_NAME,STRING_VALUE_START_DAY);
        selectByNameValue(SELECT_START_MONTH_NAME,STRING_VALUE_START_MONTH);
        selectByNameValue(SELECT_START_YEAR_NAME,STRING_VALUE_START_YEAR);
        selectByNameValue(SELECT_END_DAY_NAME,STRING_VALUE_END_DAY);
        selectByNameValue(SELECT_END_MONTH_NAME,STRING_VALUE_END_MONTH);
        selectByNameValue(SELECT_END_YEAR_NAME,STRING_VALUE_END_YEAR);
        clickByXpath(BUTTON_GET_DATES);
        checkResult();
    }

    public void checkResult() {
        WebElement paragraph = driver.findElement(By.xpath("//*[@id='invisible']/p[2]"));
        String text = paragraph.getText();
        String[] dates = text.split("\n");
        for(String date : dates) {

            System.out.println(date);
        }
    }

    public void buildStartDate() {

    }

    public void buildEndDate() {

    }

    public void compareRangeDate() {

    }

}
