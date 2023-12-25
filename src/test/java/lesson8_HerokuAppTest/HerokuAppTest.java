package lesson8_HerokuAppTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuApp.DynamicControlsPage;
import pageObjects.herokuApp.FramesPage;
import pageObjects.herokuApp.StartPage;
import pageObjects.herokuApp.StartPageItems;

public class HerokuAppTest extends BaseTest {
    StartPage startPage;
    DynamicControlsPage dynamicControlsPage;
    FramesPage framesPage;

    @BeforeMethod
    public void precondition() {
        startPage = new StartPage();
        dynamicControlsPage = new DynamicControlsPage();
        framesPage = new FramesPage();
        startPage.homePage("https://the-internet.herokuapp.com/");
    }

    @Test
    public void dynamicControlsTest() {
        startPage.clickOnItem(StartPageItems.DYNAMIC_CONTROLS);
        dynamicControlsPage.removeCheckBox();
        dynamicControlsPage.checkInputDisability();
        dynamicControlsPage.enableInput();
    }

    @Test
    public void framesTest (){
        startPage.clickOnItem(StartPageItems.FRAMES);
        framesPage.goToIframe();
        framesPage.checkFrameText();
    }
}
