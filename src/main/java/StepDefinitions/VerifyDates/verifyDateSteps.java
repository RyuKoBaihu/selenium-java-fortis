package StepDefinitions.VerifyDates;


import Actions.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class verifyDateSteps {


        InitialActions initialActions = new InitialActions();
        CriteriaDatesActions criteriaDatesActions = new CriteriaDatesActions();

        @Given("that I am on the initial page")
        public void iAmOnTheInitialPage() throws InterruptedException {
            initialActions.initialPage();
        }

        @When("I execute the dates criteria")
        public void iExecuteTheDatesCriteria() throws InterruptedException {
            criteriaDatesActions.executeDateCriteria();
        }

        @Then("I check if the the results are correct")
        public void iCheckIfTheResultsAreCorrect() {
            criteriaDatesActions.compareRangeDate();
        }

}

