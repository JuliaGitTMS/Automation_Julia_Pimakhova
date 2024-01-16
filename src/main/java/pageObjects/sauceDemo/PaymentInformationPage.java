package pageObjects.sauceDemo;

import entities.saucedemo.User;
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
    public void enterFirstName (User user){ sendKeys(firstName, user.getFirstName());}
    public void enterLastName (String name){
        sendKeys(lastName,name);
    }
    public void enterLastName (User user){
        sendKeys(lastName, user.getLastName());
    }
    public void enterPostalCode (String code){
        sendKeys(postalCode,code);
    }
    public void enterPostalCode (User user){
        sendKeys(postalCode, user.getPostalCode());
    }
    public void pressContinue (){
        click(continueButton);
    }
}
