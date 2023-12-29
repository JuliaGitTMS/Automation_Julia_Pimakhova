package pageObjects.herokuApp;

import com.google.j2objc.annotations.Property;
import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

import static propertyUtils.PropertyReader.getProperties;

public class StartPage extends BasePage {

    public void homePage(String url) {
        navigateTo(url);
    }
    public void homePage() {
        navigateTo(getProperties().getProperty("url"));
    }

    public By getLocator(String name) {
        return By.linkText(name);
    }

    public void clickOnItem(StartPageItems item) {
        click(getLocator(item.getItem()));
    }
}
