package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class ImprovedWebDriver {
    private static WebDriver webDriver;

    public static void createDriver(DriverType driverType) {
        if (webDriver == null) {
            switch (driverType) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    webDriver = new ChromeDriver(chromeOptions);
                    break;
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("start-maximized");
                    webDriver = new FirefoxDriver(firefoxOptions);
                    break;
            }
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quitDriver (){
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
