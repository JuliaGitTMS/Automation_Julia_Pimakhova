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
    private final By allItems = By.id("inventory_sidebar_link");

    public void verifyPage() {
        Assert.assertEquals(getWebDriver().findElement(header).getText(), "Swag Labs");
        wait.until(ExpectedConditions.elementToBeClickable(menu));
    }

    public void removeProduct(Integer index) {
        click(driver.findElements(itemsList).get(index).findElement(removeButton));
    }
    public void removeProduct(String productName) {
        for (int i=0; i<this.countProducts(); i++){
            if (driver.findElements(itemName).get(i).getText().equals(productName)){
                click(driver.findElements(itemsList).get(i).findElement(removeButton));
                break;
            }
        }
    }

    public int countProducts() {
        return driver.findElements(itemsList).size();
    }

    public String verifyProductName(Integer index) {
        return driver.findElements(itemsList).get(index).findElement(itemName).getText();
    }

    public void checkIfCartIsEmpty() {
       Assert.assertEquals(this.countProducts(),0);
    }

    public String verifyProductPrice(Integer index) {
        return driver.findElements(itemsList).get(index).findElement(itemPrice).getText();
    }

    public void pressCheckout() {
        click(checkOutButton);
    }

    public void gotoAllItems() {
        this.click(menu);
        wait.until(ExpectedConditions.elementToBeClickable(allItems));
        this.click(allItems);
    }
}
