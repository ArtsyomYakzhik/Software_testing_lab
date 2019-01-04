import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class TestOfValidation {

    private MainPage mainPage;

    @Before
    public void onSetup(){
        mainPage = new MainPage();
        mainPage.setOneWayPath();
    }

    @Test
    public void checkSocialNetworkIntegrationWithFacebook(){
        mainPage.toFacebookIntegration();
        Assert.assertTrue(mainPage.isFacebookPage());
    }

    @Test
    public void checkDifferenceLanguageSearch(){
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        mainPage.fillOneWayFields("Minsk", "Москва", calendar);
        ResultPage resultPage = mainPage.toResultPage();
        Assert.assertFalse(resultPage.isSearchEndWithError());
    }

    @Test
    public void checkFieldValidationOfBlankAllFields(){
        mainPage.clickSubmit();
        Assert.assertTrue(mainPage.isPageHaveErrorMessage());
    }

    @After
    public void stopBrowser(){
        DriverSingelton.closeDriver();
    }
}
