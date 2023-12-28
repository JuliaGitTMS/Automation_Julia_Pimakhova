package lesson7_sauceDemoPageObject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.sauceDemo.LoginPage;
import pageObjects.sauceDemo.ProductPage;
import pageObjects.sauceDemo.ShoppingCartPage;

public class SaucedemoLoginTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void precondition() {
        loginPage = new LoginPage();
        loginPage.homePage();
    }

    @Test
    public void loginPageSuccessTest() {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }

    @Test
    public void loginPageTest2() {
        loginPage.enterUsername(loginPage.getUsernames().get(1));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.loginClick();
        loginPage.unSuccessfulLoginVerification();
    }
    @Test
    public void loginPageTest3() {
        loginPage.enterUsername(loginPage.getUsernames().get(2));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }
    @Test
    public void loginPageTest4() {
        loginPage.enterUsername(loginPage.getUsernames().get(3));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }
    @Test
    public void loginPageTest5() {
        loginPage.enterUsername(loginPage.getUsernames().get(4));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }
    @Test
    public void loginPageTest6() {
        loginPage.enterUsername(loginPage.getUsernames().get(5));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }
    @Test
    public void loginPageTest7() {
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword("");
        loginPage.loginClick();
        loginPage.unSuccessfulLoginVerification();
    }
    @Test
    public void loginPageTest8() {
        loginPage.enterUsername("" );
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.loginClick();
        loginPage.unSuccessfulLoginVerification();
    }

}
