package pageObjects.sauceDemo;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;

import static driver.ImprovedWebDriver.getWebDriver;

public class ShoppingCartPage extends BasePage {
    private final By header = By.className("app_logo");
    private final By menu = By.id("react-burger-menu-btn");
    private final By itemsList = By.className("cart_item");
    private final By removeButton = By.tagName("button");
    private final By itemName = By.className("inventory_item_name");
    private final By itemPrice = By.className("inventory_item_price");
    private final By continueShoppingButton = By.name("continue-shopping");
    private final By checkOutButton = By.id(("checkout"));

    public void verifyPage() {
        Assert.assertEquals(getWebDriver().findElement(header).getText(), "Swag Labs");
        wait.until(ExpectedConditions.elementToBeClickable(menu));
    }

    public void removeProduct(Integer index) {
        click(driver.findElements(itemsList).get(index).findElement(removeButton));
    }

    public int countProducts() {
        return driver.findElements(itemsList).size();
    }

    public String verifyProductName(Integer index) {
        return driver.findElements(itemsList).get(index).findElement(itemName).getText();
    }

    public String verifyProductPrice(Integer index) {
        return driver.findElements(itemsList).get(index).findElement(itemPrice).getText();
    }

    public void pressCheckout (){
        click(checkOutButton);
    }
}
