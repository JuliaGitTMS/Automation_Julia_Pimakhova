package pageObjects.sauceDemo;

import entities.saucedemo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.ImprovedWebDriver.getWebDriver;
import static propertyUtils.PropertyReader.getProperties;

public class LoginPage extends BasePage {
    private final By header = By.className("login_logo");
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.name("login-button");
    private final By userNames = By.id("login_credentials");
    private final By passwords = By.className("login_password");

    public void enterUsername(String username) {
        sendKeys(this.username, username);
    }
    public void enterUsername(User user) {
        sendKeys(this.username, user.getUsername());
    }
    public void enterUsername() {
        sendKeys(this.username, getProperties().getProperty("username"));
    }

    public void enterPassword(String password) {
        sendKeys(this.password, password);
    }
    public void enterPassword(User user) {
        sendKeys(this.password, user.getPassword());
    }

    public void enterPassword() {
        sendKeys(this.password, getProperties().getProperty("password"));
    }

    public void loginClick() {
        click(loginButton);
    }

    public List<String> getUsernames() {
        return Arrays.stream(getWebDriver().findElement(userNames).getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }

    public String getPassword() {
        return Arrays.stream(getWebDriver().findElement(passwords).getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }

    public void homePage(String url) {
        navigateTo(url);
    }

    public void homePage() {
        navigateTo(getProperties().getProperty("url"));
    }

    public void successfulLoginVerification() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }

    public void unSuccessfulLoginVerification() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }

}
