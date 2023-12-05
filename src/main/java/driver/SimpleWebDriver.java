package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleWebDriver {
    private static WebDriver webDriver;

//    static {
//        if (webDriver == null) {
//            webDriver = new ChromeDriver();
//        }
//    }

    public static void driverSetUp (String url) {
        if (webDriver == null) {
            webDriver = new ChromeDriver(chromeOptions());
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        webDriver.get(url);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void driverQuit (){
        webDriver.quit();
    }

    public static ChromeOptions chromeOptions (){
        return new ChromeOptions().addArguments("start-maximized");
    }
}

