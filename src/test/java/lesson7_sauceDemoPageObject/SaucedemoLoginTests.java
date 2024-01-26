package lesson7_sauceDemoPageObject;

import entities.saucedemo.User;
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
        loginPage.enterUsername(new User() {{
            setUsername(loginPage.getUsernames().get(1));
        }});
        loginPage.enterPassword(new User() {{
            setPassword(loginPage.getPassword());
        }});
        loginPage.loginClick();
        loginPage.unSuccessfulLoginVerification();
    }

    @Test
    public void loginPageTest3() {
        loginPage.enterUsername(new User() {{
            setUsername(loginPage.getUsernames().get(2));
        }});
        loginPage.enterPassword(new User() {{
            setPassword(loginPage.getPassword());
        }});
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }

    @Test
    public void loginPageTest4() {
        loginPage.enterUsername(new User() {{
            setUsername(loginPage.getUsernames().get(3));
        }});
        loginPage.enterPassword(new User() {{
            setPassword(loginPage.getPassword());
        }});
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }

    @Test
    public void loginPageTest5() {
        loginPage.enterUsername(new User() {{
            setUsername(loginPage.getUsernames().get(4));
        }});
        loginPage.enterPassword(new User() {{
            setPassword(loginPage.getPassword());
        }});
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }

    @Test
    public void loginPageTest6() {
        loginPage.enterUsername(new User() {{
            setUsername(loginPage.getUsernames().get(5));
        }});
        loginPage.enterPassword(new User() {{
            setPassword(loginPage.getPassword());
        }});
        loginPage.loginClick();
        loginPage.successfulLoginVerification();
    }

    @Test
    public void loginPageTest7() {
        loginPage.enterUsername(new User() {{
            setUsername(loginPage.getUsernames().get(0));
        }});
        loginPage.enterPassword(new User() {{
            setPassword("");
        }});
        loginPage.loginClick();
        loginPage.unSuccessfulLoginVerification();
    }

    @Test
    public void loginPageTest8() {
        loginPage.enterUsername(new User() {{
            setUsername("");
        }});
        loginPage.enterPassword(new User() {{
            setPassword(loginPage.getPassword());
        }});
        loginPage.loginClick();
        loginPage.unSuccessfulLoginVerification();
    }

}
