package pageObjects.sauceDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import static driver.ImprovedWebDriver.getWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private final By header = By.className("app_logo");
    private final By menu = By.id("react-burger-menu-btn");
    private final By shoppingCart = By.className("shopping_cart_link");
    private final By filter = By.className("product_sort_container");
    private final By productList = By.className("inventory_item");
    private final By itemName = By.className("inventory_item_name");
    private final By itemPrice = By.className("inventory_item_price");
    private final By addRemoveButton = By.tagName("button");

    public void verifyPage (){
        Assert.assertEquals(getWebDriver().findElement(header).getText(), "Swag Labs" );
        wait.until(ExpectedConditions.elementToBeClickable(menu));
        wait.until(ExpectedConditions.elementToBeClickable(filter));
        Assert.assertFalse(driver.findElements(productList).isEmpty(), "Product list is empty");
    }

    public void addProductToCart (Integer index){
        click(driver.findElements(productList).get(index).findElement(addRemoveButton));
    }
    public void goToShoppingCart (){
        click(shoppingCart);
    }
    public String verifyProductName (Integer index){
        return driver.findElements(productList).get(index).findElement(itemName).getText();
    }
    public String verifyProductPrice (Integer index){
        return driver.findElements(productList).get(index).findElement(itemPrice).getText();
    }
}
