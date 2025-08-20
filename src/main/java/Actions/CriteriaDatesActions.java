package Actions;

import Pages.RandomDatePage;
import Pages.ResultDatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static BrowserFactory.DriverFactory.getDriver;
import static BrowserFactory.DriverFactory.getWebDriverWait;
import static Utils.ClickElementsUtils.clickByXpath;
import static Utils.SelectUtils.selectByNameValue;
import static Utils.SendKeysUtils.sendKeysByName;

public class CriteriaDatesActions extends RandomDatePage {

    // Formatter padrão YYYY-MM-DD
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

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
        buildStartDate();
        buildEndDate();
        checkResult();
    }

    public void checkResult() {
        WebElement paragraph = getWebDriverWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='invisible']/p[2]"))
        );
        String text = paragraph.getText();
        String[] dates = text.split("\n");
        for(String date : dates) {

            System.out.println(date);
        }
    }

    public LocalDate buildStartDate() {
        StringBuilder sb = new StringBuilder();
        sb.append(STRING_VALUE_START_YEAR).append("-")
                .append(STRING_VALUE_START_MONTH).append("-")
                .append(STRING_VALUE_START_DAY);

        LocalDate startDate = LocalDate.parse(sb.toString(), formatter);
        System.out.println("Data de Início: " + startDate);
        return startDate;
    }

    public LocalDate buildEndDate() {
        StringBuilder sb = new StringBuilder();
        sb.append(STRING_VALUE_END_YEAR).append("-")
                .append(STRING_VALUE_END_MONTH).append("-")
                .append(STRING_VALUE_END_DAY);

        LocalDate endDate = LocalDate.parse(sb.toString(), formatter);
        System.out.println("Data de Fim: " + endDate);
        return endDate;
    }

    public void compareRangeDate() {
        // Constrói as datas de início e fim
        LocalDate startDate = buildStartDate();
        LocalDate endDate = buildEndDate();

        // Pega o parágrafo atualizado
        WebElement paragraph = getWebDriverWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='invisible']/p[2]"))
        );

        String text = paragraph.getText();
        String[] dates = text.split("\n");

        System.out.println("\nComparing dates: " + startDate + " a " + endDate);

        // Itera pelas datas do resultado e compara
        for (String dateStr : dates) {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            if ((date.isEqual(startDate) || date.isAfter(startDate)) &&
                    (date.isEqual(endDate) || date.isBefore(endDate))) {
                System.out.println(date + " range date correct.");
            } else {
                System.out.println(date + " range date incorrect.");
            }
        }
    }

}
