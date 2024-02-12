package pageObjects.rw;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class HomePage {
    private final SelenideElement from = $(byName("from"));
    private final SelenideElement to = $(byId("acTo"));
    private final SelenideElement station = $(byName("station"));
    private final SelenideElement byRoute = $(byId("tabForm1"));
    private final SelenideElement byStation = $(byId("tabForm2"));
    private final SelenideElement searchButton = $("input[type='submit']");
    private final SelenideElement searchStButton = $x("(//input[@type='submit'])[2]");

    public HomePage enterFrom(String fromValue) {
        from.shouldBe(visible).sendKeys(fromValue);
        return this;
    }

    public HomePage enterTo(String toValue) {
        to.shouldBe(visible).sendKeys(toValue);
        return this;
    }
    public HomePage enterStation(String stationName) {
        station.shouldBe(visible).sendKeys(stationName);
        return this;
    }
    public HomePage clickOnElement (SelenideElement element){
        element.shouldBe(enabled).click();
        return this;
    }
    public HomePage searchClick (){
        clickOnElement(searchButton);
        return this;
    }
    public HomePage searchStClick (){
        clickOnElement(searchStButton);
        return this;
    }
    public HomePage clickSearchByRoute (){
        clickOnElement(byRoute);
        return this;
    }
    public HomePage clickSearchByStation (){
        clickOnElement(byStation);
        return this;
    }
}
