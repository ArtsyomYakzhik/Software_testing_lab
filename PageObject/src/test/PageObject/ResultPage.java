import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ResultPage {

    private WebDriver driver;

    private WebDriverWait wait;

    public ResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 50);
        waitLoadingPage();
    }

    private void waitLoadingPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("isLoaded")));
    }

    public void setRegistrationLuggageFilter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='filter-baggage']")));
        driver.findElement(By.xpath("//label[@for='filter-baggage']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public int getResultOfBusinessOffers(){
        int countOfAllOffers, countOfBusinessClassesOffers;
        countOfAllOffers = driver.findElements(By.xpath("//td[@class='grey flight_num']//text()/..")).size();
        countOfBusinessClassesOffers = driver.findElements(By.xpath("//i[@class='fa fa-briefcase orange']")).size();
        quitWebDriver();
        return countOfAllOffers - countOfBusinessClassesOffers;
    }

    public int getResultOfRegistrationLuggage(){
        int countOfOffersWithRegistrationLuggage, countOfAllOffers;
        countOfAllOffers = driver.findElements(By.xpath("//td[@class='grey flight_num']//text()/..")).size();
        countOfOffersWithRegistrationLuggage = driver.findElements(By.xpath("//span[@class='baggage' and contains(text(),'бесплатно')]")).size();
        quitWebDriver();
        return countOfAllOffers - countOfOffersWithRegistrationLuggage;
    }

    public void quitWebDriver(){
        driver.quit();
        driver = null;
    }
}
