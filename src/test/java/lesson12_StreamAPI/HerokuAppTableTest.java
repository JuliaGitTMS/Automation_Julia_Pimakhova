package lesson12_StreamAPI;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuApp.SortableDataTablesPage;

public class HerokuAppTableTest extends BaseTest {
    @Test (priority =1)
    public void changeEmailTest (){
        SortableDataTablesPage sortableDataTablesPage=new SortableDataTablesPage();
        System.out.println(sortableDataTablesPage.makeAllEmailsGmail(1));
    }
}
