import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class MainPage {


    private final String url = "https://aviago.by/";
    private final String facebookUrl = "https://www.facebook.com/avialtpuslapis/";

    enum Direction {NONE ,UP, DOWN}

    @FindBy(id = "outDate")
    private WebElement calendarInput;

    @FindBy(xpath = "//*[@for='journey-oneway']")
    private WebElement oneWayModeButton;

    @FindBy(xpath = "//*[@title='Facebook']")
    private WebElement facebookButton;

    @FindBy(xpath = "//label[@for='cabin2']")
    private WebElement businessClassCheckBox;

    @FindBy(xpath = "//div[@class='element']/div[@class='button']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class='fa fa-exchange blue']")
    private WebElement swipeButton;

    private WebDriver driver;
    private WebDriverWait wait;


    public MainPage(){
        driver = DriverSingelton.getDriver();
        wait = new WebDriverWait(this.driver, 50);
        driver.get(url);
        PageFactory.initElements(this.driver, this);
    }

    public void fillOneWayFields(String fromdestination, String todestination, Calendar senddate){
        setFieldValue("cty0", fromdestination);
        setFieldValue("cty1", todestination);
        setSendDate(senddate);
    }

    private void setFieldValue(String fieldid, String airportname){
        driver.findElement(By.id(fieldid)).sendKeys(airportname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(@class='autocomplete-suggestions') and (not(contains(@style,'display: none'))) and (not(contains(@data-index, .)))]")));
        driver.findElement(By.xpath("//div[(@class='autocomplete-suggestions') and (not(contains(@style,'display: none'))) and (not(contains(@data-index, .)))]/div[@data-index]")).click();
    }

    private void setSendDate(Calendar senddate){
        calendarInput.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outCalHolder")));
        driver.findElement(By.xpath(String.format("//td[@data-year='%d' and @data-month='%d']//a[text()='%d']/..",
                senddate.get(Calendar.YEAR),
                senddate.get(Calendar.MONTH),
                senddate.get(Calendar.DAY_OF_MONTH)))).click();
    }

    public void setBusinessClassOnly() {
        businessClassCheckBox.click();
    }

    public void setOneWayPath(){
        oneWayModeButton.click();

    }

    public void increaseNumberOfChilds(){
        changeNumberOfPassangers("children", Direction.UP.ordinal());
    }

    public void decreaseNumberOfAdults(){
        changeNumberOfPassangers("adults", Direction.DOWN.ordinal());
    }

    public void changeNumberOfPassangers(String typeOfPassanger, int typeOfChange){
        driver.findElement(By.xpath(String.format("//input[@id='%s']/parent::*/a[%d]", typeOfPassanger, typeOfChange))).click();
    }

    public boolean isPageHaveErrorMessage(){
        return driver.findElement(By.xpath("//*[contains(@id, 'error')]")) != null;
    }

    public void toFacebookIntegration(){
        facebookButton.click();
    }

    public boolean isFacebookPage(){
        return facebookUrl == driver.getCurrentUrl();
    }

    public ResultPage toResultPage() {
        clickSubmit();
        return new ResultPage(driver);
    }

    public void clickSubmit(){
        submitButton.submit();
    }

    public void clickSwipeAirportButton(){
        swipeButton.click();
    }

    public String getFromAirPort(){
        return driver.findElement(By.id("cty0")).getText();
    }

    public String getToAirPort(){
        return driver.findElement(By.id("cty1")).getText();
    }
}