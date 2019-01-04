import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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

    private WebDriver driver;
    private WebDriverWait wait;

    public ResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 50);
        waitLoadingPage();
        PageFactory.initElements(this.driver, this);
    }

    private void waitLoadingPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("isLoaded")));
        PageFactory.initElements(this.driver, this);
    }

    public void setRegistrationLuggageFilter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='filter-baggage']")));
        luggageFilter.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sortwait")));
    }

    public int getResultOfBusinessOffers(){
        return businessClassOffers.size();
    }

    public int getResultOfRegistrationLuggage(){
        return luggageRegistrationOffers.size();
    }

    public int getCountOfAllOffers(){
        return listOfAllOffers.size();
    }

    public boolean isSearchEndWithError(){
        return !driver.findElements(By.xpath("//div[contains(text(), 'Поиск не дал результатов')]")).isEmpty();
    }

    public int getReultOfWithChangedTimeZoneOffers(){
        return driver.findElements(By.xpath("//*[@class='red small']")).size();
    }

    public Float[] getArrayCostOfOffers(){
        List<WebElement> listOfOffers = driver.findElements(By.xpath("//*[@class='big price']/*"));
        List<Float> listOfPrices = new ArrayList <Float>();
        for(int i=0; i <= listOfOffers.size() - 1; i++)
            listOfPrices.add(Float.valueOf(listOfOffers.get(i).getText().replace(',', '.').replaceAll("[^\\d.]+|\\.(?!\\d)", "")));
        return listOfPrices.toArray(new Float[listOfPrices.size()]);
    }
}
