package lesson7_sauceDemoPageObject;

import entities.saucedemo.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.sauceDemo.*;

public class SaucedemoTests extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    PaymentInformationPage paymentInformationPage;
    FinalPayingPage finalPayingPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        paymentInformationPage = new PaymentInformationPage();
        finalPayingPage = new FinalPayingPage();
        loginPage.homePage("https://www.saucedemo.com");
        loginPage.enterUsername(new User() {{
            setUsername(loginPage.getUsernames().get(0));
        }});
        loginPage.enterPassword(new User() {{
            setPassword(loginPage.getPassword());
        }});
        loginPage.loginClick();
    }

    @Test(priority = 1)
    public void addProductToCartTest() {
        productPage.verifyPage();
        productPage.addProductToCart(0);
        productPage.addProductToCart(1);
        String productName = productPage.verifyProductName(0);
        String productPrice = productPage.verifyProductPrice(0);
        productPage.goToShoppingCart();
        shoppingCartPage.verifyPage();
        Assert.assertEquals(shoppingCartPage.verifyProductName(0), productName);
        Assert.assertEquals(shoppingCartPage.verifyProductPrice(0), productPrice);
    }

    @Test(priority = 2)
    public void removeProductFromCartTest() {
        productPage.goToShoppingCart();
        int initialCartSize = shoppingCartPage.countProducts();
        shoppingCartPage.removeProduct(0);
        int finalCartSize = shoppingCartPage.countProducts();
        Assert.assertEquals(finalCartSize, initialCartSize - 1);
    }
    @Test (priority = 3)
    public void paymentTest (){
        shoppingCartPage.pressCheckout();
        paymentInformationPage.enterFirstName(new User() {{setFirstName("Peter");}});
        paymentInformationPage.enterLastName(new User() {{setLastName("Parker");}});
        paymentInformationPage.enterPostalCode(new User() {{setPostalCode("12345");}});
        paymentInformationPage.pressContinue();
        finalPayingPage.pressFinish();
        finalPayingPage.successfulPaymentVerification();
    }
}
