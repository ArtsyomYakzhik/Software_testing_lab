import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;

public class TestOfSearchLogic {

    private Calendar calendar;
    private MainPage mainPage;
    private ResultPage resultPage;

    @Before
    public void setUp(){
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        mainPage = new MainPage();
        mainPage.setOneWayPath();
        mainPage.fillOneWayFields("Minsk", "Moscow", calendar);
    }

    @Test
    public void checkCorrectOutputOfBusinessOffers(){
        mainPage.setBusinessClassOnly();
        resultPage = mainPage.toResultPage();
        Assert.assertEquals(resultPage.getCountOfAllOffers(), resultPage.getResultOfBusinessOffers());
    }

    @Test
    public void checkCorrectOutputOfRegistrationLuggageFilter(){
        resultPage = mainPage.toResultPage();
        resultPage.setRegistrationLuggageFilter();
        Assert.assertEquals(resultPage.getCountOfAllOffers(), resultPage.getResultOfRegistrationLuggage());
    }

    @Test
    public  void checkInabilityOfToOrderTicketsWithChildsAndWithoutAdult(){
        mainPage.increaseNumberOfChilds();
        mainPage.decreaseNumberOfAdults();
        resultPage = mainPage.toResultPage();
        Assert.assertTrue(resultPage.isSearchEndWithError());
    }

    @Test
    public void checkCheapSortOfOffers(){
        resultPage = mainPage.toResultPage();
        Float[] selfSortArray = resultPage.getArrayCostOfOffers();
        Arrays.sort(selfSortArray);
        Assert.assertArrayEquals(resultPage.getArrayCostOfOffers(), selfSortArray);
    }

    //@After
    //public void stopBrowser(){
      //  DriverSingelton.closeDriver();
    //}
}