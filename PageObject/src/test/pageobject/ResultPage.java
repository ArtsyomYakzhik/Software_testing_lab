import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sortwait")));
    }

    public int getResultOfBusinessOffers(){
        int countOfAllOffers = getCountOfAllOffers(),
                countOfBusinessClassesOffers = driver.findElements(By.xpath("//i[@class='fa fa-briefcase orange']")).size();
        return countOfAllOffers - countOfBusinessClassesOffers;
    }

    public int getResultOfRegistrationLuggage(){
        int countOfOffersWithRegistrationLuggage = getCountOfAllOffers(),
                countOfAllOffers = driver.findElements(By.xpath("//span[@class='baggage' and contains(text(),'бесплатно')]")).size();
        return countOfAllOffers - countOfOffersWithRegistrationLuggage;
    }

    public int getCountOfAllOffers(){
        return driver.findElements(By.xpath("//td[@class='grey flight_num']//text()/..")).size();
    }

    public boolean isResultEndWithError(){
        return driver.findElements(By.xpath("//div[contains(text(), 'Поиск не дал результатов')]")).isEmpty();
    }
}
