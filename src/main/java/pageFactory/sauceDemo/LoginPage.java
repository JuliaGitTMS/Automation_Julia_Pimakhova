package pageFactory.sauceDemo;

import entities.saucedemo.User;
import entities.saucedemo.UserBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.ImprovedWebDriver.getWebDriver;
import static propertyUtils.PropertyReader.getProperties;

public class LoginPage extends BasePage {
    @FindBy(className = "login_logo")
    WebElement header;
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(name = "login-button")
    WebElement loginButton;
    @FindBy(id = "login_credentials")
    WebElement userNames;
    @FindBy(className = "login_password")
    WebElement passwords;

    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public LoginPage enterUsername(String username) {
        sendKeys(this.username, username);
        return this;
    }
    public LoginPage enterUsername (User user){
        return enterUsername(user.getUsername());
    }
    public LoginPage enterUsername (UserBuilder user){
        return enterUsername(user.getUsername());
    }

    public LoginPage enterUsername() {
        sendKeys(this.username, getProperties().getProperty("username"));
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(this.password, password);
        return this;
    }
    public LoginPage enterPassword() {
        sendKeys(this.password, getProperties().getProperty("password"));
        return this;
    }
    public LoginPage enterPassword(User user){
        return enterPassword(user.getPassword());
    }
    public LoginPage enterPassword(UserBuilder user){
        return enterPassword(user.getPassword());
    }

    public LoginPage loginClick() {
        click(loginButton);
        return this;
    }

    public List<String> getUsernames() {
        return Arrays.stream(userNames.getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }

    public String getPassword() {
        return Arrays.stream(passwords.getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }

    public LoginPage homePage(String url) {
        navigateTo(url);
        return this;
    }

    public LoginPage homePage() {
        navigateTo(getProperties().getProperty("url"));
        return this;
    }

    public LoginPage successfulLoginVerification() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public LoginPage unSuccessfulLoginVerification() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
        return this;
    }
}
