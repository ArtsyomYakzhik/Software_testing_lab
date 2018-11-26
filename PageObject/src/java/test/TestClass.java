import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class TestClass {

    private Calendar calendar;
    private MainPage mainPage;
    private ResultPage resultPage;

    @Before
    public void setUp(){
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        mainPage = new MainPage();
        mainPage.setOneWayPath();
    }

    @Test
    public void checkCorrectOutputOfBusinessOffers(){
        mainPage.setBusinessClassOnly();
        mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
        resultPage = mainPage.toResultPage();
        Assert.assertTrue( resultPage.getResultOfBusinessOffers());
    }

    @Test
    public void checkCorrectOutputOfRegistrationLuggageFilter(){
        mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
        resultPage = mainPage.toResultPage();
        resultPage.setRegistrationLuggageFilter();
        Assert.assertTrue( resultPage.getResultOfRegistrationLuggage());
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