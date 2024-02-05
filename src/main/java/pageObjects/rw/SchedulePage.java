package pageObjects.rw;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SchedulePage {
    private final List<SelenideElement> schedule = $$(".sch-table__body .sch-table__row");

    private final SelenideElement scheduleRow = $(".sch-table__body .sch-table__row");
    private final SelenideElement fromTime = $(".train-from-time");
    private final SelenideElement routeTime = $(".train-duration-time");
    private final SelenideElement route = $("div[class=\"sch-title__title h2\"]");

    public List<String> getScheduleRow(SelenideElement e) {
        List<String> oneRow = new ArrayList<>();
        oneRow.add(e.shouldBe(enabled).$(".train-from-time").text());
        oneRow.add(e.shouldBe(enabled).$(".train-duration-time").text());
        return oneRow;
    }

    public SchedulePage getSchedule() {
        List<List<String>> result = new ArrayList<>();
        for (SelenideElement e : schedule) {
            if (!getScheduleRow(e).get(0).isEmpty()) {
                result.add(getScheduleRow(e));
            }
        }
        Map<String, List<List<String>>> resultMap = new HashMap<>();
        resultMap.put(route.text(), result);
        System.out.println(resultMap);
        return this;
    }
}
