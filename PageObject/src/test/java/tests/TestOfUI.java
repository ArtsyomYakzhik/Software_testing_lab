import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class TestOfUI {
    private MainPage mainPage;
    private Calendar calendar;
    private ResultPage resultPage;

    @Before
    public void onSetup(){
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        mainPage = new MainPage();
        mainPage.setOneWayPath();
        mainPage.fillOneWayFields("Minsk", "Tokyo", calendar);
    }

    @Test
    public void checkSwipeAirports()
    {
        String concatOfAirport = mainPage.getFromAirPort() + mainPage.getToAirPort();
        mainPage.clickSwipeAirportButton();
        Assert.assertTrue(concatOfAirport == mainPage.getToAirPort() + mainPage.getFromAirPort());
    }

    @After
    public void stopBrowser(){
        DriverSingelton.closeDriver();
    }
}
