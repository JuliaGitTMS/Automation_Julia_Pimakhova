package lesson12_StreamAPI;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuApp.StartPage;
import pageObjects.herokuApp.StartPageItems;

public class HerokuAppStartPageTest extends BaseTest {

    @Parameters("item")
    @Test
    public void itemNavigationTest (String item){
        StartPage startPage = new StartPage();
        startPage.homePage();
        startPage.clickOnItem(StartPageItems.valueOf(item.toUpperCase()));
    }
}
