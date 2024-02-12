package pageObjects.baseObjects;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public abstract class BaseTestSelenide {
    protected <T> T get(Class<T> page) {
        return driver().hasWebDriverStarted() ? page(page) : open(Configuration.baseUrl, page);
    }
    protected <T> T getStartPage(Class<T> page) {
        return open(Configuration.baseUrl, page);
    }
}
