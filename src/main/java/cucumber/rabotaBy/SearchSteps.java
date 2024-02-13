package cucumber.rabotaBy;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rabotaBy.SearchPage;
import pageObjects.rabotaBy.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class SearchSteps extends BaseTestSelenide {

    @Given("open HomePage")
    public void precondition() {
        open("https://rabota.by/");
    }

    @When("I enter job or company name")
    public void enterJob() {
        get(StartPage.class).enterJobName("QA Automation");
    }

    @And("I click search button")
    public void clickSearch() {
        get(StartPage.class).clickSearchButton();
    }

    @Then("I check if header contains entered job name")
    public void checkHeader() {
        get(SearchPage.class).headerCheck();
    }

    @And("I check if vacancies quantity is more or equals {int}")
    public void checkResults(int minQuantity) {
        get(SearchPage.class).vacanciesCheck(minQuantity);
    }
}
