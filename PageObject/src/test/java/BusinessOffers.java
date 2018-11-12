import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
/*
Test case for checking right output for business class offers
 */

public class BusinessOffers {

    @Test
    public void checkBusinessOffers(){
            Calendar calendar = Calendar.getInstance();
            calendar.set(2018, 11, 3);
            MainPage mainPage = new MainPage();
            mainPage.setBusinessClassOnly();
            mainPage.setOneWayPath();
            mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
            ResultPage resultPage = mainPage.toResultPage();
            Assert.assertEquals(0, resultPage.getResultOfBusinessOffers());
    }
}