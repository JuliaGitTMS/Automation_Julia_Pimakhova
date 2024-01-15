package pageObjects.baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import testngUtils.Listener;

import java.time.Duration;
import java.util.Arrays;

import static driver.ImprovedWebDriver.*;
import static driver.ImprovedWebDriver.getWebDriver;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    {
        driver = getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
        actions = new Actions(driver);
    }

    protected void navigateTo(String url) {
        System.out.println("Navigate to::" + url);
        driver.get(url);
    }

    protected void click(By by) {
        System.out.println("Click on element::" + driver.findElement(by));
        driver.findElement(by).click();
    }

    protected void click(WebElement element) {
        System.out.println("Click on element::" + element);
        element.click();
    }

    protected void sendKeys(By by, CharSequence... charSequences) {
        System.out.println("Enter in element::" + driver.findElement(by) + " next keys: " + Arrays.toString(charSequences));
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(charSequences);
    }

    protected void sendKeys(WebElement element, CharSequence... charSequences) {
        System.out.println("Enter in element::" + element + " next keys: " + Arrays.toString(charSequences));
        element.clear();
        element.sendKeys(charSequences);
    }

    protected String getElementText(By by) {
        return driver.findElement(by).getText();
    }

    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    protected void waitUntilElementToBeVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitUntilElementToBeVisible(By by) {
        waitUntilElementToBeVisible(driver.findElement(by));
    }

    protected void waitUntilElementNotToBeVisible(WebElement webElement) {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(webElement)));
    }

    protected void waitUntilElementNotToBeVisible(By by) {
        waitUntilElementNotToBeVisible(driver.findElement(by));
    }

    protected void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementToBeClickable(By by) {
        waitUntilElementToBeClickable(driver.findElement(by));
    }
}
