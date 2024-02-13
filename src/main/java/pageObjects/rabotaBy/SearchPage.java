package pageObjects.rabotaBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private final SelenideElement searchLine = $("input[id=\"a11y-search-input\"]");
    private final SelenideElement header = $("h1[data-qa='vacancies-catalog-header']");
    private final ElementsCollection vacancies = $$("span[data-qa='serp-item__title']");

    public SearchPage headerCheck() {
        Assert.assertTrue(header.shouldBe(Condition.visible).text().contains(searchLine.text()));
        return this;
    }

    public SearchPage vacanciesCheck(int minQuantity) {
        Assert.assertTrue(vacancies.size() >= minQuantity);
        return this;
    }

}
