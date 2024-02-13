package pageObjects.rabotaBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private final SelenideElement jobName = $("input[id=\"a11y-search-input\"]");
    private final SelenideElement searchButton = $("button[data-qa='search-button']");

    public StartPage enterJobName (String job){
        jobName.shouldBe(Condition.visible).sendKeys(job);
        return this;
    }

    public StartPage clickSearchButton (){
        searchButton.shouldBe(Condition.enabled).click();
        return this;
    }

}
