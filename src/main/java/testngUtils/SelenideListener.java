package testngUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;

import static propertyUtils.PropertyReader.getProperties;
import static propertyUtils.PropertyReader.setUpProperty;
import static com.codeborne.selenide.Configuration.*;
public class SelenideListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        if (System.getProperties().containsKey("config")){
            setUpProperty(System.getProperty("config"));
            setUpConfiguration();
        }
    }
    public void setUpConfiguration (){
        baseUrl= getProperties().getProperty("baseUrl");
        headless = Boolean.parseBoolean(getProperties().getProperty("headless"));
        timeout = Long.parseLong(getProperties().getProperty("timeout"));
    }
}
