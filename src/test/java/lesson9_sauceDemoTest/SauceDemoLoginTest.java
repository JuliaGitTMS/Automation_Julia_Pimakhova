package lesson9_sauceDemoTest;

import entities.saucedemo.User;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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

    @Description("Enter userName and password")
    @Step("Standard_user testing ")
    @Test(dataProvider = "userName_&_password")
    public void loginTest(User user) {
        loginPage.enterUsername(user.getUsername());
        loginPage.enterPassword(user.getPassword());
        loginPage.loginClick();
        if (user.getStatus().equals("success")) {
            loginPage.successfulLoginVerification();
        } else {
            loginPage.unSuccessfulLoginVerification();
        }
    }

    @DataProvider(name = "userName_&_password")
    public Object[][] getData() {
        return new Object[][]{
                {new User() {{
                    setUsername("standard_user");
                    setPassword("secret_sauce");
                    setStatus("success");
                }}},
                {new User() {{
                    setUsername("standard_user");
                    setPassword("");
                    setStatus("fail");
                }}},
                {new User() {{
                    setUsername("");
                    setPassword("secret_sauce");
                    setStatus("fail");
                }}},
                {new User() {{
                    setUsername("standard_user");
                    setPassword("standard_user");
                    setStatus("fail");
                }}},
        };
    }
}
