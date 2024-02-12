package lesson17_Selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HomePage;
import pageObjects.rw.SchedulePage;


public class RWSelenideTests extends BaseTestSelenide {

    @Test (dataProvider = "from_to")
    public void rwTestRoute (String from, String to){
        getStartPage(HomePage.class)
                .clickSearchByRoute()
                .enterFrom(from)
                .enterTo(to)
                .searchClick();
    }

    @DataProvider(name = "from_to")
    public Object[][] getData1() {
        return new Object[][]{
                {"Минск", "Брест"},
                {"Минск", "Минск"},
                {"Минск", ""}
        };
    }

    @Test (dataProvider = "station")
    public void rwTestStation (String station){
        getStartPage(HomePage.class)
                .clickSearchByStation()
                .enterStation(station)
                .searchStClick();
    }

    @DataProvider(name = "station")
    public Object[][] getData2() {
        return new Object[][]{
                {"Брест"},
                {"Минск"},
                {"123"}
        };
    }
    @Test
    public void rwTestDataTable (){
        getStartPage(HomePage.class)
                .clickSearchByRoute()
                .enterFrom("Брест")
                .enterTo("Минск")
                .searchClick();
        get(SchedulePage.class)
                .getSchedule();
    }
}
