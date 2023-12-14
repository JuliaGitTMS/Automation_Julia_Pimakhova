package pageObjects.baseObjects;
import driver.DriverType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static driver.ImprovedWebDriver.*;

public class BaseTest {

    @BeforeTest
    public void startUp (){
        createDriver(DriverType.CHROME);
    }

    @AfterTest
    public void tearDown (){
        quitDriver();
    }
}
