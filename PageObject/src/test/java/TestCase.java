import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
Test case for checking right output for business class offers
 */

public class TestCase {

    @Test
    public void checkBusinessOffers(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        String url = "https://aviago.by/";

        WebDriver driver = new ChromeDriver();

        try {
            driver.get(url);

            MainPage mainpage = new MainPage(driver);

            ResultPage resultPage = new ResultPage(mainpage.toResultPage());

            Assert.assertTrue( "Result have non business class offers", resultPage.checkErrors());
        }

        finally{

            driver.quit();
            driver = null;

        }
    }
}