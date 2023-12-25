package pageObjects.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class FinalPayingPage extends BasePage {
    private final By itemList = By.className("cart_item");
    private final By finishButton = By.id("finish");

    public void pressFinish (){
        click(finishButton);
    }
    public void successfulPaymentVerification (){
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-complete.html"));
    }
}
