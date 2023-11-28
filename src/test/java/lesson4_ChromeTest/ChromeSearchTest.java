package lesson4_ChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeSearchTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(priority = 2)
    public void chromeTest2() {
        driver.get("https://www.google.by/");
        WebElement searchLine = driver.findElement(By.id("APjFqb"));
        searchLine.sendKeys("Привет, Мир");
        searchLine.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://www.google.by/search?q="));
    }

    @Test(priority = 1)
    public void chromeTest1() {
        driver.get("https://www.google.by/");
        WebElement searchLine = driver.findElement(By.id("APjFqb"));
        searchLine.sendKeys("-DskipTests=true");
        searchLine.sendKeys(Keys.ENTER);
        WebElement errorMessage = driver.findElement(By.cssSelector("[aria-level='3']"));
        Assert.assertEquals(errorMessage.getText(), "По запросу -DskipTests=true ничего не найдено. ");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
