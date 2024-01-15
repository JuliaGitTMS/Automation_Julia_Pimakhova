package lesson9_sauceDemoTest;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.sauceDemo.LoginPage;
import pageObjects.sauceDemo.ProductPage;
import pageObjects.sauceDemo.ShoppingCartPage;

public class SauceDemoCartTest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    Integer counter = 0;

    @BeforeClass
    public void preconditions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        loginPage.homePage("https://www.saucedemo.com/");
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.loginClick();
    }

    @Description("Add and remove product to cart Test")
    @Step("Invocation count test")
    @Test(priority = 1, invocationCount = 5)
    public void addProductsTest() {
        productPage.addProductToCart(counter++);
        productPage.verifyBadgeCart("1");
        productPage.goToShoppingCart();
        shoppingCartPage.removeProduct(0);
        shoppingCartPage.checkIfCartIsEmpty();
        shoppingCartPage.gotoAllItems();
    }

    @Step("Data provider test")
    @Test(priority = 2, dataProvider = "item_name")
    public void addProductsTest(String name) {
        productPage.addProductToCart(name);
        productPage.verifyBadgeCart("1");
        productPage.goToShoppingCart();
        shoppingCartPage.removeProduct(name);
        shoppingCartPage.checkIfCartIsEmpty();
        shoppingCartPage.gotoAllItems();
    }

    @DataProvider(name = "item_name")
    public Object[][] getData() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"}
        };
    }

}
