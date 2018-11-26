import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ResultPage {

    @FindBy(xpath = "//label[@for='filter-baggage']")
    private WebElement luggageFilter;

    @FindBy(xpath = "//td[@class='grey flight_num']//text()/..")
    private List<WebElement> listOfAllOffers;

    @FindBy(xpath = "//i[@class='fa fa-briefcase orange']")
    private List<WebElement> businessClassOffers;

    @FindBy(xpath = "//span[@class='baggage' and contains(text(),'бесплатно')]")
    private List<WebElement> luggageRegistrationOffers;

    @FindBy(xpath = "//div[contains(text(), 'Поиск не дал результатов')]")
    private List<WebElement> errorBlock;

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
        luggageFilter.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sortwait")));
    }

    public boolean getResultOfBusinessOffers(){
        int countOfAllOffers = getCountOfAllOffers(),
        countOfBusinessClassesOffers = businessClassOffers.size();
        return countOfAllOffers == countOfBusinessClassesOffers;
    }

    public boolean getResultOfRegistrationLuggage(){
        int countOfOffersWithRegistrationLuggage = getCountOfAllOffers(),
                countOfAllOffers = luggageRegistrationOffers.size();
        return countOfAllOffers == countOfOffersWithRegistrationLuggage;
    }

    public int getCountOfAllOffers(){
        return listOfAllOffers.size();
    }

    public boolean isResultEndWithError(){
        return errorBlock.isEmpty();
    }
}
