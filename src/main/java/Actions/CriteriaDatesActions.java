package Actions;

import Pages.RandomDatePage;

import static Utils.SendKeysUtils.sendKeysByName;

public class CriteriaDatesActions extends RandomDatePage {

    public void executeDateCriteria() throws InterruptedException {
        sendKeysByName("4","num");
        Thread.sleep(5000);
    }
}
