package pageObjects.herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class DynamicControlsPage extends BasePage {
    private final By removeButton = By.xpath("//form[@id='checkbox-example']/descendant::button");
    private final By goneMessage = By.xpath("//form[@id='checkbox-example']/p");
    private final By checkBox = By.id("checkbox");
    private final By input = By.tagName("input");
    private final By enableButton = By.xpath("//form[@id='input-example']/descendant::button");
    private final By enableMessage = By.xpath("//form[@id='input-example']/p");

    public void removeCheckBox() {
        click(removeButton);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(checkBox)));
        wait.until(ExpectedConditions.textToBe(goneMessage, "It's gone!"));

    }

    public void checkInputDisability() {
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(input)));
    }

    public void enableInput() {
        click(enableButton);
        wait.until(ExpectedConditions.elementToBeClickable(input));
    }

}
