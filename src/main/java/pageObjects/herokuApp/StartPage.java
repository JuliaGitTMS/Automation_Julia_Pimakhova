package pageObjects.herokuApp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class StartPage extends BasePage {

    public void homePage(String url) {
        navigateTo(url);
    }

    public By getLocator(String name) {
        return By.linkText(name);
    }

    public void clickOnItem(StartPageItems item) {
        click(getLocator(item.getItem()));
    }
}
