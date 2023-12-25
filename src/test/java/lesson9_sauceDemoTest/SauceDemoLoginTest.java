package lesson9_sauceDemoTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.sauceDemo.LoginPage;

public class SauceDemoLoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage();
        loginPage.homePage("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "userName_&_password")
    public void loginTest(String name, String password, String loginStatus) {
        loginPage.enterUsername(name);
        loginPage.enterPassword(password);
        loginPage.loginClick();
        if (loginStatus.equals("success")) {
            loginPage.successfulLoginVerification();
        } else {
            loginPage.unSuccessfulLoginVerification();
        }
    }

    @DataProvider(name = "userName_&_password")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "success"},
                {"standard_user", "", "fail"},
                {"", "secret_sauce", "fail"},
                {"standard_user", "standard_user", "fail"}
        };
    }
}
