import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class MainPage {

    private WebDriver driver;
    private String url = "https://aviago.by/";
    private WebDriverWait wait;


    public MainPage(){
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(this.driver, 50);
        driver.get(url);
    }

    public void fillOneWayFields(String fromdestination, String todestination, Calendar senddate){
        setFieldValue("cty0", fromdestination);
        setFieldValue("cty1", todestination);
        setSendDate(senddate);
    }

    private void setFieldValue(String fieldid, String airportname){
        driver.findElement(By.id(fieldid)).sendKeys(airportname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(@class='autocomplete-suggestions') and (not(contains(@style,'display: none'))) and (not(contains(@data-index, .)))]")));
        driver.findElement(By.xpath("//div[(@class='autocomplete-suggestions') and (not(contains(@style,'display: none'))) and (not(contains(@data-index, .)))]/div[2]")).click();
    }

    private void setSendDate(Calendar senddate){
        driver.findElement(By.id("outDate")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outCalHolder")));
        driver.findElement(By.xpath("//td[@data-year='"+String.valueOf(senddate.get(Calendar.YEAR))+
                "' and @data-month='"+String.valueOf(senddate.get(Calendar.MONTH))+"']//a[text()='"
                +String.valueOf(senddate.get((Calendar.DAY_OF_MONTH)))+"']/..")).click();
    }

    public void setBusinessClassOnly() {
        driver.findElement(By.xpath("//label[@for='cabin2']")).click();
    }

    public void setOneWayPath(){
        driver.findElement(By.xpath("//*[@for='journey-oneway']")).click();
    }

    public ResultPage toResultPage() {
        driver.findElement(By.xpath("//div[@class='element']/div[@class='button']")).submit();
        return new ResultPage(driver);
    }
}