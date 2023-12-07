package lesson6_SaucedemoTest;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SauceDemoTest {
    @BeforeTest
    public void startUp() {
        driverSetUp(" https://www.saucedemo.com/");
    }

    @Test
    public void test1() {
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.cssSelector("[data-test='login-button']")).click();
        String price = getWebDriver().findElement(By.xpath("(//div[@class='inventory_item']/descendant::div[@class='inventory_item_price'])[1]")).getText();
        String name = getWebDriver().findElement(By.xpath("(//div[@class='inventory_item']/descendant::div[@class='inventory_item_name '])[1]")).getText();
        getWebDriver().findElement(By.xpath("(//div[@class='inventory_item']/descendant::button)[1]")).click();
        getWebDriver().findElement(By.className("shopping_cart_link")).click();
        Assert.assertEquals(getWebDriver().findElement(By.className("inventory_item_price")).getText(), price);
        Assert.assertEquals(getWebDriver().findElement(By.cssSelector("[class='inventory_item_name']")).getText(), name);
    }

    @Test
    public void test2() {
        getWebDriver().findElement(By.name("continue-shopping")).click();
        System.out.printf(getWebDriver().findElement(with(By.tagName("div")).below(getWebDriver().findElement(By.cssSelector("[class='inventory_item_name ']")))).getText());
    }

    @AfterTest
    public void quit() {
        driverQuit();
    }
}
