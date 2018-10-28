import org.
import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Test case for checking right output for business class offers
 */

public class TestCase {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        String url = "https://aviago.by/";

        WebDriver driver = new ChromeDriver();

        try {
            driver.get(url);

            MainPage mainpage = new MainPage(driver);

            ResultPage resultPage = new ResultPage(mainpage.toResultPage());

            Asserts.check(resultPage.checkErrors(),"Result have non business class offers");
        }

        finally{

            driver.close();

        }
    }
}