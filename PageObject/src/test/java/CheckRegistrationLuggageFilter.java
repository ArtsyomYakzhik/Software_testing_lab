import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class CheckRegistrationLuggageFilter {
    @Test
    public void testRegistrationLuggageFilter(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 3);
        MainPage mainPage = new MainPage();
        mainPage.setOneWayPath();
        mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
        ResultPage resultPage = mainPage.toResultPage();
        resultPage.setRegistrationLuggageFilter();
        Assert.assertEquals(0, resultPage.getResultOfRegistrationLuggage());
    }
}
