import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class MainTestClass {

    private Calendar calendar;
    private MainPage mainPage;
    private ResultPage resultPage;

    @Before
    public void setUp(){
        calendar = Calendar.getInstance();
        calendar.set(2018, 11, 15);
        mainPage = new MainPage();
        mainPage.setOneWayPath();
    }

    @Test
    public void checkCorrectOutputOfBusinessOffers(){
        mainPage.setBusinessClassOnly();
        mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
        resultPage = mainPage.toResultPage();
        Assert.assertEquals(0, resultPage.getResultOfBusinessOffers());
    }

    @Test
    public void checkCorrectOutputOfRegistrationLuggageFilter(){
        mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
        resultPage = mainPage.toResultPage();
        resultPage.setRegistrationLuggageFilter();
        Assert.assertEquals(0, resultPage.getResultOfRegistrationLuggage());
    }

    @Test
    public  void checkInabilityOfToOrderTicketsWithChildsAndWithoutAdult(){
        mainPage.increaseNumberOfChilds();
        mainPage.decreaseNumberOfAdults();
        mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
        resultPage = mainPage.toResultPage();
        Assert.assertFalse(resultPage.isResultEndWithError());
    }

    @After
    public void stopBrowser(){
        DriverSingelton.closeDriver();
    }
}