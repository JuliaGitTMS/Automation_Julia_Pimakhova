package lesson13_Patterns;

import entities.saucedemo.User;
import entities.saucedemo.UserBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageFactory.sauceDemo.LoginPage;

public class SauceDemoLoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage();
        loginPage.homePage();
    }

    @Test(dataProvider = "userName_&_password")
    public void chainLoginTest(String name, String password, String loginStatus) {
        loginPage
                .enterUsername(name)
                .enterPassword(password)
                .loginClick();
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

    @Test
    public void valueObjectLoginTest() {
        loginPage.enterUsername(new User() {{
                    setUsername("standard_user");
                }})
                .enterPassword(new User() {{
                    setPassword("secret_sauce");
                }})
                .loginClick()
                .successfulLoginVerification();
    }

    @Test
    public void userBuilderLoginTest() {
        loginPage.enterUsername(UserBuilder.builder().withUsername("standard_user").build())
                 .enterPassword(UserBuilder.builder().withPassword("secret_sauce").build())
                 .loginClick()
                 .successfulLoginVerification();
    }
}
