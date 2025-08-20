package Actions;

import Pages.RandomDatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static BrowserFactory.DriverFactory.getWebDriverWait;
import static Pages.ResultDatePage.TEXT_RESULT_XPATH;
import static Utils.ClickElementsUtils.clickByXpath;
import static Utils.SelectUtils.selectByNameValue;
import static Utils.SendKeysUtils.sendKeysByName;

public class CriteriaDatesActions extends RandomDatePage {

    // Default Date Formatter YYYY-MM-DD
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
    private static final Logger logger = LoggerFactory.getLogger(CriteriaDatesActions.class);

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
    }

    public LocalDate buildStartDate() {
        StringBuilder sb = new StringBuilder();
        sb.append(STRING_VALUE_START_YEAR).append("-")
                .append(STRING_VALUE_START_MONTH).append("-")
                .append(STRING_VALUE_START_DAY);

        LocalDate startDate = LocalDate.parse(sb.toString(), formatter);
        logger.info("Start Date: " + startDate);
        return startDate;
    }

    public LocalDate buildEndDate() {
        StringBuilder sb = new StringBuilder();
        sb.append(STRING_VALUE_END_YEAR).append("-")
                .append(STRING_VALUE_END_MONTH).append("-")
                .append(STRING_VALUE_END_DAY);

        LocalDate endDate = LocalDate.parse(sb.toString(), formatter);
        logger.info("End Date: " + endDate);
        return endDate;
    }

    public void compareRangeDate() {
        LocalDate startDate = buildStartDate();
        LocalDate endDate = buildEndDate();

        WebElement datesSelected = getWebDriverWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_RESULT_XPATH))
        );

        String text = datesSelected.getText();
        String[] dates = text.split("\n");

        logger.info("Comparing dates: " + startDate + " a " + endDate);

        for (String dateStr : dates) {
            LocalDate date = LocalDate.parse(dateStr, formatter);

            if ((date.isEqual(startDate) || date.isAfter(startDate)) &&
                    (date.isEqual(endDate)   || date.isBefore(endDate))) {

                logger.info("{} is within the allowed date range.", date);

            } else {
                logger.error("{} is outside the allowed date range ({} - {}).",
                        date, startDate, endDate);
                throw new IllegalArgumentException(
                        "Date out of allowed range: " + date);
            }
        }
    }

}
