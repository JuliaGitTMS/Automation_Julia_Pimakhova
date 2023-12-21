package pageObjects.herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class FramesPage extends BasePage {
    private final By iframeLink = By.linkText("iFrame");
    private final By frame = By.id("mce_0_ifr");
    private final By frameText = By.tagName("p");

    public void goToIframe() {
        click(iframeLink);
    }

    public void checkFrameText() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(frame)));
        driver.switchTo().frame(driver.findElement(frame));
        wait.until(ExpectedConditions.textToBe(frameText, "Your content goes here."));
    }
}
