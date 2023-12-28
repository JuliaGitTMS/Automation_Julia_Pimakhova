package pageObjects.baseObjects;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testngUtils.InvokedListener;
import testngUtils.Listener;

import static driver.DriverType.CHROME;
import static driver.DriverType.valueOf;
import static driver.ImprovedWebDriver.createDriver;
import static driver.ImprovedWebDriver.quitDriver;
import static propertyUtils.PropertyReader.getProperties;

@Listeners({Listener.class, InvokedListener.class})
public class BaseTest {
    @BeforeTest
    public void startUp() {
        createDriver(System.getProperties().containsKey("config")
                ? valueOf(getProperties().getProperty("browser").toUpperCase())
                : CHROME);
    }

    @AfterTest
    public void tearDown() {
        quitDriver();
    }
}
