package pageObjects.sauceDemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class PaymentInformationPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");

    public void enterFirstName (String name){
        sendKeys(firstName,name);
    }
    public void enterLastName (String name){
        sendKeys(lastName,name);
    }
    public void enterPostalCode (String code){
        sendKeys(postalCode,code);
    }
    public void pressContinue (){
        click(continueButton);
    }
}
