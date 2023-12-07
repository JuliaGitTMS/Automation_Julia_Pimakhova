package lesson5_FloorCalculatorTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;

public class LaminateTest {

    @BeforeTest
    public void setUp() {
        driverSetUp("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test(priority=2)
    public void test1() {
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys("9");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys("7");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys("1500");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys("190");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys("12");
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_price")).sendKeys("30");
        Select floorDirection = new Select(getWebDriver().findElement(By.name("calc_direct")));
        floorDirection.selectByValue("toh");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys("200");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.CONTROL + "a");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys("10");
        getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']")).click();
        Assert.assertEquals(getWebDriver().findElement(By.id("s_lam")).getText(), "62.68 м2.");
    }

    @Test(priority=3)
    public void test2() {
        getWebDriver().findElement(By.name("calc_roomwidth")).clear();
        getWebDriver().findElement(By.name("calc_roomheight")).clear();
        getWebDriver().findElement(By.name("calc_lamwidth")).clear();
        getWebDriver().findElement(By.name("calc_lamheight")).clear();
        getWebDriver().findElement(By.name("calc_inpack")).clear();
        getWebDriver().findElement(By.name("calc_price")).clear();
        Select floorDirection = new Select(getWebDriver().findElement(By.name("calc_direct")));
        floorDirection.selectByValue("tow");
        getWebDriver().findElement(By.name("calc_bias")).clear();
        getWebDriver().findElement(By.name("calc_walldist")).clear();
        getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']")).click();
        Assert.assertEquals(getWebDriver().findElement(By.id("s_lam")).getText(), "1.00 м2.");
    }

    @Test (priority=1)
    public void test3() {
        getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']")).click();
        Assert.assertEquals(getWebDriver().findElement(By.id("s_lam")).getText(), "17.82 м2.");
    }

    @AfterTest
    public void quit() {
        driverQuit();
    }
}
